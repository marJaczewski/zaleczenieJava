package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import mariuszjaczewski.repository_rest.api.SearchingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertismentRepository extends JpaRepository<Advertisment, Long> {

    List<Advertisment> findAllByTitle(String Title);

    Advertisment findOneById(Long id);


    @Query(value="SELECT * FROM advertisment WHERE id = :#{#id}", nativeQuery = true)
    Advertisment findBySpecificAdvert(@Param("id") Long id);


    @Query(value="SELECT * FROM advertisment WHERE user = :#{#userId}", nativeQuery = true)
    List<Advertisment> findAllBySpecificUser(@Param("userId") Long userId);

//
//    @Query("select a from Advertisment a where a.id =: id")
//    Advertisment findWithQuery(Long id);


//    @Query("select u from User u where u.age = ?#{[0]}")
//    List<User> findUsersByAge(int age);
//
//    @Query("select u from User u where u.firstname = :#{#customer.firstname}")
//    List<User> findUsersByCustomersFirstname(@Param("customer") Customer customer);


    @Query(value = "Select * from advertisment  where price BETWEEN :#{#priceDown} AND :#{#priceUp} AND title = :#{#search} AND category= :#{#category}",nativeQuery = true)
    List<Advertisment>findResults (
            @Param("search") String search,
            @Param("category") Long category,
            @Param("priceDown")float priceDown,
            @Param("priceUp") float priceUp
            //@Param("ifNew") boolean ifNew

    );

    @Query(value = "Select * from advertisment  where price BETWEEN :#{#priceDown} AND :#{#priceUp} AND title = :#{#search} AND category= :#{#category} AND ifNew= :#{#ifNew}",nativeQuery = true)
    List<Advertisment>findResults2 (
            @Param("search") String search,
            @Param("category") Long category,
            @Param("priceDown")float priceDown,
            @Param("priceUp") float priceUp,
            @Param("ifNew") boolean ifNew

    );


}
