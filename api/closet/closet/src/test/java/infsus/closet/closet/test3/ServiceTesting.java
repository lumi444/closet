package infsus.closet.closet.test3;

import infsus.closet.closet.model.User;
import infsus.closet.closet.repo.UserRepo;
import infsus.closet.closet.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class ServiceTesting {
    @ExtendWith(MockitoExtension.class)
    public class ServiceTest {

        @InjectMocks
        UserService service;

        @Mock
        UserRepo dao;

        @Test
        public void testFindAllUsers(){
            List<User> list=new ArrayList<User>();
            User user1=new User("Test", "Test", "1234567890", "Test", true,
                    null,  null);
            User user2=new User("Test1", "Test1", "1234567891", "Test1", true,
                    null,  null);
            User user3=new User("Test2", "Test2", "2234567890", "Test2", true,
                    null,  null);
            list.add(user1);
            list.add(user2);
            list.add(user3);

            when(dao.findAll()).thenReturn(list);

            //test
            List<User> userList=service.listAll();

            assertEquals(3,userList.size());
            verify(dao,times(1)).findAll();
        }
    }

}
