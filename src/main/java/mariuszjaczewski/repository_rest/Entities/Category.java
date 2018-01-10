package mariuszjaczewski.repository_rest.Entities;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Advertisment> advertisments;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", advertisments=" + advertisments +
                '}';
    }

    //przyponij mi pozniej zebym powiedziac Ci o czyms takim jak Loombok
    public Category() {
    }

    public Category(Long id, String name, List<Advertisment> advertisments) {
        this.id = id;
        this.name = name;
        this.advertisments = advertisments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Advertisment> getAdvertisments() {
        return advertisments;
    }

    public void setAdvertisments(List<Advertisment> advertisments) {
        this.advertisments = advertisments;
    }


}
