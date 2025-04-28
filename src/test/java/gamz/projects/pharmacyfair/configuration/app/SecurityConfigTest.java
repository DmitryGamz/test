package gamz.projects.pharmacyfair.configuration.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void accessToAuthEndpointsShouldBePermitted() throws Exception {
		mockMvc.perform(get("/api/v1/auth/clear"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void accessToSecuredEndpointShouldBeDeniedForUnauthenticatedUser() throws Exception {
		mockMvc.perform(get("/api/v1/patent-types"))
				.andExpect(status().isForbidden());
	}
	
	@Test
	@WithMockUser(roles = "USER")
	public void accessToSecuredEndpointShouldBeAllowedForUserRole() throws Exception {
		mockMvc.perform(get("/api/v1/patent-types"))
				.andExpect(status().isOk());
	}
	
	@Test
	@WithMockUser(roles = "ADMIN")
	public void accessToSecuredEndpointShouldBeAllowedForAdminRole() throws Exception {
		mockMvc.perform(get("/api/v1/patent-types"))
				.andExpect(status().isOk());
	}
}