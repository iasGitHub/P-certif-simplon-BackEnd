package sn.ias.Kspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.ias.Kspace.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
