package joris.gourdon.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
	"joris.gourdon.api",
	"joris.gourdon.api.infrastructure",
	"joris.gourdon.api.interfaces",
	"joris.gourdon.api.application",
	"joris.gourdon.api.domain"
})
public class ApiBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiBackApplication.class, args);
	}

}
