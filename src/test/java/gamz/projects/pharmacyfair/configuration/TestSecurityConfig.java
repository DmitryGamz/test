package gamz.projects.pharmacyfair.configuration;

import gamz.projects.pharmacyfair.configuration.jwt.JwtAuthenticationFilter;
import gamz.projects.pharmacyfair.configuration.jwt.JwtService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@TestConfiguration
public class TestSecurityConfig {
	
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
	public JwtAuthenticationFilter jwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
		return new JwtAuthenticationFilter(jwtService, userDetailsService) {
			@Override
			protected boolean shouldNotFilter(jakarta.servlet.http.HttpServletRequest request) {
				return true; // Disable filter for tests
			}
		};
	}
	
	@Bean
	@Primary
	public UserDetailsService userDetailsService() {
		UserDetails testUser = User.builder()
				.username("test@example.com")
				.password(passwordEncoder().encode("password"))
				.roles("USER")
				.build();
		
		UserDetails adminUser = User.builder()
				.username("admin@example.com")
				.password(passwordEncoder().encode("password"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(testUser, adminUser);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Primary
	public SecurityFilterChain testSecurityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(AbstractHttpConfigurer::disable) // Disable CSRF for testing
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/api/v1/auth/**").permitAll()
						.anyRequest().authenticated()
				);
		
		return http.build();
	}
}