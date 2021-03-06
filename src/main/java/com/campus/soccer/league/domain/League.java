package com.campus.soccer.league.domain;

import java.util.Collections;
import java.util.LinkedList;

public class League {

    private LinkedList<Team> teamTable;

    public void addGameResult(Game g){
        if(teamTable.contains(g.getHomeTeam())){
            g.getHomeTeam().addGame(g);
        }
        else{
            teamTable.add(g.getHomeTeam());
            g.getHomeTeam().addGame(g);
        }

        if(teamTable.contains(g.getGuestTeam())){
            g.getGuestTeam().addGame(g);
        }
        else{
            teamTable.add(g.getGuestTeam());
            g.getGuestTeam().addGame(g);
        }
    }

    public League() {
        teamTable = new LinkedList<Team>();
    }

    public LinkedList<Team> getTeamTable() {
        Collections.sort(teamTable);
        return teamTable;
    }
}
