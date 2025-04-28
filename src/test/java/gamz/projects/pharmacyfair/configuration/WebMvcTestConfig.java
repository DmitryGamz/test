package gamz.projects.pharmacyfair.configuration;

import gamz.projects.pharmacyfair.configuration.jwt.JwtAuthenticationFilter;
import gamz.projects.pharmacyfair.configuration.jwt.JwtService;
import org.mockito.Mock;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@TestConfiguration
@EnableWebSecurity
public class WebMvcTestConfig {
	
	@MockitoBean
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@MockitoBean
	private JwtService jwtService;
	
	@Bean
	public SecurityFilterChain testSecurityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/api/v1/auth/**").permitAll()
						.anyRequest().authenticated()
				);
		
		return http.build();
	}
}