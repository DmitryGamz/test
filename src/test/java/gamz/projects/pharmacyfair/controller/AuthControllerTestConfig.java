package gamz.projects.pharmacyfair.controller;

import gamz.projects.pharmacyfair.configuration.jwt.JwtAuthenticationFilter;
import gamz.projects.pharmacyfair.configuration.jwt.JwtService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@TestConfiguration
public class AuthControllerTestConfig {
	
	@Bean
	@Primary
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter(null, null) {
			@Override
			protected boolean shouldNotFilter(jakarta.servlet.http.HttpServletRequest request) {
				return true; // Don't filter any requests during tests
			}
		};
	}
	
	@Bean
	@Primary
	public JwtService jwtService() {
		return new JwtService() {
			@Override
			public String generateToken(org.springframework.security.core.userdetails.UserDetails userDetails) {
				return "test-jwt-token";
			}
			
			@Override
			public String extractUsername(String token) {
				return "test@example.com";
			}
			
			@Override
			public boolean isTokenValid(String token, org.springframework.security.core.userdetails.UserDetails userDetails) {
				return true;
			}
		};
	}
	
	@Bean
	@Primary
	public AuthenticationManager authenticationManager() {
		return new AuthenticationManager() {
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				return authentication;
			}
		};
	}
}