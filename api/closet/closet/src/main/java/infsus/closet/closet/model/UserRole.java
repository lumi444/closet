package infsus.closet.closet.model;
import jakarta.persistence.*;


@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    public UserRole() {
        // default constructor
    }

    public UserRole(String role) {
        this.role = role;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // toString method

    @Override
    public String toString() {
        return "UserRole [id=" + id + ", role=" + role + "]";
    }
}

