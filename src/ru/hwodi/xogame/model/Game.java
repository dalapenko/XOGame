package ru.hwodi.xogame.model;

import java.util.Arrays;
import java.util.Iterator;

public class Game implements Iterable<Player>{
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

    @Override
    public Iterator<Player> iterator() {
        return Arrays.asList(players).iterator();
    }
}
