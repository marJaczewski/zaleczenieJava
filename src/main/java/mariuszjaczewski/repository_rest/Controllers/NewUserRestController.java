package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.User;
import mariuszjaczewski.repository_rest.api.UserDto;
import mariuszjaczewski.repository_rest.login.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NewUserRestController {


    @Autowired
    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public NewUserRestController(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository=userRepository;
        this.emailSender=emailSender;
    }

    @RequestMapping("/addUser")
    public void addUser(@RequestBody UserDto userDto){
        User user = new User();

        user.setImie(userDto.getImie());
        user.setNazwisko(userDto.getNazwisko());
        user.setAddress(userDto.getAddress());
        user.setEmail(userDto.getEmail());
        user.setHaslo(userDto.getHaslo());
        user.setTelefon(userDto.getTelefon());

System.err.println(userDto.getEmail());

//for (int i =0 ; i<50 ; i++) {
    emailSender.sendEmail(userDto.getEmail(), "Witamy w serwisie", "Cześć, witamy w serwisie ogloszeń lokalnych");

//}
userRepository.save(user);
        System.err.println("Dodano użytkownika");


    }


}
