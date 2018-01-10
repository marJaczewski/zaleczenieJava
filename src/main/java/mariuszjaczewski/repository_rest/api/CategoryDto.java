package mariuszjaczewski.repository_rest.api;

import mariuszjaczewski.repository_rest.Entities.Advertisment;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

public class CategoryDto {


    private Long id;
    private String name;
    private List<Advertisment> advertisments;


    public CategoryDto() {
    }

    public CategoryDto(Long id, String name, List<Advertisment> advertisments) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Advertisment> getAdvertisments() {
        return advertisments;
    }

    public void setAdvertisments(List<Advertisment> advertisments) {
        this.advertisments = advertisments;
    }
}
