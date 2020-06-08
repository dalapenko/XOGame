package ru.hwodi.xogame.controllers;

import org.junit.Test;
import ru.hwodi.xogame.model.Field;
import ru.hwodi.xogame.model.Figure;
import ru.hwodi.xogame.model.Point;
import ru.hwodi.xogame.model.exceptions.AlreadyOccupiedException;
import ru.hwodi.xogame.model.exceptions.InvalidePointException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getXOHorizontalWinner() throws AlreadyOccupiedException, InvalidePointException {
        Field field = new Field();
        Figure expectedFigure = WinnerControllerTest.getRandomFigure();
        int fieldSize = field.getSize();
        for (int i = 0; i < fieldSize; i++) {
            Point currentPoint = new Point(0, i);
            field.setFigure(currentPoint, expectedFigure);
        }
        WinnerController winnerController = new WinnerController();
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getXOVerticalWinner() throws AlreadyOccupiedException, InvalidePointException {
        Field field = new Field();
        Figure expectedFigure = WinnerControllerTest.getRandomFigure();
        int fieldSize = field.getSize();
        for (int i = 0; i < fieldSize; i++) {
            Point currentPoint = new Point(i, 0);
            field.setFigure(currentPoint, expectedFigure);
        }
        WinnerController winnerController = new WinnerController();
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getXOMainDiagonalWinner() throws AlreadyOccupiedException, InvalidePointException {
        Field field = new Field();
        Figure expectedFigure = WinnerControllerTest.getRandomFigure();
        int fieldSize = field.getSize();
        for (int i = 0; i < fieldSize; i++) {
            Point currentPoint = new Point(i, i);
            field.setFigure(currentPoint, expectedFigure);
        }
        WinnerController winnerController = new WinnerController();
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getXOSideDiagonalWinner() throws AlreadyOccupiedException, InvalidePointException {
        Field field = new Field();
        Figure expectedFigure = WinnerControllerTest.getRandomFigure();
        int fieldSize = field.getSize();
        for (int i = 0; i < fieldSize; i++) {
            int j = (fieldSize - 1) - i;
            Point currentPoint = new Point(i, j);
            field.setFigure(currentPoint, expectedFigure);
        }
        WinnerController winnerController = new WinnerController();
        Figure actualFigure = winnerController.getWinner(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getWinnerWhenNoWinner() {
        Field field = new Field();
        WinnerController winnerController = new WinnerController();
        Figure actualFigure = winnerController.getWinner(field);

        assertNull(actualFigure);
    }

    private static Figure getRandomFigure()  {
        Random random = new Random(1);
        return (random.nextInt() == 0)?Figure.X:Figure.O;
    }

}