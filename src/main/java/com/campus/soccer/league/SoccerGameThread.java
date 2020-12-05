package com.campus.soccer.league;

import com.campus.soccer.league.domain.Game;
import com.campus.soccer.league.domain.League;

import java.util.Random;

public class SoccerGameThread implements Runnable {

    private final Game soccerGame;
    private final League league;

    public SoccerGameThread(Game soccerGame, League league) {
        this.soccerGame = soccerGame;
        this.league = league;
    }


    @Override
    public void run() {
        SoccerLeagueApplication.threadMessage("Game started");
        try {
            soccerGame.setGoalsForGuestTeam(randomGoals());
            soccerGame.setGoalsForHomeTeam(randomGoals());
            Thread.sleep(4000);
            SoccerLeagueApplication.threadMessage("Game finished: " + soccerGame.getGameResultAsString());
            league.addGameResult(soccerGame);
        } catch (InterruptedException e) {
            SoccerLeagueApplication.threadMessage("Thread interrupted - wasn't done!");
        }
    }


    private int randomGoals() {
        Random random = new Random();
        return random.nextInt(10 + 1);
    }
}
