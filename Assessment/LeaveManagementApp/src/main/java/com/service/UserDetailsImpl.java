package com.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.model.Login;

public class UserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(String username,String password,Collection<? extends GrantedAuthority> authorities ) {
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl getUser(Login user) {
		return new UserDetailsImpl(
				user.getUsername(), 
				user.getPassword(), 
				Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
