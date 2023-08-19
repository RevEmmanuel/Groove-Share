package org.grooveshare.playlist;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@Slf4j
@OpenAPIDefinition(
		info = @Info(
				title = "Groove Share Playlist",
				version = "v1",
				description = "This app provides REST APIs for Playlist needs",
				contact = @Contact(
						name = "Adeola ADEKUNLE",
						email = "adeolaae1@gmail.com"
				)
		),
		servers = {
				@Server(
						url = "http://localhost:9090",
						description = "DEV Server"
				)
		},
		externalDocs = @ExternalDocumentation(
				url = "https://bit.ly/revemmanuel-groove-share",
				description = "Postman Documentation"
		)
)
@EnableAsync
public class PlaylistApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistApplication.class, args);
		log.info("::::::Server Running::::::");
	}

}
