package sn.ias.Kspace.service;

import org.springframework.stereotype.Service;
import sn.ias.Kspace.entities.User;
import sn.ias.Kspace.entities.UserRole;
import sn.ias.Kspace.helper.UserFoundException;
import sn.ias.Kspace.repository.RoleRepository;
import sn.ias.Kspace.repository.UserRepository;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception, UserFoundException {

        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            for(UserRole ur:userRoles)
            {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUserByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User getUser(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public Set<User> getUsers() {
        return new LinkedHashSet<>(this.userRepository.findAll());
    }
}
