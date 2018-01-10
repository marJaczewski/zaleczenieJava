package mariuszjaczewski.repository_rest.api;

import mariuszjaczewski.repository_rest.Entities.Category;
import mariuszjaczewski.repository_rest.Entities.Image;
import mariuszjaczewski.repository_rest.Entities.User;

import javax.persistence.*;
import java.util.List;

public class AdvertismentDto {

    private Long id;

    private String title;


    private String description;


    private Long category;



    private float price;


    private boolean ifNew;


    private String enclosingDate;


    private Long views;

    private List<Image>images;

    private Long user;

    public AdvertismentDto() {    }

    public AdvertismentDto(Long id, String title, String description, Long category, float price, boolean ifNew, String enclosingDate, Long views, List<Image>images, Long user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.ifNew = ifNew;
        this.enclosingDate = enclosingDate;
        this.views = views;
        this.images=images;
        this.user=user;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isIfNew() {
        return ifNew;
    }

    public void setIfNew(boolean ifNew) {
        this.ifNew = ifNew;
    }

    public String getEnclosingDate() {
        return enclosingDate;
    }

    public void setEnclosingDate(String enclosingDate) {
        this.enclosingDate = enclosingDate;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
