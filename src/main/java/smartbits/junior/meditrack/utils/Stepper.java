package smartbits.junior.meditrack.utils;

import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalOutputConfig;
import com.pi4j.io.gpio.digital.DigitalState;
import java.util.concurrent.TimeUnit;

public class Stepper {

    private final DigitalOutput stepPin;
    private final DigitalOutput dirPin;
    private int currentSteps = 0;
    private final int stepsPerRevolution;
    private boolean direction = true;
    private final Context pi4j;

    public Stepper(Context pi4j, int stepPin, int dirPin, int stepsPerRevolution) {
        this.pi4j = pi4j;
        this.stepsPerRevolution = stepsPerRevolution;

        // Configure step and direction pins
        this.stepPin = pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
                .address(stepPin)
                .initial(DigitalState.LOW)
                .shutdown(DigitalState.LOW)
                .build());

        this.dirPin = pi4j.create(DigitalOutput.newConfigBuilder(pi4j)
                .address(dirPin)
                .initial(DigitalState.LOW)
                .shutdown(DigitalState.LOW)
                .build());
    }

    public void step(int steps) {
        if (steps == 0) return;

        boolean targetDirection = steps > 0;
        if (targetDirection != direction) {
            setDirection(targetDirection);
        }

        for (int i = 0; i < Math.abs(steps); i++) {
            currentSteps += direction ? 1 : -1;

            // Set step pin HIGH to initiate a step
            stepPin.high();
            // Wait for the step pulse to register, adjust delay as needed
            try {
                TimeUnit.MICROSECONDS.sleep(1000); // 1 ms pulse, adjust if needed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Set step pin LOW to complete the step pulse
            stepPin.low();

            // Optional delay for controlling stepping speed
            try {
                TimeUnit.MILLISECONDS.sleep(2); // Adjust for motor speed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void setTargetPosition(int targetSteps) {
        int stepsToMove = targetSteps - currentSteps;
        step(stepsToMove);
    }

    private void setDirection(boolean forward) {
        direction = forward;
        dirPin.state(forward ? DigitalState.HIGH : DigitalState.LOW);
    }

    public void stop() {
        stepPin.low();
    }

    public void close() {
        stepPin.shutdown(pi4j);
        dirPin.shutdown(pi4j);
    }
}
