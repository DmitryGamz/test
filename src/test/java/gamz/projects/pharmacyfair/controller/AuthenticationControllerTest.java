package gamz.projects.pharmacyfair.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import gamz.projects.pharmacyfair.configuration.TestSecurityConfig;
import gamz.projects.pharmacyfair.model.exception.UserNotFoundException;
import gamz.projects.pharmacyfair.model.request.AuthenticationRequest;
import gamz.projects.pharmacyfair.model.request.RegisterRequest;
import gamz.projects.pharmacyfair.model.response.AuthenticationResponse;
import gamz.projects.pharmacyfair.model.response.RegistrationResponse;
import gamz.projects.pharmacyfair.service.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AuthenticationController.class)
@Import({TestSecurityConfig.class, TestGlobalExceptionHandler.class})
class AuthenticationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockitoBean
	private AuthenticationService authenticationService;
	
	private RegisterRequest registerRequest;
	private AuthenticationRequest authRequest;
	private AuthenticationResponse authResponse;
	private RegistrationResponse registrationResponse;
	
	@BeforeEach
	void setUp() {
		registerRequest = new RegisterRequest();
		registerRequest.setEmail("test@example.com");
		registerRequest.setPassword("password123");
		registerRequest.setFirstName("Test");
		registerRequest.setLastName("User");
		
		authRequest = new AuthenticationRequest();
		authRequest.setEmail("test@example.com");
		authRequest.setPassword("password123");

		registrationResponse = new RegistrationResponse("", authRequest.getEmail());
	}
	
	@Test
	@DisplayName("Should register user successfully")
	void register_Success() throws Exception {
		// Arrange
		when(authenticationService.register(any(RegisterRequest.class))).thenReturn(registrationResponse);
		
		// Act & Assert
		mockMvc.perform(post("/api/v1/auth/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(registerRequest)))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isOk())
				.andExpect(content().json(objectMapper.writeValueAsString(authResponse)));
		
		verify(authenticationService, times(1)).register(any(RegisterRequest.class));
	}
	
	@Test
	@DisplayName("Should authenticate user successfully")
	void authenticate_Success() throws Exception {
		// Arrange
		when(authenticationService.authenticate(any(AuthenticationRequest.class))).thenReturn(authResponse);
		
		// Act & Assert
		mockMvc.perform(post("/api/v1/auth/authenticate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(authRequest)))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isOk())
				.andExpect(content().json(objectMapper.writeValueAsString(authResponse)));
		
		verify(authenticationService, times(1)).authenticate(any(AuthenticationRequest.class));
	}
	
	@Test
	@DisplayName("Should return 404 when authenticating with non-existent user")
	void authenticate_UserNotFound() throws Exception {
		// Arrange
		doThrow(new UserNotFoundException("User not found"))
				.when(authenticationService).authenticate(any(AuthenticationRequest.class));
		
		// Act & Assert
		mockMvc.perform(post("/api/v1/auth/authenticate")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(authRequest)))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isNotFound());
		
		verify(authenticationService, times(1)).authenticate(any(AuthenticationRequest.class));
	}
	
	@Test
	@DisplayName("Should clear authentication")
	void clearAuthentication() throws Exception {
		// Arrange
		doNothing().when(authenticationService).clearAuthentication();
		
		// Act & Assert
		mockMvc.perform(get("/api/v1/auth/clear"))
				.andDo(print()) // Print request/response for debugging
				.andExpect(status().isOk())
				.andExpect(content().string("You successfully cleared the authentication."));
		
		verify(authenticationService, times(1)).clearAuthentication();
	}
}