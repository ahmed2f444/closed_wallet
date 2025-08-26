package eg.eandintern.closedwallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "Repositories")
@EntityScan(basePackages = "Entities")
public class ClosedwalletApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClosedwalletApplication.class, args);
	}
}
