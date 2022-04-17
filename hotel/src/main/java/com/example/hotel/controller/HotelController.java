package com.example.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.hotel.model.UserEntity;
import com.example.hotel.model.Users;
import com.example.hotel.repo.Repo;
import com.example.hotel.service.MyUserDetailsService;
import com.example.hotel.utitlity.*;
import com.example.hotel.model.AuthentResponse;
import com.example.hotel.model.AuthenReq;

import org.springframework.security.core.userdetails.UserDetails;
@Controller
public class HotelController {
	
	@ResponseBody
	@RequestMapping("/home")
	public String home() {
		return "hi";
	}
	
	@Autowired
	private Repo repo;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	 private Utility util;
	
	@Autowired
	private MyUserDetailsService MyUserDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	//private PasswordEncoder bcryptEncoder;
	
	@Autowired
	PasswordEncoder crypt;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Users user) throws Exception {
		return ResponseEntity.ok(MyUserDetailsService.save(user));
	}
	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenReq authentReq )throws Exception
	{
		System.out.println("cool");
		try {
			//System.out.println(authentReq.getUsername()+":"+authentReq.getPassword());
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
					(authentReq.getUsername(),authentReq.getPassword()));
		
		}
		catch(BadCredentialsException e) {
			throw new Exception("Incorrect Username and Passowrd",e);
		}
	final UserDetails userdetails= MyUserDetailsService.loadUserByUsername(authentReq.getUsername());
		final String jwt=util.generateToken(userdetails);
		
		System.out.print(jwt);
		return ResponseEntity.ok(new AuthentResponse(jwt));
	
	
}
	
//	
//    @PostMapping("/reg") 
//    public String UserReg(UserEntity UserEntity) {
//   	
//   	if(repo.findAll().isEmpty()) 
//		    {
//    		repo.save(UserEntity);
//   		return "User Registered";
//		      }
//    	else {
//    		
//    		if(repo.findByEmail(UserEntity.getEmail()).isEmpty()) {
//    			repo.save(UserEntity);
// 			return "done";
//    		}
//    		else return "User Already Registered";
// 	}
//   }
    
////	
//	@PostMapping("/login")
//	public String LoginPage(UserEntity user)
//	{
//		if(repo.findAll().isEmpty()) 
//		    {
//		return "UserNotFound";
//	      }
//	else {
//		if(repo.findByEmail(user.getEmail()).isEmpty()) {
//			return "Invalid User";
//		}
//		else{
//			List<UserEntity> UserIn= repo.findByEmail(user.getEmail());
//			for(UserEntity object:UserIn) {
//				if(object.getEmail().equals(user.getEmail()) &&
//						object.getPassword().equals(user.getPassword())) 
//					return "Welcome User";
//		}
//		}
//	}
//   return "User Not Found";
//
//}
	


	
	@RequestMapping("/ello")
	public String hom() {
		return "hi";
	}
	
	
}



	
	

