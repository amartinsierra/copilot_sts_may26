package com.capgemini.microtypi.web;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.microtypi.security.JwtUtils;

import java.util.ArrayList;

@RestController
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtUtils jwtUtils;

	public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
		this.authenticationManager = authenticationManager;
		this.jwtUtils = jwtUtils;
	}

	@PostMapping("/login")
	public String login(@RequestBody UserDto user) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return jwtUtils.generateToken(userDetails.getUsername(), new ArrayList<>(userDetails.getAuthorities()));
	}
}

class UserDto {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
