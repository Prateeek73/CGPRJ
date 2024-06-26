package com.hms.jwt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.hms.entities.User;
import com.hms.repository.UserRepository;

@Component
public class JwtFilter extends AbstractGatewayFilterFactory<JwtFilter.Config> {

	@Autowired
	private RouteValidator validator;

	@Autowired
	private JwtUtility jwtUtil;

	@Autowired
	private UserRepository userRepository;

	private static final String BEARER_PREFIX = "Bearer ";

	public static class Config {

	}

	public JwtFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			if (validator.isSecured.test(exchange.getRequest())) {
				HttpHeaders headers = exchange.getRequest().getHeaders();

				// Checking for missing authorization header
				if (!headers.containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Missing authorization header");
				}

				// Extracting JWT token from Authorization header
				String authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
				if (authHeader != null && authHeader.startsWith(BEARER_PREFIX)) {
					authHeader = authHeader.substring(BEARER_PREFIX.length());
				} else {
					throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Not a bearer token");	
				}

				// Getting email Id from JWT token
				String emailFromToken = jwtUtil.getUsernameFromToken(authHeader);

				// Checking if user exists with email id in database
				Optional<User> optionalUser = userRepository.findByEmail(emailFromToken);
				if (optionalUser.isEmpty()) {
					throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email found from token");
				}

				// Checking if user has logged into out system
				User user = optionalUser.get();
				if (!user.getLoggedId()) {
					throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not logged in");
				}

				// Checking if token is till valid or not
				if (jwtUtil.isTokenExpired(authHeader)) {
					throw new ResponseStatusException(HttpStatus.REQUEST_TIMEOUT, "Token expired");
				}
			}
			return chain.filter(exchange);
		});
	}
}