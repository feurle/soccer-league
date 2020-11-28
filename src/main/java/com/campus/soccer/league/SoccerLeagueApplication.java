package com.campus.soccer.league;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoccerLeagueApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SoccerLeagueApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SoccerLeagueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Start the soccer league application ...");
		//jhe09TestGitHub

	}
}
