package mariuszjaczewski.repository_rest.Entities;


import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long image_id;


    //@ManyToOne
    @Column(name = "advertisment_id")
    private Long advertisment_id;
    @Lob
    @Column(name="content", nullable=false, columnDefinition="mediumblob")
    private byte[] content;


    public Image() {    }


    public Image(Long advertisment_id, byte[] content) {
        this.advertisment_id = advertisment_id;
        this.content = content;
    }

    public Long getImage_id() {
        return image_id;
    }

    public void setImage_id(Long image_id) {
        this.image_id = image_id;
    }

    public Long getAdvertisment_id() {
        return advertisment_id;
    }

    public void setAdvertisment_id(Long advertisment_id) {
        this.advertisment_id = advertisment_id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
