package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAdvertismentsRestController {


    @Autowired
    private final AdvertismentRepository advertismentRepository;

    public UserAdvertismentsRestController(AdvertismentRepository advertismentRepository) {
        this.advertismentRepository=advertismentRepository;
    }

    @RequestMapping(value = "userAdverts/{userId}")
    public List<Advertisment> getUsersAdvertisments(@PathVariable("userId") Long userId){
        return advertismentRepository.findAllBySpecificUser(userId);
    }


    @RequestMapping(value = "deleteAdvert")
    public void deleteAdvert(@RequestBody Long advertId){
        advertismentRepository.delete(advertId);
    }

}
