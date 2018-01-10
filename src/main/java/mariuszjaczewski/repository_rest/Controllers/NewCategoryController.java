package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Category;
import mariuszjaczewski.repository_rest.api.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NewCategoryController {

    @Autowired
    private final CategoryRepository categoryRepository;

    public NewCategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @RequestMapping(value = "/newCategory", method = RequestMethod.POST)
    public void addCategory(@RequestBody CategoryDto categoryDto){
        Category category = new Category();

        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());



        categoryRepository.save(category);
        System.err.println("dodano kategorię");
    }


}
