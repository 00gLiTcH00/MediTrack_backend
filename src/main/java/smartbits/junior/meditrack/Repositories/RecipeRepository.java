package smartbits.junior.meditrack.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import smartbits.junior.meditrack.Entities.RecipeEntity;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {
    
}
