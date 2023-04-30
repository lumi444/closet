package infsus.closet.closet.repo;

import infsus.closet.closet.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothesRepo extends JpaRepository<Clothes,Long> {
}
