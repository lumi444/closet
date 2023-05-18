package infsus.closet.closet.DTO;

public class OrderStatusDTO {
    private String name;

    public OrderStatusDTO() {
        // default constructor
    }

    public OrderStatusDTO(String name) {
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
