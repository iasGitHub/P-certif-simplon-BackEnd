package sn.ias.Kspace.service;

import sn.ias.Kspace.entities.User;
import sn.ias.Kspace.entities.UserRole;
import sn.ias.Kspace.helper.UserNotFoundException;

import java.util.Set;

public interface UserService {

    public User createUser(User user, Set<UserRole> userRoles) throws Exception, UserNotFoundException;
    // get user by username
    public User getUserByUsername(String username);

    public User getUser(Long id);
    public User updateUser(User user);
    //delete user by id
    public void deleteUser(Long id);

    public Set<User> getUsers();
}
