package mariuszjaczewski.repository_rest.login;

import mariuszjaczewski.repository_rest.Controllers.UserRepository;
import mariuszjaczewski.repository_rest.Entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/logging/{email}/{password}", method = RequestMethod.GET)
    public LoggedDetails logging(
            @PathVariable("email") String email,
            @PathVariable("password") String password
    ){
System.err.println(email+" "+password);

  User user=userRepository.findUserByEmailAndPassword(email, password);


LoggedDetails loggedDetails = new LoggedDetails(user.getUser_id(), user.getRole(), user.getEmail());



return loggedDetails;
    }


}
