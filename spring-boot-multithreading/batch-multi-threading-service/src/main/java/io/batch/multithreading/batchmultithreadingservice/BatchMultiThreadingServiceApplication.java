package io.batch.multithreading.batchmultithreadingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BatchMultiThreadingServiceApplication {

	@Bean
	public RestTemplate getRestTemp() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(BatchMultiThreadingServiceApplication.class, args);
	}

}
