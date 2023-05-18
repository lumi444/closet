package infsus.closet.closet.test1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import infsus.closet.closet.exception.RequestDeniedException;
import infsus.closet.closet.exception.UserNotFoundException;
import infsus.closet.closet.model.User;
import infsus.closet.closet.repo.UserRepo;
import infsus.closet.closet.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ExceptionTesting {

        @Autowired
        private UserRepo userRepository;

        @Autowired
        private UserService userService;
        @Test
        public void testException(){
            User user=userRepository.findUserByName("Ana").get();
            user.setIban("12345678");
            Throwable exception=
                    assertThrows(RequestDeniedException.class,
                            ()-> userService.updateUser(user));
            assertEquals("IBAN must have at least 10 numbers",
                    exception.getMessage());
        }

    }


