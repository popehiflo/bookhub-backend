package io.github.popehiflo.bookhub_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BookhubBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookhubBackendApplication.class, args);
	}

}
