package infsus.closet.closet.DTO;

public class ProfileDTO {
    private String password;

    private String username;

    public ProfileDTO() {
        // default constructor
    }

    public ProfileDTO(String password, String username) {
        this.password = password;
        this.username = username;
    }

    // getters and setters

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
