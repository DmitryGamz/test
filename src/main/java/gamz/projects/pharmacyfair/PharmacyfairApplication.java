package gamz.projects.pharmacyfair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PharmacyfairApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PharmacyfairApplication.class)
				.properties("spring.docker.compose.enabled=true");
	}

	public static void main(String[] args) {
		SpringApplication.run(PharmacyfairApplication.class, args);
	}
}
