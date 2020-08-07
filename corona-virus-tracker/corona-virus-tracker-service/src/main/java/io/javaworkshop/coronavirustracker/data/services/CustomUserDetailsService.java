package io.javaworkshop.coronavirustracker.data.services;

import static java.util.Collections.singletonList;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.javaworkshop.coronavirustracker.accessingdatajpa.Role;
import io.javaworkshop.coronavirustracker.accessingdatajpa.Users;
import io.javaworkshop.coronavirustracker.reposistory.RoleRepository;
import io.javaworkshop.coronavirustracker.reposistory.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	private RoleRepository roleRepository;

	public Optional<Users> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<Users> userOptional = userRepository.findByEmail(email);
		Users user = userOptional
				.orElseThrow(() -> new UsernameNotFoundException("No User found with Email Id" + email));
		return new User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true,
				getUserAuthority("USER"));
	}

	private Collection<? extends GrantedAuthority> getUserAuthority(String role) {
		return singletonList(new SimpleGrantedAuthority(role));
	}

}