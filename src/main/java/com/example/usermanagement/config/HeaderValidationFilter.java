package com.example.usermanagement.config;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@WebFilter("/*")
public class HeaderValidationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String moduleHeader=request.getHeader("module");
		if(moduleHeader==null || !moduleHeader.equalsIgnoreCase("inventory")) {
			response.sendError(HttpStatus.BAD_REQUEST.value(),"Header is not Present");
			return;
		}
		filterChain.doFilter(request, response);
		
	}
	
	

}
