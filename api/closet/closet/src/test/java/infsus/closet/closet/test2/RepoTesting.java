package infsus.closet.closet.test2;
import infsus.closet.closet.model.User;
import infsus.closet.closet.repo.ReservationRepo;
import infsus.closet.closet.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.lang.Iterable;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class RepoTesting {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private ReservationRepo reservationRepository;

    @Test
    void testCreateAndDelete() {
        reservationRepository.deleteAll();
        userRepository.deleteAll();

        User user1=new User("Test", "Test", "1234567890", "Test",false,
                null , null);
        userRepository.save(user1);
        Iterable<User> users=userRepository.findAll();
        Assertions.assertThat(users).extracting(User::getFirstName).containsOnly("Test");

        userRepository.deleteAll();
        Assertions.assertThat(userRepository.findAll().isEmpty());
    }

}
