package infsus.closet.closet.DTO;

public class UserRoleDTO {
    private String role;

    public UserRoleDTO() {
        // default constructor
    }

    public UserRoleDTO(String role) {
        this.role = role;
    }

    // getters and setters

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
