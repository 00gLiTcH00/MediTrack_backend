package smartbits.junior.meditrack.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smartbits.junior.meditrack.utils.HashMapConverter;

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

    private String pill_name;
    private String pill_concentration;
    private int layer;

    @ElementCollection
    private List<Integer> indexes;
    private String pill_usage;

}
