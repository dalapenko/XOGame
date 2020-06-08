package ru.hwodi.xogame.controllers;

import org.junit.Test;
import ru.hwodi.xogame.model.Field;
import ru.hwodi.xogame.model.Figure;
import ru.hwodi.xogame.model.Point;
import ru.hwodi.xogame.model.exceptions.AbstractXOException;

import static org.junit.Assert.*;

public class MoveControllerTest {
    @Test
    public void applyFigure() throws AbstractXOException {
        Field field = new Field();
        Point testPoint = new Point(0, 0);
        Figure expectedFigure = Figure.X;
        MoveController moveController = new MoveController();
        moveController.applyFigure(field, testPoint, expectedFigure);
        Figure actualFigure = field.getFigure(testPoint);

        assertEquals(expectedFigure, actualFigure);
    }
}