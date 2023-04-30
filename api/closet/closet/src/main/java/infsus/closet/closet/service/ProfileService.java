package infsus.closet.closet.service;

import infsus.closet.closet.model.Profile;
import infsus.closet.closet.repo.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepo profileRepository;

    public Optional<Profile> findById(Long id) {
        return profileRepository.findById(id);
    }

    public Optional<Profile> findByUsername(String username) {
        return profileRepository.findByUsername(username);
    }

    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }
}

