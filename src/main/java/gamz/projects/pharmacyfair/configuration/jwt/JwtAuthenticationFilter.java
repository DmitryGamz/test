package gamz.projects.pharmacyfair.configuration.jwt;

import java.io.IOException;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
	
	private final JwtService jwtService;
	private final UserDetailsService userDetailsService;
	
	private static final String AUTH_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";
	
	@Override
	protected void doFilterInternal(
			@NonNull HttpServletRequest request,
			@NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain
	) throws ServletException, IOException {
		
		final String authHeader = request.getHeader(AUTH_HEADER);
		
		if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
			log.trace("Запрос к {} без JWT токена. Пропускаем фильтр.", request.getRequestURI());
			filterChain.doFilter(request, response);
			return;
		}
		final String jwt = authHeader.substring(BEARER_PREFIX.length());
		
		try {
			final String userEmail = jwtService.extractUsername(jwt);
			
			SecurityContext context = SecurityContextHolder.getContext();
			
			if (userEmail != null && context.getAuthentication() == null) {
				UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
				
				if (jwtService.isTokenValid(jwt, userDetails)) {
					log.debug("JWT токен валиден для пользователя: {}", userEmail);
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
							userDetails,
							null,
							userDetails.getAuthorities()
					);
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					context.setAuthentication(authToken);
					log.info("Пользователь '{}' успешно аутентифицирован через JWT.", userEmail);
					
				} else {
					log.warn("Невалидный JWT токен для пользователя: {}", userEmail);
				}
			}
		} catch (ExpiredJwtException e) {
			log.warn("JWT токен истек: {} для URI: {}", e.getMessage(), request.getRequestURI());
			SecurityContextHolder.clearContext();
		} catch (UnsupportedJwtException e) {
			log.warn("JWT токен не поддерживается: {} для URI: {}", e.getMessage(), request.getRequestURI());
			SecurityContextHolder.clearContext();
		} catch (MalformedJwtException e) {
			log.warn("JWT токен некорректен (malformed): {} для URI: {}", e.getMessage(), request.getRequestURI());
			SecurityContextHolder.clearContext();
		} catch (SignatureException e) {
			log.warn("Ошибка проверки подписи JWT: {} для URI: {}", e.getMessage(), request.getRequestURI());
			SecurityContextHolder.clearContext();
		} catch (IllegalArgumentException e) {
			log.warn("Некорректный аргумент при обработке JWT: {} для URI: {}", e.getMessage(), request.getRequestURI());
			SecurityContextHolder.clearContext();
		} catch (UsernameNotFoundException e) {
			log.warn("Пользователь, указанный в JWT, не найден: {} для URI: {}", e.getMessage(), request.getRequestURI());
			SecurityContextHolder.clearContext();
		} catch (Exception e) {
			log.error("Не удалось установить аутентификацию пользователя в контексте безопасности для URI: {}", request.getRequestURI(), e);
			SecurityContextHolder.clearContext();
		}
		
		filterChain.doFilter(request, response);
	}
}