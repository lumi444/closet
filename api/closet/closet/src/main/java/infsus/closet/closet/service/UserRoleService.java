package infsus.closet.closet.service;

import infsus.closet.closet.model.UserRole;
import infsus.closet.closet.repo.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {

    private final UserRoleRepo userRoleRepository;

    @Autowired
    public UserRoleService(UserRoleRepo userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    public List<UserRole> getAllRoles() {
        return userRoleRepository.findAll();
    }

    public Optional<UserRole> getRoleById(Long id) {
        return userRoleRepository.findById(id);
    }

    public UserRole createRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    public void deleteRole(Long id) {
        userRoleRepository.deleteById(id);
    }
}
