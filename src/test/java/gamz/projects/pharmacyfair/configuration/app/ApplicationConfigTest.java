package gamz.projects.pharmacyfair.configuration.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import gamz.projects.pharmacyfair.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApplicationConfigTest {

    private UserRepository userRepository;
    private ApplicationConfig applicationConfig;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        applicationConfig = new ApplicationConfig(userRepository);
    }

    @Test
    void shouldReturnPasswordEncoder() {
        PasswordEncoder encoder = applicationConfig.passwordEncoder();
        assertNotNull(encoder);
        assertTrue(encoder.matches("1234", encoder.encode("1234")));
    }

    @Test
    void shouldReturnUserDetailsService() {
        when(userRepository.findByEmail("test@example.com"))
                .thenReturn(java.util.Optional.of(new gamz.projects.pharmacyfair.model.entity.User()));
        UserDetailsService service = applicationConfig.userDetailsService();
        assertNotNull(service.loadUserByUsername("test@example.com"));
    }

    @Test
    void shouldReturnAuthenticationProvider() {
        AuthenticationProvider provider = applicationConfig.authenticationProvider();
        assertNotNull(provider);
    }

    @Test
    void shouldReturnAuthenticationManager() throws Exception {
        AuthenticationConfiguration config = mock(AuthenticationConfiguration.class);
        AuthenticationManager manager = mock(AuthenticationManager.class);
        when(config.getAuthenticationManager()).thenReturn(manager);

        AuthenticationManager result = applicationConfig.authenticationManager(config);
        assertNotNull(result);
        assertEquals(manager, result);
    }

    @Test
    void shouldReturnObjectMapper() {
        ObjectMapper mapper = applicationConfig.objectMapper();
        assertNotNull(mapper);
        assertTrue(mapper.canDeserialize(mapper.constructType(java.time.LocalDateTime.class)));
    }
}