package infsus.closet.closet.service;

import infsus.closet.closet.model.Clothes;
import infsus.closet.closet.repo.ClothesRepo;
import infsus.closet.closet.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public Clothes saveClothesF(Clothes clothes, MultipartFile pictureFile) throws IOException {
        // Check if there is a new picture file
        if (pictureFile != null && !pictureFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(pictureFile.getOriginalFilename());
            String uploadDir = "D:/Users/Win/slike_closet"; // Replace with your actual upload directory

            // Create the upload directory if it doesn't exist
            File uploadPath = new File(uploadDir);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            // Save the picture file
            String filePath = uploadDir + fileName;
            pictureFile.transferTo(new File(filePath));

            // Set the picture path in the clothes object
            clothes.setPicture(filePath);
        }

        return clothesRepository.save(clothes);
    }

    public void deleteClothesById(Long id) {
        clothesRepository.deleteById(id);
    }

    public Clothes updateClothes(Clothes clothes) {
        return clothesRepository.save(clothes);
    }
}

