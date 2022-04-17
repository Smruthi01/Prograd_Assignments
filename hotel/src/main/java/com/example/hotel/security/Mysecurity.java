package com.example.hotel.security;

import javax.servlet.Filter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import com.example.hotel.service.MyUserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.exmple.hotel.filter.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class Mysecurity extends WebSecurityConfigurerAdapter
{
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private MyUserDetailsService MyUserDetailsService;
	@Autowired
	private JwtFilter jwtFilter;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(MyUserDetailsService).passwordEncoder(passwordencoder());
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(MyUserDetailsService).passwordEncoder(passwordencoder());
	}
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	@Primary
	@Bean(name = "passwordEncoder")
	public  PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder()
//	{
//	    return new BCryptPasswordEncoder();
//	}
	
//	@Autowired
//	ApplicationContext context;

//	inYourMethod()
//	{
//	   PasswordEncoder crypt = context.getBean("passwordEncoder");
//	}
//	   

	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println("cool");
		http.csrf().disable()
		.authorizeRequests().antMatchers("/authenticate","/ello","/","/home").permitAll().
		anyRequest().authenticated().and().
		exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		
http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	
	}
	
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	

}