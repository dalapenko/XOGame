package ru.hwodi.boardgame.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        String expectedName = "Volodya";
        Player player = new Player(expectedName, Figure.X);
        String actualName = player.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getFigure() {
        Figure expectedFigure = Figure.X;
        Player player = new Player("Volodya", expectedFigure);
        Figure actualFigure = player.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }
}