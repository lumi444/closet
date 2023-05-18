package infsus.closet.closet.DTO;

public class CategoryDTO {
    private String name;

    public CategoryDTO() {
        // default constructor
    }

    public CategoryDTO(String name) {
        this.name = name;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
