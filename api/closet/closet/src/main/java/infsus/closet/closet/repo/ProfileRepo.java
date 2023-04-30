package infsus.closet.closet.repo;

import infsus.closet.closet.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile,Long> {

    Optional<Profile> findByUsername(String username);
}
