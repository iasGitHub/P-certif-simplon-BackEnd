package sn.ias.Kspace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sn.ias.Kspace.entities.Publication;
import sn.ias.Kspace.entities.Role;
import sn.ias.Kspace.entities.User;
import sn.ias.Kspace.entities.UserRole;
import sn.ias.Kspace.helper.UserFoundException;
import sn.ias.Kspace.service.UserService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserController(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setId(45L);
        role.setRoleName("Apprenant");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user, roles);
    }

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {
        return this.userService.getUser(id);
    }


    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return this.userService.getUserByUsername(username);
    }

    @GetMapping("/")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(this.userService.getUsers());
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }

    // update api
    @ExceptionHandler(UserFoundException.class)
    public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
        return null;
    }
}
