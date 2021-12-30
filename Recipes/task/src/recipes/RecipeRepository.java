package recipes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe,Long> {
    List<Recipe> findByCategoryOrderByDateDesc(String category);



    List<Recipe> findByNameContainingIgnoreCaseOrderByDateDesc(String name);
    List<Recipe> findByCategoryContainsIgnoreCaseOrderByDateDesc(String category);


    Optional<Recipe> findById(Integer toUpdate);
}
