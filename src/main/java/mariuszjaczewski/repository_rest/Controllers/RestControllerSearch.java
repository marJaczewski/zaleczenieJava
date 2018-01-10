package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import mariuszjaczewski.repository_rest.Entities.Category;
import mariuszjaczewski.repository_rest.api.SearchingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//import mariuszjaczewski.repository_rest.Controllers.AdvertismentRepository;

@RestController
@RequestMapping
public class RestControllerSearch {

    @Autowired
    private final AdvertismentRepository advertismentRepository;
    private final CategoryRepository categoryRepository;


//    private String title;

    public RestControllerSearch(AdvertismentRepository advertismentRepository, CategoryRepository categoryRepository) {
        this.advertismentRepository = advertismentRepository;
        this.categoryRepository = categoryRepository;

    }



    @RequestMapping(value="/getFilterSearched/{search}/{category}/{priceDown}/{priceUp}/{newItem}/{secondHand}", method = RequestMethod.GET)


    public List<Advertisment>filterSearching(
            @PathVariable("search")String search,
             @PathVariable("category")Long category,
             @PathVariable("priceDown")float priceDown,
           @PathVariable("priceUp")float priceUp,
            @PathVariable("newItem")boolean newItem ,
            @PathVariable("secondHand")boolean secondHand
    )  {

        System.err.println(search);
         System.err.println(category);
         System.err.println(priceDown);
         System.err.println(priceUp);
         System.err.println(newItem);
        System.err.println(secondHand);



        //******************************

        List<Advertisment>results =new ArrayList<>();
if((newItem ==true && secondHand ==true)||(newItem ==false && secondHand ==false)){
    results=advertismentRepository.findResults(search, category, priceDown, priceUp);
}
else if ((newItem ==true && secondHand ==false)||(newItem ==false && secondHand ==true)){
results=advertismentRepository.findResults2(search, category, priceDown, priceUp,newItem);
}


        //******************************

        return results;
       // return null;
    }


    @RequestMapping(value = "/getSearched/{title}", method = RequestMethod.GET)
    public List<Advertisment> getSearchedAdvertisments(@PathVariable("title") String title) {
        System.err.println("wyslano wyszukane");

        List<Advertisment> allSearched = advertismentRepository.findAllByTitle(title);


//        for (int i = 0; i < allSearched.size(); i++) {
//            allSearched.set(i, new Advertisment(
//                    allSearched.get(i).getId(),
//                    allSearched.get(i).getTitle(),
//                    allSearched.get(i).getDescription(),
//                   null, null, null, null
//
//            ));
//                }

        return allSearched;
    }


    @RequestMapping(value = "/getAllCategories", method = RequestMethod.GET)

    public List<Category> allCategories() {
        System.err.println("pobrano wszystkie kategorie");

        List<Category> all = categoryRepository.allCategories();

        for (int i = 0; i < all.size(); i++) {
          //  System.err.println(all.get(i).getId());
           // System.err.println(all.get(i).getName());
            Category temp = new Category();
            temp.setId(all.get(i).getId());
            temp.setName(all.get(i).getName());
            temp.setAdvertisments(null);

            all.set(i, temp);
        }


        return all;


    }
}