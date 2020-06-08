package ru.hwodi.xogame.view;

import ru.hwodi.xogame.model.Field;
import ru.hwodi.xogame.model.Figure;
import ru.hwodi.xogame.model.Game;
import ru.hwodi.xogame.model.Point;
import ru.hwodi.xogame.model.exceptions.InvalidePointException;

public class ConsoleView {
    public void show(Game game) {
        Field field = game.getField();
        int fieldSize = field.getSize();
        for (int i = 0; i < fieldSize; i++) {
            printline(field, i);
        }
    }

    public void printline(Field field, int row) {
        int fieldSize = field.getSize();

        for (int i = 0; i < fieldSize; i++) {
            Point currentPoint = new Point(row, i);
            Figure figure;
            try {
                figure = field.getFigure(currentPoint);
            } catch (InvalidePointException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
            System.out.println((figure != null)?figure:" ");
            System.out.println("|");
        }
    }
}
