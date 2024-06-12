package com.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CredentialService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        if ("john".equals(username)) {
	            return User.builder()
	                    .username("john")
	                    .password("$2a$10$1pVWw3csE.98E42E6qZoz.NEVQz5H0qEaZhugjXZjYyKTxPl/OG2a")
	                    .roles("USER")
	                    .build();
	        } else {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }
		}
}