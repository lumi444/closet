package infsus.closet.closet.model;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.*;


@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "delivery_address", nullable = false)
    private String deliveryAddress;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "card_number")
    private String cardNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", nullable = false)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    public Order() {
        // default constructor
    }

    public Order(String deliveryAddress, BigDecimal price, String cardNumber, OrderStatus status, Reservation reservation) {
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.cardNumber = cardNumber;
        this.status = status;
        this.reservation = reservation;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    // toString method

    @Override
    public String toString() {
        return "Order [id=" + id + ", deliveryAddress=" + deliveryAddress + ", price=" + price + ", cardNumber="
                + cardNumber + ", status=" + status + ", reservation=" + reservation + "]";
    }

}

