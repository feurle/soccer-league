package com.campus.soccer.league;

import com.campus.soccer.league.domain.Game;
import com.campus.soccer.league.domain.League;
import com.campus.soccer.league.domain.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SoccerTests {

    private League league;
    Team realMadrid;
    Team manchesterCity;
    Team bayernMünchen;

    @BeforeEach
    void setUp(){
        league = new League();
        realMadrid = new Team("Real Madrid");
        manchesterCity = new Team("Manchester City");
        bayernMünchen = new Team("Bayern München");
    }


    @Test
    void testAddGameResult(){
        Game game1 = new Game(realMadrid, manchesterCity, 1, 3);
        league.addGameResult(game1);
        assertEquals(2, league.getTeamTable().size());
        Game game2 = new Game(manchesterCity, bayernMünchen, 2, 2);
        league.addGameResult(game2);
        assertEquals(3, league.getTeamTable().size());
    }

    @Test
    void testTeamTableSort(){
        Game game1 = new Game(realMadrid, manchesterCity, 1, 3);
        league.addGameResult(game1);
        assertEquals(manchesterCity, league.getTeamTable().getFirst());
        Game game2 = new Game(manchesterCity, bayernMünchen, 2, 2);
        league.addGameResult(game2);
        assertEquals(bayernMünchen, league.getTeamTable().get(1));
    }

    @Test
    void testGetDraws(){
        Game game1 = new Game(realMadrid, manchesterCity, 1, 3);
        league.addGameResult(game1);
        assertEquals(0, league.getTeamTable().getFirst().getDraws());
        Game game2 = new Game(manchesterCity, bayernMünchen, 2, 2);
        league.addGameResult(game2);
        assertEquals(1, league.getTeamTable().getFirst().getDraws());
    }

    @Test
    void testGetWins(){
        Game game1 = new Game(realMadrid, manchesterCity, 1, 3);
        league.addGameResult(game1);
        assertEquals(1, league.getTeamTable().getFirst().getWins());
        Game game2 = new Game(manchesterCity, bayernMünchen, 2, 2);
        league.addGameResult(game2);
        assertEquals(1, league.getTeamTable().getFirst().getWins());
    }

    @Test
    void testGetDefeats(){
        Game game1 = new Game(realMadrid, manchesterCity, 1, 3);
        league.addGameResult(game1);
        assertEquals(0, league.getTeamTable().getFirst().getDefeats());
        Game game2 = new Game(manchesterCity, bayernMünchen, 2, 3);
        league.addGameResult(game2);
        assertEquals(1, league.getTeamTable().getFirst().getDefeats()
        );
    }

    @Test
    void testGetGoalDifference(){
        Game game1 = new Game(realMadrid, manchesterCity, 1, 3);
        league.addGameResult(game1);
        assertEquals(-2, league.getTeamTable().getLast().getGoalDifference());
        Game game2 = new Game(manchesterCity, bayernMünchen, 2, 2);
        league.addGameResult(game2);
        assertEquals(-2, league.getTeamTable().getLast().getGoalDifference());
    }
}
