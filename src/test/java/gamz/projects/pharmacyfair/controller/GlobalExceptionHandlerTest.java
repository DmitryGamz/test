package gamz.projects.pharmacyfair.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = DummyControllerForExceptionTest.class)
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Тестируем, что при возникновении MethodArgumentNotValidException возвращается статус 400 с ошибками в теле.
     */
    @Test
    void whenMethodArgumentNotValidException_thenReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/dummy/validation-error"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").exists())
                .andExpect(jsonPath("$.path").value("/dummy/validation-error"));
    }

    /**
     * Тестируем обработку AuthenticationExceptions (401).
     */
    @Test
    void whenBadCredentialsException_thenReturnsUnauthorized() throws Exception {
        mockMvc.perform(get("/dummy/auth-error"))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.status").value(401))
                .andExpect(jsonPath("$.error").value("Bad credentials"))
                .andExpect(jsonPath("$.path").value("/dummy/auth-error"));
    }

    /**
     * Тестируем обработку AccessDeniedException (403).
     */
    @Test
    void whenAccessDeniedException_thenReturnsForbidden() throws Exception {
        mockMvc.perform(get("/dummy/access-denied"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.status").value(403))
                .andExpect(jsonPath("$.error").value("Access denied"))
                .andExpect(jsonPath("$.path").value("/dummy/access-denied"));
    }

    /**
     * Тестируем обработку ServiceUnavailableException (503).
     */
    @Test
    void whenServiceUnavailableException_thenReturnsServiceUnavailable() throws Exception {
        mockMvc.perform(get("/dummy/service-unavailable"))
                .andExpect(status().isServiceUnavailable())
                .andExpect(jsonPath("$.status").value(503))
                .andExpect(jsonPath("$.error").value("Service unavailable"))
                .andExpect(jsonPath("$.path").value("/dummy/service-unavailable"));
    }

    /**
     * Тестируем общий обработчик Exception (500).
     */
    @Test
    void whenUnhandledException_thenReturnsInternalServerError() throws Exception {
        mockMvc.perform(get("/dummy/unhandled-exception"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.status").value(500))
                .andExpect(jsonPath("$.error").value("Unexpected error"))
                .andExpect(jsonPath("$.path").value("/dummy/unhandled-exception"));
    }
}