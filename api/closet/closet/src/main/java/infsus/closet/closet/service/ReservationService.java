package infsus.closet.closet.service;

import infsus.closet.closet.model.Reservation;
import infsus.closet.closet.repo.ReservationRepo;
import infsus.closet.closet.repo.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepo reservationRepository;

    @Autowired
    public ReservationService(ReservationRepo reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getReservationsByClothesId(Long clothesId) {
        return reservationRepository.findByClothesId(clothesId);
    }

    public List<Reservation> getReservationsByProfileId(Long profileId) {
        return reservationRepository.findByProfileId(profileId);
    }
}

