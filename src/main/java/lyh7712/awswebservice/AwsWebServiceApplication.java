package lyh7712.awswebservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AwsWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsWebServiceApplication.class, args);
	}

}
