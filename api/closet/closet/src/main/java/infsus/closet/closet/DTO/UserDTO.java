package infsus.closet.closet.DTO;

import infsus.closet.closet.model.Profile;
import infsus.closet.closet.model.UserRole;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class UserDTO {
    private String firstName;

    private String lastName;

    private String iban;

    private String email;

    private boolean active;

    private UserRoleDTO userRole;

    private ProfileDTO profile;

    public UserDTO() {
        // default constructor
    }

    public UserDTO(String firstName, String lastName, String iban, String email, boolean active, UserRoleDTO userRole, ProfileDTO profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.iban = iban;
        this.email = email;
        this.active = active;
        this.userRole = userRole;
        this.profile = profile;
    }

    // getters and setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UserRoleDTO getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDTO userRole) {
        this.userRole = userRole;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }

}
