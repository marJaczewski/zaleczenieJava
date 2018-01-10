package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import mariuszjaczewski.repository_rest.Entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping

public class TemporaryRestController {

    @Autowired
    private final AdvertismentRepository advertismentRepository;

    public TemporaryRestController(AdvertismentRepository advertismentRepository) {
        this.advertismentRepository = advertismentRepository;
    }

    @RequestMapping(value = "/current/{id}", method = RequestMethod.GET)
    public List<Advertisment> advertismentGET(@PathVariable("id") Long id) {
List<Advertisment>curr = new ArrayList<Advertisment>();
//
//Advertisment tempAdvert = new Advertisment();
//tempAdvert=advertismentRepository.findOneById(id);
//
//
//        Category tempCategory=new Category();
//
//        tempCategory.setName(tempAdvert.getCategory().getName());
//
//tempAdvert.setCategory(tempCategory);
//
//curr.add(tempAdvert);

Advertisment tempAdvert = new Advertisment();
tempAdvert=advertismentRepository.findBySpecificAdvert(id);
curr.add(tempAdvert);
        return curr;


    }


}
