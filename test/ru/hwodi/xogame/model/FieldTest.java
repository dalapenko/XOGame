package ru.hwodi.xogame.model;

import org.junit.Test;
import ru.hwodi.xogame.model.exceptions.AbstractXOException;
import ru.hwodi.xogame.model.exceptions.InvalidePointException;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSize() {
        int expectedSize = 3;
        Field field = new Field();
        int actualSize = field.getSize();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void getFigureWhenFigureSetAndX() throws AbstractXOException {
        Figure expectedFigure = Figure.X;
        Field field = new Field();
        Point testPoint = new Point(0, 0);

        field.setFigure(testPoint, Figure.X);
        Figure actualFigure = field.getFigure(testPoint);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getFigureWhenFigureSetAndO() throws AbstractXOException {
        Figure expectedFigure = Figure.O;
        Field field = new Field();
        Point testPoint = new Point(0, 0);
        field.setFigure(testPoint, Figure.O);
        Figure actualFigure = field.getFigure(testPoint);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void getFigureWhenFigureNotSet() throws AbstractXOException {
        Point testPoint = new Point(0, 0);
        Field field = new Field();
        Figure actualFigure = field.getFigure(testPoint);

        assertNull(actualFigure);
    }

    @Test
    public void getFigureWhenPointLessThenZero() {
        Point testPoint = new Point(-1, -1);
        Field field = new Field();
        try {
            field.getFigure(testPoint);
            fail();
        } catch (InvalidePointException ignored) {
        }
    }

    @Test
    public void getFigureWhenXOfPointLessThenZero() {
        Point testPoint = new Point(-1, 0);
        Field field = new Field();
        try {
            field.getFigure(testPoint);
            fail();
        } catch (InvalidePointException ignored) {
        }
    }

    @Test
    public void getFigureWhenYOfPointLessThenZero() {
        Point testPoint = new Point(0, -1);
        Field field = new Field();
        try {
            field.getFigure(testPoint);
            fail();
        } catch (InvalidePointException ignored) {
        }
    }

    @Test
    public void getFigureWhenPointMoreThenFieldSize() {
        Field field = new Field();
        int fieldSize = field.getSize();
        int coordinate = fieldSize + 1;
        Point testPoint = new Point(coordinate, coordinate);
        try {
            field.getFigure(testPoint);
            fail();
        } catch (InvalidePointException ignored) {
        }
    }

    @Test
    public void getFigureWhenXOfPointMoreThenFieldSize() {
        Field field = new Field();
        int fieldSize = field.getSize();
        int x = fieldSize + 1;
        Point testPoint = new Point(x, 2);
        try {
            field.getFigure(testPoint);
            fail();
        } catch (InvalidePointException ignored) {
        }
    }

    @Test
    public void getFigureWhenYOfPointMoreThenFieldSize() {
        Field field = new Field();
        int fieldSize = field.getSize();
        int y = fieldSize + 1;
        Point testPoint = new Point(2, y);

        try {
            field.getFigure(testPoint);
            fail();
        } catch (InvalidePointException ignored) {
        }
    }

    @Test
    public void setFigure() throws AbstractXOException {
        Field field = new Field();
        Point testPoint = new Point(0, 0);
        Figure expectedFigure = Figure.X;
        field.setFigure(testPoint, expectedFigure);
        Figure actualFigure = field.getFigure(testPoint);

        assertEquals(expectedFigure, actualFigure);
    }

    @Test
    public void setFigureWhenAlreadyOccupied() {
        Field field = new Field();
        Point testPoint = new Point(0, 0);
        Figure expectedFigure = Figure.X;
        try {
            field.setFigure(testPoint, expectedFigure);
            field.setFigure(testPoint, expectedFigure);
            fail();
        } catch (AbstractXOException ignored) {}
    }

    @Test
    public void setFigureWhenPointLessThanZero() {
        Field field = new Field();
        Point testPoint = new Point(-1, -1);
        Figure testFigure = Figure.X;
        try {
            field.setFigure(testPoint, testFigure);
            fail();
        } catch (AbstractXOException ignored) {}
    }

    @Test
    public void setFigureWhenXOfPointLessThanZero() {
        Field field = new Field();
        Point testPoint = new Point(-1, 0);
        Figure testFigure = Figure.X;
        try {
            field.setFigure(testPoint, testFigure);
            fail();
        } catch (AbstractXOException ignored) {}
    }

    @Test
    public void setFigureWhenYOfPointLessThanZero() {
        Field field = new Field();
        Point testPoint = new Point(0, -1);
        Figure testFigure = Figure.X;
        try {
            field.setFigure(testPoint, testFigure);
            fail();
        } catch (AbstractXOException ignored) {}
    }

    @Test
    public void setFigureWhenPointMoreThanFieldSize() {
        Field field = new Field();
        int fieldSize = field.getSize();
        int coordinate = fieldSize + 1;
        Point testPoint = new Point(coordinate, coordinate);
        Figure testFigure = Figure.X;
        try {
            field.setFigure(testPoint, testFigure);
            fail();
        } catch (AbstractXOException ignored) {}
    }

    @Test
    public void setFigureWhenXOfPointMoreThanFieldSize() {
        Field field = new Field();
        int fieldSize = field.getSize();
        int coordinate = fieldSize + 1;
        Point testPoint = new Point(coordinate, 0);
        Figure testFigure = Figure.X;
        try {
            field.setFigure(testPoint, testFigure);
            fail();
        } catch (AbstractXOException ignored) {}
    }

    @Test
    public void setFigureWhenYOfPointMoreThanFieldSize() {
        Field field = new Field();
        int fieldSize = field.getSize();
        int coordinate = fieldSize + 1;
        Point testPoint = new Point(0, coordinate);
        Figure testFigure = Figure.X;
        try {
            field.setFigure(testPoint, testFigure);
            fail();
        } catch (AbstractXOException ignored) {}
    }
}