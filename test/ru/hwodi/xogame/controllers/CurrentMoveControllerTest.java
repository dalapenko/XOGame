package ru.hwodi.xogame.controllers;

import org.junit.Test;
import ru.hwodi.xogame.model.Field;
import ru.hwodi.xogame.model.Figure;
import ru.hwodi.xogame.model.Point;
import ru.hwodi.xogame.model.exceptions.AlreadyOccupiedException;
import ru.hwodi.xogame.model.exceptions.InvalidePointException;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMoveWhenFirstStep() {
        Field field = new Field();
        Figure expectedFigure = Figure.X;
        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure actualFigure = currentMoveController.currentMove(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void currentMoveWhenOStep() throws AlreadyOccupiedException, InvalidePointException {
        Field field = new Field();
        Figure expectedFigure = Figure.O;
        Point testPoint = new Point(0, 0);
        field.setFigure(testPoint, Figure.X);
        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure actualFigure = currentMoveController.currentMove(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void currentMoveWhenXStep() throws AlreadyOccupiedException, InvalidePointException {
        Field field = new Field();
        Figure expectedFigure = Figure.X;
        Point xPoint = new Point(0, 0);
        Point oPoint = new Point(0, 1);
        field.setFigure(xPoint, Figure.X);
        field.setFigure(oPoint, Figure.O);
        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure actualFigure = currentMoveController.currentMove(field);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void currentMoveWhenNoMove() throws AlreadyOccupiedException, InvalidePointException {
        Field field = new Field();
        int fieldSize = field.getSize();

        for (int i = 0; i < fieldSize; i ++) {
            for (int j = 0; j < fieldSize; j++) {
                Point currentPoint = new Point(i, j);
                field.setFigure(currentPoint, Figure.O);
            }
        }

        CurrentMoveController currentMoveController = new CurrentMoveController();
        Figure actualFigure = currentMoveController.currentMove(field);

        assertNull(actualFigure);
    }
}