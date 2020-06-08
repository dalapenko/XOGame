package ru.hwodi.xogame.model;

public class Field {
    private final int FIELD_SIZE = 3;
    private Figure[][] field = new Figure[FIELD_SIZE][FIELD_SIZE];

    public int getSize() {
        return this.FIELD_SIZE;
    }

    public Figure getFigure(Point point) {
        return this.field[point.getX()][point.getY()];
    }

    public void setFigure(Point point, Figure figure) {
        this.field[point.getX()][point.getY()] = figure;
    }
}
