package vn.molu.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vn.molu.dao.SecurityDAO;
import vn.molu.dao.impl.SecurityDAOImpl;
import vn.molu.domain.Role;

public class UserService implements UserDetailsService{

	SecurityDAO repository = new SecurityDAOImpl();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		vn.molu.domain.User obj = repository.logon(username);
		System.out.println(obj.getUsername());
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : obj.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new User(obj.getUsername(), obj.getPassword(), true, true, true, true, authorities);
	}
}

