package infsus.closet.closet;

import infsus.closet.closet.model.Reservation;
import infsus.closet.closet.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationResource {

    private final ReservationService reservationService;

    @Autowired
    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if (reservation.isPresent()) {
            return new ResponseEntity<>(reservation.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/clothes/{clothesId}")
    public ResponseEntity<List<Reservation>> getReservationsByClothesId(@PathVariable Long clothesId) {
        List<Reservation> reservations = reservationService.getReservationsByClothesId(clothesId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<Reservation>> getReservationsByProfileId(@PathVariable Long profileId) {
        List<Reservation> reservations = reservationService.getReservationsByProfileId(profileId);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }
}

