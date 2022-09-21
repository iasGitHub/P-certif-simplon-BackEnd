package sn.ias.Kspace.service;

import org.springframework.stereotype.Service;
import sn.ias.Kspace.entities.Role;
import sn.ias.Kspace.repository.RoleRepository;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role addRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return this.roleRepository.save(role);
    }

    @Override
    public Set<Role> getRoles() {
        return new LinkedHashSet<>(this.roleRepository.findAll());
    }

    @Override
    public Role getRole(Long id) {
        return this.roleRepository.findById(id).get();
    }

    @Override
    public void deleteRole(Long id) {
        Role role = new Role();
        role.setId(id);
        this.roleRepository.delete(role);
    }
}
