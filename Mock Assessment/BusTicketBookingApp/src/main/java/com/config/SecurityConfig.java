package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.EntryPointJwt;
import com.jwt.TokenFilter;
import com.service.UserDetailsServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	private EntryPointJwt entryPoint;

    @Autowired
    private TokenFilter tokenFilter;
    
	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public SecurityFilterChain doFilter(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.cors(cors -> cors.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/ticketbookingapp/**").authenticated()
					.requestMatchers("/app/**").permitAll()
					.anyRequest().authenticated())
			.exceptionHandling(ex -> ex.authenticationEntryPoint(entryPoint))
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
        http.authenticationProvider(daoAuthenticationProvider());
        http.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@SuppressWarnings("deprecation")
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}