package sn.ias.Kspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ias.Kspace.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}