package smartbits.junior.meditrack.Controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import smartbits.junior.meditrack.Entities.RecipeEntity;
import smartbits.junior.meditrack.Services.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/get_all")
    public List<RecipeEntity> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/get_by_id/{id}")
    public RecipeEntity getRecipeById(@PathVariable int id) {
        return recipeService.getRecipeById(id);
    }

    @PostMapping("/create")
    public RecipeEntity createRecipe(@RequestBody RecipeEntity recipe) {
        if (recipe.getPillsAndCount() == null) {
            recipe.setPillsAndCount(new HashMap<>());
        }
        return recipeService.createRecipe(recipe);
    }

    @PutMapping("/update/{id}")
    public RecipeEntity updateRecipe(@PathVariable int id, @RequestBody RecipeEntity recipe) {
        recipe.setRecipe_ID(id);
        if (recipe.getPillsAndCount() == null) {
            recipe.setPillsAndCount(new HashMap<>());
        }
        return recipeService.updateRecipe(recipe);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecipe(@PathVariable int id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping("/test_req")
    public String TestRequest() {
        return "TEST REQUEST RECIPE";
    }
}