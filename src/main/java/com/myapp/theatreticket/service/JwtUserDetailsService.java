package com.myapp.theatreticket.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myapp.theatreticket.model.User;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = new User();
		user.setUserName(userName);
		user.setPassword("$2a$10$a0Kjn8me51qRttMxPt3OHOWF9oCS0fxkE2oMkRl0HyjQ.spxcNFW.");
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
	}
}