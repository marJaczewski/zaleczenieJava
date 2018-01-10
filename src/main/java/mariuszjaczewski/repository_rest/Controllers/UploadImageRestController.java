package mariuszjaczewski.repository_rest.Controllers;


import mariuszjaczewski.repository_rest.Entities.Image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.IOUtils;


import java.io.*;

@RestController
@RequestMapping("/api")
public class UploadImageRestController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final ImageRepository imageRepository;


    public UploadImageRestController(ImageRepository imageRepository) {
        this.imageRepository=imageRepository;
    }



//    @RequestMapping(value = "/addImage2" , method =  RequestMethod.POST )
//
//    public void postImage(@RequestBody   MultipartFile file)   {
//        System.err.println("Odebrano!");
//        String fileName="";
//        try{
//            fileName=file.getOriginalFilename();
//            byte[] bytes = file.getBytes();
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("C:\\temp\\"+fileName)));
//
//            bufferedOutputStream.write(bytes);
//            bufferedOutputStream.close();
//
//
//            Image image = new Image();
//            image.setAdvertisment_id(1L);
//            image.setContent(bytes);
//            imageRepository.save(image);
//
//
//        }catch (IOException ex){
//            log.info("cos tam plik: "+ fileName);
//        }
//
//    }

    }






