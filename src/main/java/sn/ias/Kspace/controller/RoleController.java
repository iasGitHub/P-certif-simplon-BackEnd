package sn.ias.Kspace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ias.Kspace.entities.Role;
import sn.ias.Kspace.service.RoleService;

@RestController
@RequestMapping("/role")
@CrossOrigin("*")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // add role
    @PostMapping("/")
    public ResponseEntity<?> addRole(@RequestBody Role role) {
        Role role1 = this.roleService.addRole(role);
        return ResponseEntity.ok(role1);
    }

    // get role by id
    @GetMapping("/{id}")
    public Role getRole(@PathVariable("id") Long id) {
        return this.roleService.getRole(id);
    }

    // get all roles
    @GetMapping("/")
    public ResponseEntity<?> getRoles() {
        return ResponseEntity.ok(this.roleService.getRoles());
    }

    // update role
    @PutMapping("/")
    public Role updateRole(@RequestBody Role role) {
        return this.roleService.updateRole(role);
    }

    // delete role
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable("id") Long id) {
        this.roleService.deleteRole(id);
    }
}
