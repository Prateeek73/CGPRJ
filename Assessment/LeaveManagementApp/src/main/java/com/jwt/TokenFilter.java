package com.jwt;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.service.UserDetailsServiceImpl;

@Component
public class TokenFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtility jwtUtils;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader("Authorization");
		String token = null;
		String username = null;

		if (header != null && header.startsWith("Bearer")) {
			token = header.substring(7);
			try {
				username = jwtUtils.getUsernameFromToken(token);
			} catch (Exception ex) {
				logger.error("Something went wrong");
				ex.printStackTrace();
			}
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() != null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			if(jwtUtils.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken authentication = 
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}

		}
		filterChain.doFilter(request, response);
	}
}
