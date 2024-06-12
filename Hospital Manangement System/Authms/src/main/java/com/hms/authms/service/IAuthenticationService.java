package com.hms.authms.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.hms.authms.entity.User;

public interface IAuthenticationService {

	String generateToken(String email, Collection<? extends GrantedAuthority> authorites);

	Boolean validateToken(String token, String email);

	User logout(String email);

}