package com.campus.soccer.league;

import com.campus.soccer.league.domain.Game;
import com.campus.soccer.league.domain.League;
import com.campus.soccer.league.domain.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class SoccerLeagueApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SoccerLeagueApplication.class);


	static void threadMessage(String message) {
		String threadName = Thread.currentThread().getName();
		log.info("{}: {}", threadName, message);
	}



	public static void main(String[] args) {
		SpringApplication.run(SoccerLeagueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		threadMessage("Start the soccer league application ...");

		// init teams and league
		Team real = new Team("Real Madrid");
		Team bayern = new Team("Bayern München");
		Team manchester = new Team("Manchester City");
		Team juventus = new Team("Juventus Turin");
		League league = new League();

		// Hinspiele
		leagueGames(bayern, real, juventus, manchester, league);

		// Hinspiele
		leagueGames(real, bayern, manchester, juventus, league);

		log.info("The league TeamTable has {} entries.", league.getTeamTable().size());

		league.getTeamTable().forEach(team -> {
			log.info(team.toString());
		});

	}

	private void leagueGames(Team team1, Team team2, Team team3, Team team4, League league) throws InterruptedException {
		Thread game1 = new Thread(new SoccerGameThread(new Game(team1, team2), league));
		Thread game2 = new Thread(new SoccerGameThread(new Game(team3, team4), league));
		game1.start();
		game2.start();
		threadMessage("Waiting for SoccerGameThread to finish");

		while (game1.isAlive() && game2.isAlive()) {
			threadMessage("Waiting until games are finished ...");
			game1.join();
			game2.join();
		}
	}

}
