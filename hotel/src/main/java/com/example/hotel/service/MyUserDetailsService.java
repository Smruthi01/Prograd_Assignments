package com.example.hotel.service;

import java.util.ArrayList;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.hotel.repo.Repo;
import com.example.hotel.model.UserEntity;
import com.example.hotel.model.Users;


@Service
public  class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private Repo repo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserDetails loadUserByUsername( String username) throws UsernameNotFoundException{
		UserEntity User = repo.findByUsername(username);// jpa
		if (User == null) {
			System.out.println("");
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(User.getUsername(), User.getPassword(),
				new ArrayList<>());
	}
	
	public UserEntity save(Users user) {
		UserEntity newUser = new UserEntity();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		return repo.save(newUser);
	}

		 //return new User("foo", "foo",   new ArrayList<>());
		 
//		UserEntity User = repo.findByUsername(username);
//		return new User(User.getUser(),User.getPassword(),new ArrayList<>());
	}
	
	

