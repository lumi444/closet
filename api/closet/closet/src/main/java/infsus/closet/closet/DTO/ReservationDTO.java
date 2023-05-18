package infsus.closet.closet.DTO;

import infsus.closet.closet.model.Clothes;
import infsus.closet.closet.model.Profile;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class ReservationDTO {
    private LocalDateTime reservationDate = LocalDateTime.now();

    private LocalDateTime returnDate;

    private ClothesDTO clothes;

    private ProfileDTO profile;

    public ReservationDTO() {
        // default constructor
    }

    public ReservationDTO(LocalDateTime returnDate, ClothesDTO clothes, ProfileDTO profile) {
        this.returnDate = returnDate;
        this.clothes = clothes;
        this.profile = profile;
    }

    // getters and setters

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

    public ClothesDTO getClothes() {
        return clothes;
    }

    public void setClothes(ClothesDTO clothes) {
        this.clothes = clothes;
    }

    public ProfileDTO getProfile() {
        return profile;
    }

    public void setProfile(ProfileDTO profile) {
        this.profile = profile;
    }
}
