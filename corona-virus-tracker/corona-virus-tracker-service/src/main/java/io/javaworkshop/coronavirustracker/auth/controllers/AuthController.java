
package io.javaworkshop.coronavirustracker.auth.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javaworkshop.coronavirustracker.accessingdatajpa.Users;
//import io.javaworkshop.coronavirustracker.auth.configs.JwtTokenProvider;
import io.javaworkshop.coronavirustracker.data.services.CustomUserDetailsService;
import io.javaworkshop.coronavirustracker.data.services.TrackerAuthService;
import io.javaworkshop.coronavirustracker.reposistory.UserRepository;

@CrossOrigin(origins = "*")

@RestController

@RequestMapping("/api/auth")
public class AuthController {
	/*
	 * @Autowired JwtTokenProvider jwtTokenProvider;
	 */

	@Autowired
	UserRepository users;

	@Autowired
	private CustomUserDetailsService userService;

	@Autowired
	private TrackerAuthService authService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody AuthData data) {
		if (this.authService.login(data) != null) {
			return ResponseEntity.ok("Login Successful");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody Users user) {
		Optional<Users> userExists = userService.findUserByEmail(user.getEmail());
		if (userExists.isPresent()) {
			throw new BadCredentialsException("User with username: " + user.getEmail() + " already exists");
		}
		authService.saveUser(user);
		Map<Object, Object> model = new HashMap<>();
		model.put("message", "User registered successfully");
		return ResponseEntity.ok(model);
	}

	@PostMapping("/logout")
	public ResponseEntity<Object> logout(@RequestBody Users user) {
		Optional<Users> userExists = userService.findUserByEmail(user.getEmail());
		if (userExists.isPresent()) {
			throw new BadCredentialsException("User with username: " + user.getEmail() + " already exists");
		}
		Map<Object, Object> model = new HashMap<>();
		model.put("message", "User logout successfully");
		return ResponseEntity.ok(model);
	}

}
