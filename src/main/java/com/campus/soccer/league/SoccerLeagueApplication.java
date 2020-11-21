package com.campus.soccer.league;

import com.campus.soccer.league.domain.Game;
import com.campus.soccer.league.domain.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class SoccerLeagueApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SoccerLeagueApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SoccerLeagueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Start the soccer league application ...");

	}
}
