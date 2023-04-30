package infsus.closet.closet;

import infsus.closet.closet.model.UserRole;
import infsus.closet.closet.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class UserRoleResource {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleResource(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserRole>> getAllRoles() {
        List<UserRole> roles = userRoleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserRole> getRoleById(@PathVariable Long id) {
        UserRole role = userRoleService.getRoleById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserRole> createRole(@RequestBody UserRole userRole) {
        UserRole createdRole = userRoleService.createRole(userRole);
        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        userRoleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

