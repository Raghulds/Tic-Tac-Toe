package Controllers;

import Objects.Cell;
import Objects.Game;
import Objects.Move;
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

    public void winningStrategy() {
        // From the current cell, check if any symbols formed in diagonal, same row or same column
    }

    public void restartGame() {}

}
