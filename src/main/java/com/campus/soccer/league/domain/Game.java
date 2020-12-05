package com.campus.soccer.league.domain;

/**
 * This class represents an soccer game.
 *
 * Ratinale: THis class is there......
 *
 *
 */
public class Game {

    private final Team homeTeam;
    private final Team guestTeam;
    private int goalsForHomeTeam;
    private int goalsForGuestTeam;

    /**
     *
     * @param homeTeam
     * @param guestTeam
     * @param goalsForHomeTeam
     * @param goalsForGuestTeam
     */
    public Game(Team homeTeam, Team guestTeam, int goalsForHomeTeam, int goalsForGuestTeam) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.goalsForHomeTeam = goalsForHomeTeam;
        this.goalsForGuestTeam = goalsForGuestTeam;
    }

    /**
     * This method returns a home team.
     * @return the home team
     */
    public Team getHomeTeam() {
        return homeTeam;
    }

    /*
    * sdafasdf afd asd f
     */
    public Team getGuestTeam() {
        return guestTeam;
    }

    public int getPointsForHomeTeam() {
        return getGoalsForHomeTeam() > getGoalsForGuestTeam() ? 3 : getGoalsForHomeTeam() < getGoalsForGuestTeam() ? 0 : 1;
    }

    public int getPointsForGuestTeam() {
        return getGoalsForHomeTeam() > getGoalsForGuestTeam() ? 0 : getGoalsForHomeTeam() < getGoalsForGuestTeam() ? 3 : 1;
    }

    public int getGoalsForHomeTeam() {
        return goalsForHomeTeam;
    }

    public int getGoalsForGuestTeam() {
        return goalsForGuestTeam;
    }

    public void setGoalsForHomeTeam(int goalsForHomeTeam) {
        this.goalsForHomeTeam = goalsForHomeTeam;
    }

    public void setGoalsForGuestTeam(int goalsForGuestTeam) {
        this.goalsForGuestTeam = goalsForGuestTeam;
    }
}
