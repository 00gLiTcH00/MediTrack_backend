package smartbits.junior.meditrack.Entities;

import java.util.HashMap;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import smartbits.junior.meditrack.utils.HashMapConverter;

@Getter
@Setter
@Entity
@Table(name = "recipes")
@NoArgsConstructor
@AllArgsConstructor
public class RecipeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipe_ID;

    private String recipe_name;
    private String recipe_description;

    @Convert(converter = HashMapConverter.class)
    private HashMap<PillEntity, Integer> pillsAndCount;

}
