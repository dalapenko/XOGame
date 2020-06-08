package ru.hwodi.xogame.view;

import ru.hwodi.xogame.controllers.CurrentMoveController;
import ru.hwodi.xogame.controllers.MoveController;
import ru.hwodi.xogame.controllers.WinnerController;
import ru.hwodi.xogame.model.Field;
import ru.hwodi.xogame.model.Figure;
import ru.hwodi.xogame.model.Game;
import ru.hwodi.xogame.model.Point;
import ru.hwodi.xogame.model.exceptions.AlreadyOccupiedException;
import ru.hwodi.xogame.model.exceptions.InvalidePointException;

import java.util.Scanner;

public class ConsoleView {

    private CurrentMoveController currentMoveController = new CurrentMoveController();
    private WinnerController winnerController = new WinnerController();
    private MoveController moveController = new MoveController();

    public void show(Game game) {
        Field field = game.getField();
        int fieldSize = field.getSize();
        for (int i = 0; i < fieldSize; i++) {
            printline(field, i);
            if (i != (fieldSize - 1)) printRowSeparator();
        }
    }

    public boolean move(Game game) {
        Field field = game.getField();
        Figure winner = winnerController.getWinner(field);
        if (winner != null) {
            System.out.format("End Game. Winner is %s", winner);
            return false;
        }
        Figure currentFigure = currentMoveController.currentMove(field);
        if (currentFigure == null) {
            System.out.println("End Game. No move left");
            return false;
        }
        System.out.format("Please enter next point for %s\n", currentFigure);
        Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidePointException | AlreadyOccupiedException e) {
            System.out.println("Invalid point");
        }
        return true;
    }

    private Point askPoint() {
        int x = askCoordinate("X") - 1;
        int y = askCoordinate("Y") - 1;
        return new Point(y, x);
    }

    private int askCoordinate(String coordinateName) {
        System.out.format("Please input %s coordinate: ", coordinateName);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void printline(Field field, int row) {
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
            String element = (figure != null)?figure.toString():" ";
            System.out.format(" %s ", element);
            if (i != (fieldSize - 1)) {
                System.out.print("|");
            }
        }
        System.out.println();
    }

    private void printRowSeparator() {
        for (int i = 0; i < 3; i++) {
            System.out.print("----");
        }
        System.out.println();
    }
}
