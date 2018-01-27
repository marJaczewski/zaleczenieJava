package mariuszjaczewski.repository_rest.Entities;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "haslo")
    private String haslo;

    @Column(name = "role")
    private String role;

    @OneToMany
    @Column(name = "advertisments")
    private List<Advertisment> adverisments;


    public User() {    }


    public User(Long user_id, String imie, String nazwisko, String address, String email, String telefon, String haslo, List<Advertisment> adverisments, String role) {
       this.user_id=user_id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.address = address;
        this.email = email;
        this.telefon = telefon;
        this.haslo = haslo;
        this.adverisments = adverisments;
        this.role = role;

    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public List<Advertisment> getAdverisments() {
        return adverisments;
    }

    public void setAdverisments(List<Advertisment> adverisments) {
        this.adverisments = adverisments;
    }
}
