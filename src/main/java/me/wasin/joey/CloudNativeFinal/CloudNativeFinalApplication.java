package me.wasin.joey.CloudNativeFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CloudNativeFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeFinalApplication.class, args);
	}
}
