package com.campus.soccer.league.domain;

public class Team implements Comparable<Team> {

    private String name;
    private int points;
    private int wins;
    private int defeats;
    private int draws;
    private int goalsShot;
    private int goalsReceived;

    public Team(String name) {
        this.name = name;
    }

    public void addGame(Game g){
        if(g.getHomeTeam() == this){
            switch (g.getPointsForHomeTeam()){
                case 0:
                    defeats++;
                    break;
                case 1:
                    draws++;
                    break;
                case 3:
                    wins++;
                    break;
            }
            points+= g.getPointsForHomeTeam();
            goalsShot += g.getGoalsForHomeTeam();
            goalsReceived += g.getGoalsForGuestTeam();
        }
        else{
            switch (g.getPointsForGuestTeam()){
                case 0:
                    defeats++;
                    break;
                case 1:
                    draws++;
                    break;
                case 3:
                    wins++;
                    break;
            }
            points+= g.getPointsForGuestTeam();
            goalsShot += g.getGoalsForGuestTeam();
            goalsReceived += g.getGoalsForHomeTeam();
        }
    }

    public int getPoints(){
        return points;
    }

    public int getGoalDifference(){
        return getGoalsShot() - getGoalsReceived();
    }

    public String getName() {
        return name;
    }

    public int getWins(){
        return wins;
    }

    public int getDraws(){
        return draws;
    }

    public int getDefeats(){

        return defeats;
    }

    public int getGoalsShot(){
        return goalsShot;
    }

    public int getGoalsReceived(){
        return goalsReceived;
    }

    public int compareTo(Team other){
        return getPoints() > other.getPoints() ? -1 : getPoints() < other.getPoints() ? 1 : 0;
    }
}
