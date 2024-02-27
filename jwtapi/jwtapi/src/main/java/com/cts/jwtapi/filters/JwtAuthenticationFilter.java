package com.cts.jwtapi.filters;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cts.jwtapi.configurations.JwtUtil;
import com.cts.jwtapi.exceptions.JWTMissingTokenException;
import com.cts.jwtapi.models.User;
import com.cts.jwtapi.services.UserAuthService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserAuthService userAuthService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String header =request.getHeader("Authorization");
		
		if((header==null)||(!header.startsWith("Bearer"))){
			
			throw new JWTMissingTokenException("No Jwt Token Found in the Header");			
		}		
		String token=header.substring(7);
		jwtUtil.validateToken(token);
		User user=jwtUtil.getUser(token);
		UserDetails userDetails=userAuthService.loadUserByUsername(user.getUserName());
		UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken=
				new UsernamePasswordAuthenticationToken(userDetails,null,
						userDetails.getAuthorities());
		userNamePasswordAuthenticationToken.
		setDetails(new WebAuthenticationDetailsSource()
				.buildDetails(request));
		
		if(SecurityContextHolder.getContext().getAuthentication()==null) {
			SecurityContextHolder.getContext()
			.setAuthentication(userNamePasswordAuthenticationToken);
			
		}
		filterChain.doFilter(request, response);
	}

}
