package infsus.closet.closet.DTO;

import infsus.closet.closet.model.OrderStatus;
import infsus.closet.closet.model.Reservation;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

public class OrderDTO {
    private String deliveryAddress;

    private BigDecimal price;

    private String cardNumber;

    private OrderStatusDTO status;

    private ReservationDTO reservation;

    public OrderDTO() {
        // default constructor
    }

    public OrderDTO(String deliveryAddress, BigDecimal price, String cardNumber, OrderStatusDTO status, ReservationDTO reservation) {
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.cardNumber = cardNumber;
        this.status = status;
        this.reservation = reservation;
    }

    // getters and setters

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

    public OrderStatusDTO getStatus() {
        return status;
    }

    public void setStatus(OrderStatusDTO status) {
        this.status = status;
    }

    public ReservationDTO getReservation() {
        return reservation;
    }

    public void setReservation(ReservationDTO reservation) {
        this.reservation = reservation;
    }

}
