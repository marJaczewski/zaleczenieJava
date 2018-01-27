package mariuszjaczewski.repository_rest.login;

public class LoggedDetails {

    private Long userId;
    private String role;
    private String email;



    public LoggedDetails(Long userId, String role, String email) {
        this.userId = userId;
        this.role = role;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
