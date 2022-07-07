package com.song.songv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Songv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Songv1Application.class, args);
	}

}
