package mariuszjaczewski.repository_rest.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "advertisment")
public class Advertisment implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category", nullable = true)
    private Category category;
//
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = true)
    private User user;
//

    @Column(name = "price")
    private float price;

    @Column(name = "ifnew")
    private boolean ifNew;

    @Column(name = "enclosingDate")
    private String enclosingDate;

    @Column(name = "views")
    private Long views;

//    @OneToMany
//    @Column(name = "image")
//    private List<Image>images;

    @Lob
    @Column(name="image", columnDefinition="mediumblob")
    private byte[] image;



    public Advertisment() {    }

    public Advertisment(Long id, String title, String description, Category category , User user , float price, boolean ifNew, String enclosingDate, Long views, byte[] image) {
        this.id=id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.user = user;
        this.price = price;
        this.ifNew = ifNew;
        this.enclosingDate = enclosingDate;
        this.views = views;
        this.image = image;
    }

//

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//


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







    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
