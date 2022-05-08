package am.hgh.basicauthentication;

import am.hgh.basicauthentication.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = CustomerRepository.class)
public class BasicAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicAuthenticationApplication.class, args);
    }

}
