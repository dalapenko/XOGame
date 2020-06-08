package ru.hwodi.boardgame.model;

public class Player {
    private String name;
    private Figure figure;

    public Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return this.name;
    }

    public Figure getFigure() {
        return this.figure;
    }
}
