package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import recipes.dto.Recipe;
import recipes.repository.RecipeRepository;


import java.security.Principal;
import java.util.Optional;

@Service
public class RepiceService {

    private RecipeRepository recipeRepository;

    @Autowired
    public RepiceService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void deleteRecipeById(Long toDelete, Principal principal) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(toDelete);
        Recipe recipe = optionalRecipe.orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        String requestEmail = principal.getName();
        String recipeEmail = recipe.getUser().getEmail();
        if (!recipeEmail.equals(requestEmail)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        recipeRepository.deleteById(toDelete);
    }


    public Optional<Recipe> getSingleRecipe(Long id) {
        Optional<Recipe> recipe =  recipeRepository.findById(id);
        if (recipe.isPresent()){
            return recipe;
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    public Recipe updateRecipeById(Long toUpdate, Recipe updatedRecipe, Principal principal) {
        Optional<Recipe> optionalRecipe = recipeRepository.findById(toUpdate);
        if (optionalRecipe.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        String requestEmail = principal.getName();
        String recipeOwnerEmail = optionalRecipe.get().getUser().getEmail();
        if (!recipeOwnerEmail.equals(requestEmail)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        Recipe recipe = optionalRecipe.get();
        recipe.setName(updatedRecipe.getName());
        recipe.setCategory(updatedRecipe.getCategory());
        recipe.setDate(updatedRecipe.getDate());
        recipe.setDescription(updatedRecipe.getDescription());
        recipe.setIngredients(updatedRecipe.getIngredients());
        recipe.setDirections(updatedRecipe.getDirections());

        return recipeRepository.save(recipe);
    }




}
