package ru.hwodi.boardgame.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getPlayers() {
        Player[] expectedPlayers = {new Player("Volodya", null),
                                    new Player("Saimon", null)};
        Game game = new Game(expectedPlayers, null, null);
        Player[] actualPlayers = game.getPlayers();

        assertEquals(expectedPlayers, actualPlayers);
    }

    @Test
    public void getField() {
        Field expectedField = new Field();
        Game game = new Game(null, expectedField, null);
        Field actualField = game.getField();

        assertEquals(expectedField, actualField);
    }

    @Test
    public void getName() {
        String expectedName = "XOGame";
        Game game = new Game(null, null, expectedName);
        String actualName = game.getName();

        assertEquals(expectedName, actualName);
    }
}