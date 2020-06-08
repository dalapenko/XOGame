package ru.hwodi.xogame.controllers;

import ru.hwodi.xogame.model.Field;
import ru.hwodi.xogame.model.Figure;
import ru.hwodi.xogame.model.Point;
import ru.hwodi.xogame.model.exceptions.InvalidePointException;

public class WinnerController {

    public Figure getWinner(Field field) {
        Figure winFigure = checkHorizontalWinCombination(field);
        if (winFigure == null) {
            winFigure = checkVerticalWinCombination(field);
        }
        if (winFigure == null) {
            winFigure = checkMainDiagonalWinCombination(field);
        }
        if (winFigure == null) {
            winFigure = checkSideDiagonalWinCombination(field);
        }
        return winFigure;
    }

    private Figure checkHorizontalWinCombination(Field field) {
        int fieldSize = field.getSize();

        for (int i = 0; i < fieldSize; i++) {
            int matched = 0;
            Figure lastFigure = null;

            for (int j = 0; j < fieldSize; j++) {
                Point point = new Point(i, j);
                Figure figure = null;
                try {
                    figure = field.getFigure(point);
                } catch (InvalidePointException ignored) {}

                if (figure != null) {
                    if (lastFigure == null) {
                        lastFigure = figure;
                    }

                    if (lastFigure.equals(figure)) {
                        matched++;
                    }
                }
            }
            if (matched == fieldSize) {
                return lastFigure;
            }
        }
        return null;
    }

    private Figure checkVerticalWinCombination(Field field) {
        int fieldSize = field.getSize();

        for (int i = 0; i < fieldSize; i++) {
            int matched = 0;
            Figure lastFigure = null;

            for (int j = 0; j < fieldSize; j++) {
                Point point = new Point(j, i);
                Figure figure = null;
                try {
                    figure = field.getFigure(point);
                } catch (InvalidePointException ignored) {}

                if (figure != null) {
                    if (lastFigure == null) {
                        lastFigure = figure;
                    }

                    if (lastFigure.equals(figure)) {
                        matched++;
                    }
                }
            }
            if (matched == fieldSize) {
                return lastFigure;
            }
        }
        return null;
    }

    private Figure checkMainDiagonalWinCombination(Field field) {
        int fieldSize = field.getSize();
        int matched = 0;
        Figure lastFigure = null;

        for (int i = 0; i < fieldSize; i++) {
            Point point = new Point(i, i);
            Figure figure = null;
            try {
                figure = field.getFigure(point);
            } catch (InvalidePointException ignored) {}

            if (figure != null) {
                if (lastFigure == null) {
                    lastFigure = figure;
                }

                if (lastFigure.equals(figure)) {
                    matched++;
                } else {
                    return null;
                }
            }
        }
        return (matched == fieldSize)?lastFigure:null;
    }

    private Figure checkSideDiagonalWinCombination(Field field) {
        int fieldSize = field.getSize();
        int matched = 0;
        Figure lastFigure = null;

        for (int i = 0; i < fieldSize; i++) {
            int j = fieldSize - i - 1;
            Point point = new Point(i, j);
            Figure figure = null;
            try {
                figure = field.getFigure(point);
            } catch (InvalidePointException ignored) {}

            if (figure != null) {
                if (lastFigure == null) {
                    lastFigure = figure;
                }

                if (lastFigure.equals(figure)) {
                    matched++;
                } else {
                    return null;
                }
            }
        }
        return (matched == fieldSize) ? lastFigure : null;
    }
}
