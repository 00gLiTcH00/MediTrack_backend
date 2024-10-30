package smartbits.junior.meditrack.Entities;

import java.util.HashMap;

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
@Table(name = "recipes")
@NoArgsConstructor
@AllArgsConstructor
public class RecipeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipe_ID;

    private String recipe_name;
    private String recipe_description;
    private HashMap<PillEntity, Long> pills;

}
