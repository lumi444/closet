package infsus.closet.closet;

import infsus.closet.closet.exception.UserNotFoundException;
import infsus.closet.closet.model.User;
import infsus.closet.closet.repo.UserRepo;
import infsus.closet.closet.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepo);
    }

    @Test
    void testAddUser() {
        User user = new User();
        when(userRepo.save(user)).thenReturn(user);

        User savedUser = userService.addUser(user);

        assertNotNull(savedUser);
        assertEquals(user, savedUser);
        verify(userRepo, times(1)).save(user);
    }

    @Test
    void testFindAllUsers() {
        List<User> users = new ArrayList<>();
        when(userRepo.findAll()).thenReturn(users);

        List<User> foundUsers = userService.findAllUsers();

        assertNotNull(foundUsers);
        assertEquals(users, foundUsers);
        verify(userRepo, times(1)).findAll();
    }

    @Test
    void testUpdateUser() {
        User user = new User();
        when(userRepo.save(user)).thenReturn(user);

        User updatedUser = userService.updateUser(user);

        assertNotNull(updatedUser);
        assertEquals(user, updatedUser);
        verify(userRepo, times(1)).save(user);
    }

    @Test
    void testFindUserById() {
        Long userId = 1L;
        User user = new User();
        when(userRepo.findUserById(userId)).thenReturn(Optional.of(user));

        User foundUser = userService.findUserById(userId);

        assertNotNull(foundUser);
        assertEquals(user, foundUser);
        verify(userRepo, times(1)).findUserById(userId);
    }

    @Test
    void testFindUserById_UserNotFound() {
        Long userId = 1L;
        when(userRepo.findUserById(userId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.findUserById(userId));
        verify(userRepo, times(1)).findUserById(userId);
    }

    @Test
    void testFindUserByName() {
        String name = "John";
        User user = new User();
        when(userRepo.findUserByName(name)).thenReturn(Optional.of(user));

        User foundUser = userService.findUserByName(name);

        assertNotNull(foundUser);
        assertEquals(user, foundUser);
        verify(userRepo, times(1)).findUserByName(name);
    }

    @Test
    void testFindUserByName_UserNotFound() {
        String name = "John";
        when(userRepo.findUserByName(name)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> userService.findUserByName(name));
        verify(userRepo, times(1)).findUserByName(name);
    }

    @Test
    void testDeleteUser() {
        Long userId = 1L;
        doNothing().when(userRepo).deleteUserById(userId);

        userService.deleteUser(userId);

        verify(userRepo, times(1)).deleteUserById(userId);
    }

    @Test
    void testListAll() {
        List<User> users = new ArrayList<>();
        when(userRepo.findAll()).thenReturn(users);

        List<User> foundUsers = userService.listAll();

        assertNotNull(foundUsers);
        assertEquals(users, foundUsers);
        verify(userRepo, times(1)).findAll();
    }
}
