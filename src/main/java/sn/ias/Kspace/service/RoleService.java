package sn.ias.Kspace.service;

import sn.ias.Kspace.entities.Role;
import sn.ias.Kspace.entities.User;
import sn.ias.Kspace.entities.UserRole;
import sn.ias.Kspace.helper.UserNotFoundException;

import java.util.Set;

public interface RoleService {
    public Role addRole(Role role);

    public Role updateRole(Role role);

    public Set<Role> getRoles();

    public Role getRole(Long id);

    public void deleteRole(Long id);
}
