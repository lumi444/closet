package infsus.closet.closet.model;
import jakarta.persistence.*;


@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private String username;

    public Profile() {
        // default constructor
    }

    public Profile(String password, String username) {
        this.password = password;
        this.username = username;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    // toString method

    @Override
    public String toString() {
        return "Profile [id=" + id + ", password=" + password + ", username=" + username + "]";
    }
}

