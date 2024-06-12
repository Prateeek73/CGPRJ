package com.hms.authms.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hms.authms.entity.User;
import com.hms.authms.jwt.JwtUtility;
import com.hms.authms.repository.UserRepository;

@Service
public class AuthenticatonService implements IAuthenticationService {

	@Autowired
	private JwtUtility jwtService;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String generateToken(String email, Collection<? extends GrantedAuthority> authorites) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if(optionalUser.isEmpty()) {
			throw new UsernameNotFoundException("User not found for emailId: " + email);
		}
		User user = optionalUser.get();
		user.setLoggedId(true);
		userRepository.save(user);
		
		return jwtService.generateToken(email, authorites);
	}

	@Override
	public Boolean validateToken(String token, String email) {
		return jwtService.validateToken(token, email);
	}

	@Override
	public User logout(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		if(optionalUser.isEmpty()) {
			throw new UsernameNotFoundException("User not found for emailId: " + email);
		}
		User user = optionalUser.get();
		user.setLoggedId(false);
		userRepository.save(user);
		return user;
	}

}