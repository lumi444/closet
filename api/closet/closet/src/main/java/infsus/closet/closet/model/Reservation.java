package infsus.closet.closet.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;


@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_date")
    private LocalDateTime reservationDate = LocalDateTime.now();

    @Column(name = "return_date", nullable = false)
    private LocalDateTime returnDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clothes_id", nullable = false)
    private Clothes clothes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    public Reservation() {
        // default constructor
    }

    public Reservation(LocalDateTime returnDate, Clothes clothes, Profile profile) {
        this.returnDate = returnDate;
        this.clothes = clothes;
        this.profile = profile;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    // toString method

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", reservationDate=" + reservationDate + ", returnDate=" + returnDate
                + ", clothes=" + clothes + ", profile=" + profile + "]";
    }
}

