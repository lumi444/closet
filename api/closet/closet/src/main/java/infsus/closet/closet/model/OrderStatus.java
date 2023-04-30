package infsus.closet.closet.model;
import jakarta.persistence.*;


@Entity
@Table(name = "order_status")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public OrderStatus() {
        // default constructor
    }

    public OrderStatus(String name) {
        this.name = name;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString method

    @Override
    public String toString() {
        return "OrderStatus [id=" + id + ", name=" + name + "]";
    }
}

