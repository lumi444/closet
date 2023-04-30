package infsus.closet.closet;


import infsus.closet.closet.model.Profile;
import infsus.closet.closet.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileResource {
    private final ProfileService profileService;

    @Autowired
    public ProfileResource(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
        return profileService.findById(id)
                .map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Profile> getProfileByUsername(@PathVariable String username) {
        return profileService.findByUsername(username)
                .map(profile -> new ResponseEntity<>(profile, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(profileService.save(profile), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        return profileService.findById(id)
                .map(existingProfile -> {
                    existingProfile.setUsername(profile.getUsername());
                    existingProfile.setPassword(profile.getPassword());
                    return new ResponseEntity<>(profileService.save(existingProfile), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteProfileById(@PathVariable Long id) {
        profileService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

