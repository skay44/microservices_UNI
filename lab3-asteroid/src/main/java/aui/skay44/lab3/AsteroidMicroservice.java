package aui.skay44.lab3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AsteroidMicroservice {


	public static void main(String[] args) {
		SpringApplication.run(AsteroidMicroservice.class, args);
	}

	@Bean
	public RestTemplate restTemplate(@Value("${rpg.miningDrill.url}") String baseUrl) {
		return new RestTemplateBuilder().rootUri(baseUrl).build();
	}
}
