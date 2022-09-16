package sn.ias.Kspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import sn.ias.Kspace.entities.Role;

@CrossOrigin("*")
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByRoleName(String roleame);
}
