package ru.hwodi.boardgame.model;

public class Game {
    private Player[] players;
    private Field field;
    private String name;

    public Game(Player[] players, Field field, String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public Field getField() {
        return this.field;
    }

    public String getName() {
        return this.name;
    }
}
