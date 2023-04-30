package infsus.closet.closet;


import infsus.closet.closet.model.Clothes;
import infsus.closet.closet.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clothes")
public class ClothesResource {

    private final ClothesService clothesService;

    @Autowired
    public ClothesResource(ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Clothes>> getAllClothes() {
        List<Clothes> clothes = clothesService.getAllClothes();
        return new ResponseEntity<>(clothes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Clothes> getClothesById(@PathVariable Long id) {
        Optional<Clothes> clothes = clothesService.getClothesById(id);
        return clothes.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<Clothes> createClothes(@RequestBody Clothes clothes) {
        Clothes newClothes = clothesService.saveClothes(clothes);
        return new ResponseEntity<>(newClothes, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Clothes> updateClothes(@PathVariable Long id, @RequestBody Clothes clothes) {
        Optional<Clothes> existingClothes = clothesService.getClothesById(id);
        if (existingClothes.isPresent()) {
            clothes.setId(id);
            Clothes updatedClothes = clothesService.updateClothes(clothes);
            return new ResponseEntity<>(updatedClothes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClothesById(@PathVariable Long id) {
        Optional<Clothes> existingClothes = clothesService.getClothesById(id);
        if (existingClothes.isPresent()) {
            clothesService.deleteClothesById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

