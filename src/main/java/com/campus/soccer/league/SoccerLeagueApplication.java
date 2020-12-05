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

	static int randomGoals() {
		Random random = new Random();
		return random.nextInt(10 + 1);
	}


	public static void main(String[] args) {
		SpringApplication.run(SoccerLeagueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*		threadMessage("Start the soccer league application ...");

		Team real = new Team("Real Madrid");
		Team bayern = new Team("Bayern München");
		Game game = new Game(real,bayern,0,0);



		Thread soccerGameThread = new Thread(new SoccerGameThread(game));
		soccerGameThread.start();
		soccerGameThread.join();
		threadMessage("Waiting for SoccerGameThread to finish");
*/
		// Init League and Teams
		League league = new League();
		Team realMadrid = new Team("Real Madrid");
		Team manchesterCity = new Team("Manchester City");
		Team bayernMuenchen = new Team("Bayern Muenchen");
		Team juventusTurin = new Team("Juventus Turin");

		// Game1 hinspiel
		Game game1 = new Game(realMadrid,manchesterCity, randomGoals(), randomGoals());
		league.addGameResult(game1);

		// Game2 hinspiel
		Game game2 = new Game(bayernMuenchen, juventusTurin, randomGoals(),randomGoals());
		league.addGameResult(game2);

		// Game3 rückspiel
		Game game3 = new Game(manchesterCity, realMadrid, randomGoals(), randomGoals());
		league.addGameResult(game3);

		// Game4 rückspiel
		Game game4 = new Game(juventusTurin, bayernMuenchen, randomGoals(), randomGoals());
		league.addGameResult(game4);



		log.info("The league TeamTable has {} entries.", league.getTeamTable().size());

		league.getTeamTable().forEach(team -> {
			log.info(team.toString());
		});
	}
}
