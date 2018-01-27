package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.User;
import mariuszjaczewski.repository_rest.login.LoggedDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {



//    @Query(value = "SELECT  user.user_id, user.role, user.email from user where user.email =:#{#email} and user.haslo =:#{#password} limit 1", nativeQuery = true)
@Query(value = "SELECT  * from user where user.email =:#{#email} and user.haslo =:#{#password} limit 1", nativeQuery = true)

User findUserByEmailAndPassword(
             @Param("email") String email,
             @Param("password") String password);



}

