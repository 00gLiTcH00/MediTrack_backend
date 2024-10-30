package smartbits.junior.meditrack.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartbits.junior.meditrack.Entities.RecipeEntity;
import smartbits.junior.meditrack.Repositories.RecipeRepository;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<RecipeEntity> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public RecipeEntity getRecipeById(int id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public RecipeEntity createRecipe(RecipeEntity recipe) {
        return recipeRepository.save(recipe);
    }

    public RecipeEntity updateRecipe(RecipeEntity recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(int id) {
        recipeRepository.deleteById(id);
    }
}