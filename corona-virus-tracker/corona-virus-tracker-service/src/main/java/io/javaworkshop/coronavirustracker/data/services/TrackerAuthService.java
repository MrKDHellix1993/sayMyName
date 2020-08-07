package io.javaworkshop.coronavirustracker.data.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.javaworkshop.coronavirustracker.accessingdatajpa.Role;
import io.javaworkshop.coronavirustracker.accessingdatajpa.Users;
import io.javaworkshop.coronavirustracker.auth.controllers.AuthData;
import io.javaworkshop.coronavirustracker.reposistory.RoleRepository;
import io.javaworkshop.coronavirustracker.reposistory.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TrackerAuthService {

	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	private UserRepository userRepository;
	private RoleRepository roleRepository;

	public void saveUser(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	public Authentication login(AuthData data) {
		Authentication authenticate = null;
		try {

			authenticate = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword()));
			if (authenticate.isAuthenticated()) {
				System.out.println("Welcome to Covid Tracker App");
			}
			/*
			 * SecurityContextHolder.getContext().setAuthentication(authenticate); String
			 * token = jwtProvider.generateToken(authenticate); return
			 * AuthenticationResponse.builder().authenticationToken(token)
			 * .refreshToken(refreshTokenService.generateRefreshToken().getToken())
			 * .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
			 * .username(data.getUsername()).build();
			 */
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid email/password supplied");
		}
		return authenticate;
	}
}
