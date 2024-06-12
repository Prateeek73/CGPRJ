package com.hms.authms.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.hms.authms.dto.LoginRequest;
import com.hms.authms.entity.User;
import com.hms.authms.repository.UserRepository;
import com.hms.authms.dto.UserDetailsTokenResponse;
import com.hms.authms.dto.UserDetailsTokenResponse.UserDetails;

import com.hms.authms.service.IAuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private IAuthenticationService authenticationService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/login")
	public ResponseEntity<UserDetailsTokenResponse> getToken(HttpServletRequest request,
			@Valid @RequestBody LoginRequest loginRequest) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
				loginRequest.getPassword());

		// Authenticate the user
		Authentication authentication = authenticationManager.authenticate(token);
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);

		String email = authentication.getName().toString();
		Optional<User> user = userRepository.findByEmail(email);
		Collection<? extends GrantedAuthority> authorites = authentication.getAuthorities();
		String jwtToken = authenticationService.generateToken(email, authorites);

		HttpSession session = request.getSession(true);
		session.setAttribute("USER_EMAIL", email);

		return ResponseEntity.ok(new UserDetailsTokenResponse(jwtToken, getUserDetailsResponse(user.get())));
	}

	@GetMapping("/validate")
	public boolean validateToken(@RequestParam("token") String token, HttpServletRequest request) {
		HttpSession session = request.getSession();

		// Get the SecurityContext from the session
		String email = (String) session.getAttribute("USER_EMAIL");

		if (email != null) {
//			Authentication authentication = securityContext.getAuthentication();
//			String email = authentication.getName();
			return authenticationService.validateToken(token, email);
		}
		return false;
	}

	@GetMapping("/logout/{email}")
	public UserDetails logout(@PathVariable String email) {
		User user = authenticationService.logout(email);
		return getUserDetailsResponse(user);
	}
	public static UserDetails getUserDetailsResponse(User user) {
		UserDetails userDetails = new UserDetails();
		userDetails.setId(user.getId());
		userDetails.setFirstName(user.getFirstName());
		userDetails.setLastName(user.getLastName());
		userDetails.setEmail(user.getEmail());
		userDetails.setRole(user.getRole());
		userDetails.setLoggedId(user.getLoggedId());
		userDetails.setReferenceId(user.getReferenceId());
		return userDetails;
	}
}