package com.campus.soccer.league;

import com.campus.soccer.league.domain.Game;

public class SoccerGameThread implements Runnable {

    private Game soccerGame;

    public SoccerGameThread(Game soccerGame) {
        this.soccerGame = soccerGame;
    }


    @Override
    public void run() {
       soccerGame.setGoalsForGuestTeam(1);
       soccerGame.setGoalsForHomeTeam(2);
    }
}
