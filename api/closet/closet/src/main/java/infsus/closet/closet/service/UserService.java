package infsus.closet.closet.service;

import infsus.closet.closet.exception.UserNotFoundException;
import infsus.closet.closet.model.User;
import infsus.closet.closet.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user){

        return  userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user){
        return userRepo.save(user);
    }

    public User findUserById(Long id){
        return  userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User with id "+id+", not found"));
    }
    public User findUserByName(String name){
        return  userRepo.findUserByName(name).orElseThrow(() -> new UserNotFoundException("User with name "+name+", not found"));
    }

    public void deleteUser(Long id){
        userRepo.deleteUserById(id);
    }

    public List<User> listAll() {
        return userRepo.findAll();
    }
}
