package Controllers;

import Objects.Game;
import Objects.Player;

import java.util.List;

public class GameController {

    public Game createGame(int dimension, List<Player> players) {
        Game game = Game.getGameBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();
        game.displayBoard();
        return game;
    }

    public Game startGame(Game game) {
        return game;
    }

    public Game nextMove(Game game) {
        return game.nextMove();
    }

    public Game restartGame(int dimension, List<Player> players) {
        return Game.getGameBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();
    }

}
