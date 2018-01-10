package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
