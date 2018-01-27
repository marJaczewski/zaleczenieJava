package mariuszjaczewski.repository_rest.api;

import mariuszjaczewski.repository_rest.Entities.Advertisment;

import java.util.List;

public class UserDto {

    //private Long user_id;
    private String imie;
    private String nazwisko;
    private String address;
    private String email;
    private String telefon;
    private String haslo;
    private String role;
    private List<Advertisment> adverisments;


    public UserDto() {
    }

    public UserDto(String imie, String nazwisko, String address, String email, String telefon, String haslo, List<Advertisment> adverisments, String role) {
//        this.user_id = user_id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.address = address;
        this.email = email;
        this.telefon = telefon;
        this.haslo = haslo;
        this.adverisments = adverisments;
        this.role = role;
    }

//    public Long getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(Long user_id) {
//        this.user_id = user_id;
//    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
