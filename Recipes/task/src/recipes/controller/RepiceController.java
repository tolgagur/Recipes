package recipes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import recipes.dto.Recipe;
import recipes.repository.RecipeRepository;
import recipes.service.AuthenticationService;
import recipes.service.RepiceService;
import recipes.dto.user.User;

import javax.validation.Valid;
import java.security.Principal;
import java.util.*;

@RestController
@Validated
public class RepiceController {
    
    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RepiceService repiceService;

    @Autowired
    private final AuthenticationService authenticationService;

    public RepiceController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping(path = "/api/recipe/new", consumes = "application/json", produces = "application/json")
    public Map postRecipe(@Valid @RequestBody Recipe recipe, Principal principal){
        User user = authenticationService.findUserByEmail(principal.getName());
        recipe.setUser(user);

        if (recipe.getIngredients().isEmpty()|| recipe.getDirections().isEmpty())
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        else {
            recipeRepository.save(recipe);
            return Map.of("id",recipe.getId());
        }
    }

    @GetMapping("/api/recipe/{id}")
    public ResponseEntity<Optional> getEmployee(@PathVariable("id") Long id){
        Optional<Recipe> recipe = repiceService.getSingleRecipe(id);
        return new ResponseEntity<Optional>(recipe,HttpStatus.OK);
    }

    @DeleteMapping("/api/recipe/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id,Principal principal) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        repiceService.deleteRecipeById(id,principal);
        return ResponseEntity.noContent().build();


    }

    @PutMapping("/api/recipe/{id}")
    public ResponseEntity<Recipe> updateEmployee(@PathVariable Long id,
                                                 @Valid @RequestBody(required = false) Recipe recipe,
                                                 Principal principal){
        Optional<Recipe> recipe1 =  recipeRepository.findById(id);

        recipe.setId(id);
        if (recipe1.isPresent()){
            if (recipe.getIngredients().isEmpty()
                    || recipe.getDirections().isEmpty()
                    || recipe.getCategory().isEmpty()
                    || recipe.getName().isEmpty())
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            else
                return new ResponseEntity<Recipe>(repiceService.updateRecipeById(id,recipe,principal),HttpStatus.NO_CONTENT);
        }else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/api/recipe/search/", params = "name",method = RequestMethod.GET)
    public List<Recipe> getRecipeName(@RequestParam(required=false)String name){
        List<Recipe> recipeList =recipeRepository.findByNameContainingIgnoreCaseOrderByDateDesc(name);
        return recipeList;
    }

    @RequestMapping(value = "/api/recipe/search/", params = "category",method = RequestMethod.GET)
    public List<Recipe> getRecipeCategory(@RequestParam(required=false)String category){

        List<Recipe> recipeList =recipeRepository.findByCategoryContainsIgnoreCaseOrderByDateDesc(category);

        List<Recipe> recipeList1 =new ArrayList<Recipe>();
        for (Recipe recipe: recipeList){
            if (recipe.getCategory().toLowerCase(Locale.ROOT).equals(category.toLowerCase(Locale.ROOT))){
                recipeList1.add(recipe);
            }
        }
        return recipeList1;


    }

}
