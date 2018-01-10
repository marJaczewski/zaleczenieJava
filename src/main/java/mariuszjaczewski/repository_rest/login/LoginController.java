package mariuszjaczewski.repository_rest.login;

import mariuszjaczewski.repository_rest.Controllers.AdvertismentRepository;
import mariuszjaczewski.repository_rest.Controllers.CategoryRepository;
import mariuszjaczewski.repository_rest.Entities.Advertisment;
import mariuszjaczewski.repository_rest.Entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class LoginController {

    //test
    private CategoryRepository categoryRepository;
    private AdvertismentRepository advertismentRepository;

    @Autowired
    public LoginController(CategoryRepository categoryRepository, AdvertismentRepository advertismentRepository) {
        this.categoryRepository = categoryRepository;
        this.advertismentRepository = advertismentRepository;
    }

    @RequestMapping("/getData")
    public String getDataF(){

        List<Category> listCat = categoryRepository.findAll();
        List<Advertisment> listAdv = advertismentRepository.findAll();
        return  null;

    }
}
