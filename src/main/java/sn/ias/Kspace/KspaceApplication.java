package sn.ias.Kspace;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sn.ias.Kspace.entities.Role;
import sn.ias.Kspace.entities.User;
import sn.ias.Kspace.entities.UserRole;
import sn.ias.Kspace.service.UserService;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class KspaceApplication implements CommandLineRunner {

	private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public KspaceApplication(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(KspaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting ...");

		/*User user = new User();
		user.setUsername("admin");
		user.setFirstName("Bâ");
		user.setLastName("Amadou");
		user.setEmail("amadouba22@gmail.com");
		user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
		user.setPhone("+221 78 142 22 20");
		user.setProfile("admin.png");

		Role role1 = new Role();
		role1.setId(1L);
		role1.setRoleName("ADMIN");

		Set<UserRole> userRoleSet = new HashSet<>();
		UserRole userRole = new UserRole();

		userRole.setRole(role1);
		userRole.setUser(user);

		userRoleSet.add(userRole);
		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());*/
	}

	// Cors configuration
}
