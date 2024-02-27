package com.cts.jwtapi.configurations;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.cts.jwtapi.exceptions.JWTMissingTokenException;
import com.cts.jwtapi.exceptions.JwtTokenMalformedException;
import com.cts.jwtapi.exceptions.UserNotFoundException;
import com.cts.jwtapi.models.Role;
import com.cts.jwtapi.models.User;
import com.cts.jwtapi.services.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.Data;
@Data
@Component
public class JwtUtil {
	
	@Value("${jwt.secret}")
	private String jwtSecret;
	@Value("${jwt.token.validity}")
	private long tokenValidity;
	@Autowired
	private UserService userService;
	
	public User getUser(String token) {
     User user=new User();
	try {	
	  Claims claims=Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token).getBody(); 	 
	  user.setUserName(claims.getSubject());	  
	  List<Role> roles=userService.getUserRoles(user.getUserName());
	  user.setRoles(roles);
	  }catch(UserNotFoundException ex) {
		  throw new UserNotFoundException("User not found....");
	  }
	  
	  return user;	
		
	}
	
	
	public String generateToken(User user) {		
		Claims claims=Jwts.claims().setSubject(user.getUserName());
		claims.put("roles", user.getRoles());
		long currentTime=System.currentTimeMillis();
		long expiryTime=currentTime+tokenValidity;		
		return Jwts.builder().setClaims(claims)
		.setExpiration(new Date(expiryTime))
		.setIssuedAt(new Date(currentTime))
		.signWith(SignatureAlgorithm.HS256, jwtSecret).compact();		
	}
	
	public void validateToken(String token) {
		try {
		Jwts.parser().setSigningKey(jwtSecret).parseClaimsJwt(token);
		}
		catch(SignatureException ex) {
			throw new SignatureException("JWT Signature Error....");
			
		}
		catch(MalformedJwtException ex) {
			throw new JwtTokenMalformedException("JWT Token Torned....");
		}
		catch(ExpiredJwtException ex) {
			throw new JwtTokenMalformedException("JWT Token Expired....");
		}
		catch(UnsupportedJwtException ex) {
			throw new UnsupportedJwtException("Unsupported Token....");
		}
		catch(IllegalArgumentException ex) {
			throw new JWTMissingTokenException("Invlid Token Supplied....");
		}
	}

}
