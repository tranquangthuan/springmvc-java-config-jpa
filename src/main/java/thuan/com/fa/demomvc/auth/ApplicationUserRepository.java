package thuan.com.fa.demomvc.auth;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import thuan.com.fa.demomvc.config.UserRole;
import thuan.com.fa.demomvc.entity.AppUser;
import thuan.com.fa.demomvc.repository.AppUserRepositoryImpl;

@Repository("applicationUserRepository")
public class ApplicationUserRepository implements ApplicationUserDao {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AppUserRepositoryImpl appUserRepositoryImpl;

	@Override
	@Transactional
	public Optional<UserDetails> selectApplicationUserByUsername(String username) {
		AppUser userDB = appUserRepositoryImpl.findById(username).orElse(null);
		if (userDB != null) {
			String role = userDB.getRole();
			UserRole userRole = UserRole.of(role.toUpperCase());
			UserDetails userDetails = User.builder().username(userDB.getUsername())
					.password(passwordEncoder.encode(userDB.getPassword())).roles(userRole.name()).build();
			return Optional.of(userDetails);
		}
		return Optional.empty();
	}

}
