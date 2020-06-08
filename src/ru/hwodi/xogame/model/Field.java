package ru.hwodi.xogame.model;

import ru.hwodi.xogame.model.exceptions.InvalidePointException;

public class Field {
    private final int FIELD_SIZE = 3;
    private final int MIN_COORDINATE = 0;

    private Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return this.FIELD_SIZE;
    }

    public Figure getFigure(Point point) {
        return this.field[point.getX()][point.getY()];
    }

    public void setFigure(Point point, Figure figure) throws InvalidePointException {
        if (!isPointValid(point)) {
            throw new InvalidePointException();
        }
        this.field[point.getX()][point.getY()] = figure;
    }

    private boolean isPointValid(Point point) {
        int x = point.getX();
        int y = point.getY();

        return (isCoordinateValid(x) && isCoordinateValid(y));
    }

    private boolean isCoordinateValid(int coordinate) {
        return (coordinate < this.FIELD_SIZE && coordinate >= this.MIN_COORDINATE);
    }
}
