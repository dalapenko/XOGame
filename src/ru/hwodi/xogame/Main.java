package ru.hwodi.xogame;

import ru.hwodi.xogame.model.Field;
import ru.hwodi.xogame.model.Figure;
import ru.hwodi.xogame.model.Game;
import ru.hwodi.xogame.model.Player;
import ru.hwodi.xogame.view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Volovya", Figure.X);
        Player player2 = new Player("Tolik", Figure.O);
        String gameName = "XOGame";
        Player[] players = {player1, player2};
        Game game = new Game(players, new Field(), gameName);
        ConsoleView view = new ConsoleView();
        view.show(game);
    }
}
