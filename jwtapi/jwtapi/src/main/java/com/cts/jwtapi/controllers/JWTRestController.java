package com.cts.jwtapi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.jwtapi.configurations.JwtUtil;
import com.cts.jwtapi.dtos.JwtRequest;
import com.cts.jwtapi.dtos.ResponseWrapper;
import com.cts.jwtapi.exceptions.InvalidCredentialException;
import com.cts.jwtapi.exceptions.UserDisabledException;
import com.cts.jwtapi.models.Role;
import com.cts.jwtapi.models.User;
import com.cts.jwtapi.services.UserAuthService;
import com.cts.jwtapi.services.UserService;

@RestController
public class JWTRestController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserAuthService userAuthService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/signin")
	public ResponseEntity<ResponseWrapper> signIn(@RequestBody JwtRequest jwtRequest){
		
		try {
			
			authenticationManager.authenticate(new 
					UsernamePasswordAuthenticationToken
					(jwtRequest.getUserName(),jwtRequest.getUserPwd()));
		}
		catch(DisabledException ex) {
			throw new UserDisabledException("User Not Allowed...");
		}
		catch(BadCredentialsException ex) {
			throw new InvalidCredentialException("Invalid Credential Exception...");
		}
		
		
		UserDetails userDetails=userAuthService.loadUserByUsername(jwtRequest.getUserName());
		
		String userName=userDetails.getUsername();
		String password=userDetails.getPassword();
		List<String> roles=userDetails.getAuthorities().stream().map(r -> r.getAuthority())
		.collect(Collectors.toList());
		
		List<Role> roleList=new ArrayList(roles);		
		
		User user =new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setRoles(roleList);
		
		String token=jwtUtil.generateToken(user);
		
		return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body(new ResponseWrapper(token));
		
		
		
	}
	
	@PostMapping("/signup")
	public ResponseEntity<ResponseWrapper> signUp(@RequestBody User user){
		  User userObj=userService.saveUser(user);	
		  if(userObj!=null) {
			  return ResponseEntity.status(HttpStatus.SC_CREATED)
					  .body(new ResponseWrapper("User Successfully created"));
		  }else {
			  
			  return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST)
					  .body(new ResponseWrapper("User Already Exists")); 
		  }
		
		}
	

}
