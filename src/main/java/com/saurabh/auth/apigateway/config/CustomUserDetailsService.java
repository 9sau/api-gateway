package com.saurabh.auth.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saurabh.auth.apigateway.entity.User;
import com.saurabh.auth.apigateway.repository.UserRepository;
import com.saurabh.auth.apigateway.security.UserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRespository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRespository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("Username not found "+username));
		return UserPrincipal.create(user);
	}

}
