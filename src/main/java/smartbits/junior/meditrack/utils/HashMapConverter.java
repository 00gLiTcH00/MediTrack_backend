package smartbits.junior.meditrack.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Converter
public class HashMapConverter<K, V> implements AttributeConverter<Map<K, V>, String> {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<K, V> customerInfo) {
        if (customerInfo == null) return null;
        String customerInfoJson = null;
        try {
            customerInfoJson = objectMapper.writeValueAsString(customerInfo);
        } catch (final JsonProcessingException e) {
            log.error("JSON writing error", e);
        }

        return customerInfoJson;
    }

    @Override
    public Map<K, V> convertToEntityAttribute(String customerInfoJSON) {
        if (customerInfoJSON == null) return null;
        Map<K, V> customerInfo = null;
        try {
            customerInfo = objectMapper.readValue(customerInfoJSON, new TypeReference<HashMap<K, V>>() {
            });
        } catch (final IOException e) {
            log.error("JSON reading error", e);
        }

        return customerInfo;
    }
}
