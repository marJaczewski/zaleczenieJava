package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


public interface CategoryRepository extends JpaRepository<Category, Long>{


//    @Query(value="Select a.id, a.name  from category a where 1", nativeQuery = true)
//    List<IdsAndNamesOfCategory> idsAndNamesOfAllCategories();

    @Query(value="Select a.id, a.name  from category a where 1", nativeQuery = true)
    List<Category>allCategories();



//    @Query(value="Select * from Category a where 1", nativeQuery = true)
//    List<Category> categories();


}
