package infsus.closet.closet.service;

import infsus.closet.closet.model.Clothes;
import infsus.closet.closet.repo.ClothesRepo;
import infsus.closet.closet.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesService {


    private final ClothesRepo clothesRepository;

    @Autowired
    public ClothesService(ClothesRepo clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    public List<Clothes> getAllClothes() {
        return clothesRepository.findAll();
    }

    public Optional<Clothes> getClothesById(Long id) {
        return clothesRepository.findById(id);
    }

    public Clothes saveClothes(Clothes clothes) {
        return clothesRepository.save(clothes);
    }

    public void deleteClothesById(Long id) {
        clothesRepository.deleteById(id);
    }

    public Clothes updateClothes(Clothes clothes) {
        return clothesRepository.save(clothes);
    }
}

