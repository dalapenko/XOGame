package ru.hwodi.boardgame.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void getX() {
        int expectedX = 5;

        Point point = new Point(expectedX, 3);
        int actualX = point.getX();

        assertEquals(expectedX, actualX);
    }

    @Test
    public void getY() {
        int expectedY = 5;

        Point point = new Point(3, expectedY);
        int actualY = point.getY();

        assertEquals(expectedY, actualY);
    }
}