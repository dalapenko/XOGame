package ru.hwodi.xogame.controllers;

import ru.hwodi.xogame.model.Field;
import ru.hwodi.xogame.model.Figure;
import ru.hwodi.xogame.model.Point;
import ru.hwodi.xogame.model.exceptions.InvalidePointException;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = 0;
        int fieldSize = field.getSize();
        int countCell = fieldSize * fieldSize;
        for (int x = 0; x < fieldSize; x++) {
            countFigure += countFiguresInTheRow(field, x);
        }

        if (countFigure == countCell) {
            return null;
        }
        else {
            return (countFigure % 2 == 0)?Figure.X:Figure.O;
        }
    }

    private int countFiguresInTheRow(final Field field, final Integer row) {
        int countFigure = 0;
        int fieldSize = field.getSize();
        for (int x = 0; x < fieldSize; x++) {
            final Point p = new Point(x, row);
            try {
                if (field.getFigure(p) != null)
                    countFigure++;
            } catch (InvalidePointException ignored) {
            }
        }
        return countFigure;
    }
}
