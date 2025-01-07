package com.chirohi.mongodemo.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.chirohi.mongodemo.postgres.entity.UserDetail;
import com.chirohi.mongodemo.postgres.service.AppUserSerrviceImpl;
import com.chirohi.mongodemo.postgres.service.JWTAuthenticateService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JWTAuthenticateService jwtService;
	
	@Autowired
	private AppUserSerrviceImpl userService;

	public JwtAuthenticationFilter() {
		
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String authTokenHeader = request.getHeader("Authorization");

		if (authTokenHeader != null && !authTokenHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		else if(authTokenHeader == null) {
			filterChain.doFilter(request, response);
			return;
		}

		try {
			String jwtToken = authTokenHeader.substring(7);
			String userName = jwtService.extractUsername(jwtToken);

			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (userName != null && authentication == null) {
				UserDetail userAccount = userService.loadUserByUsername(userName);

				if (jwtService.isTokenValid(jwtToken, userAccount)) {
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
							userAccount, null,userAccount.getAuthorities());
				//	authToken.setAuthenticated(true);
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}

			}

			filterChain.doFilter(request, response);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}

	}

}
