package infsus.closet.closet.repo;

import infsus.closet.closet.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation,Long> {
    List<Reservation> findByClothesId(Long clothesId);

    List<Reservation> findByProfileId(Long profileId);
}
