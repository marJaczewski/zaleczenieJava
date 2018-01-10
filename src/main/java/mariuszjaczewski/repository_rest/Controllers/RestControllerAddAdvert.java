package mariuszjaczewski.repository_rest.Controllers;

import mariuszjaczewski.repository_rest.Entities.Advertisment;
import mariuszjaczewski.repository_rest.Entities.Category;
import mariuszjaczewski.repository_rest.Entities.Image;
import mariuszjaczewski.repository_rest.Entities.User;
import mariuszjaczewski.repository_rest.api.AdvertismentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping

public class RestControllerAddAdvert {

    @Autowired
    private final AdvertismentRepository advertismentRepository;

    private byte[] tempImage;

    RestControllerAddAdvert(AdvertismentRepository advertismentRepository) {
        this.advertismentRepository = advertismentRepository;
    }


    @RequestMapping(value = "/api/addImage" , method =  RequestMethod.POST )
    public void postImage(@RequestBody MultipartFile file)   {
        System.err.println("Odebrano!");
        String fileName="";
        try{
            fileName=file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("C:\\temp\\"+fileName)));
            //  BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("/"+fileName)));

            bufferedOutputStream.write(bytes);
            bufferedOutputStream.close();

tempImage=bytes;
            System.err.println("Dodano obraz");



        }catch (IOException ex){
            //log.info("cos tam plik: "+ fileName);
        }

    }

// post image od edycji
@RequestMapping(value = "/api/addImage2" , method =  RequestMethod.POST )

public void postImage2(@RequestBody byte[] file)   {

    System.err.println("Odebrano!");
//    try{
//    byte[] bytes = file.getBytes();
//    tempImage=bytes;}
//
//    catch(IOException ex){}
    tempImage=file;



}


//    /post image od edycji










    @RequestMapping(value = "/newAdvert", method = RequestMethod.POST)
    public void postAdvert(@RequestBody AdvertismentDto advertismentDto) {

        Advertisment advertisment = new Advertisment();
        Category category = new Category();
        User user = new User();

        user.setUser_id(advertismentDto.getUser());

        //user.setUser_id(1L);

        advertisment.setTitle(advertismentDto.getTitle());
        advertisment.setDescription(advertismentDto.getDescription());
        advertisment.setUser(user);
        advertisment.setPrice(advertismentDto.getPrice());
        advertisment.setIfNew(advertismentDto.isIfNew());
        advertisment.setEnclosingDate((new Date()).toString());
        advertisment.setViews(0L);

        advertisment.setImage(tempImage);


        category.setId(advertismentDto.getCategory());

        advertisment.setCategory(category);

        category.toString();
        advertisment.toString();
        advertismentRepository.save(advertisment);

        System.err.println("Dodano ogłoszenie");

    }


    @RequestMapping(value = "/getAllAdverts", method = RequestMethod.GET)
    public List<Advertisment> getAll() {
        System.err.println("Wysłano wyszystkie ogloszenia");


        List<Advertisment> allAdvertisments = advertismentRepository.findAll();


        for (int i = 0; i < allAdvertisments.size(); i++) {
            allAdvertisments.set(i, new Advertisment(
                    allAdvertisments.get(i).getId(),
                    allAdvertisments.get(i).getTitle(),
                    allAdvertisments.get(i).getDescription(),
                    null,
                  null,
                    allAdvertisments.get(i).getPrice(),
                     allAdvertisments.get(i).isIfNew(),
                    //true,
                    allAdvertisments.get(i).getEnclosingDate(),
                    allAdvertisments.get(i).getViews(),
                    null

            ));


        }
       return allAdvertisments;
        //return null;

    }

}
