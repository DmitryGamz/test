package gamz.projects.pharmacyfair.controller;

import org.mockito.Mockito;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;

@RestController
@RequestMapping("/dummy")
@Validated
public class DummyControllerForExceptionTest {

    @GetMapping("/validation-error")
    public void throwValidationException() throws MethodArgumentNotValidException {
        BindingResult bindingResult = Mockito.mock(BindingResult.class);
        throw new MethodArgumentNotValidException(null, bindingResult);
    }

    @GetMapping("/auth-error")
    public void throwAuthException() {
        throw new BadCredentialsException("Bad credentials");
    }

    @GetMapping("/access-denied")
    public void throwAccessDenied() {
        throw new AccessDeniedException("Access denied");
    }

    @GetMapping("/service-unavailable")
    public void throwServiceUnavailable() throws ServiceUnavailableException {
        throw new ServiceUnavailableException("Service unavailable");
    }

    @GetMapping("/unhandled-exception")
    public void throwUnhandled() {
        throw new RuntimeException("Unexpected error");
    }
}
