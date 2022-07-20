package sn.ias.Kspace.controller;

import org.springframework.web.bind.annotation.*;
import sn.ias.Kspace.entities.Role;
import sn.ias.Kspace.entities.User;
import sn.ias.Kspace.entities.UserRole;
import sn.ias.Kspace.service.UserService;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {
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

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        this.userService.deleteUser(id);
    }
}
