package com.cognixia.jump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(
		info= @Info( title="Card Store API", version ="0.1",
					description = "API that allows someone to create a user and purchase playing "
							+ "cards and track billing",
					contact=@Contact(name="", email="",
									 url="")
				)
)
public class MongoSpringCardProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoSpringCardProjectApplication.class, args);
	}

}
