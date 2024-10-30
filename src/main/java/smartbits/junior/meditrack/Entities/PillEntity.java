package smartbits.junior.meditrack.Entities;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pills")
@NoArgsConstructor
@AllArgsConstructor
public class PillEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pill_ID;
    
    private String pill_type;
    private String pill_name;
    private double pill_concentration;
    private ArrayList<Integer> indexes;
    private String pill_usage;

}
