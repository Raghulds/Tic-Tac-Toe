package Objects;

import Enums.CellStatusEnum;
import Enums.GameStatusEnum;
import Enums.PlayerDifficultyEnum;
import Exceptions.DimensionCountLowerThanPlayersCountException;
import Exceptions.PlayersEmptyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public int dimension = 0;
    public Player winner;
    public GameStatusEnum gameStatus = GameStatusEnum.YET_TO_START;
    public Board board;
    public List<Move> moves;
    public int currentPlayerIndex = 0;
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public Player getWinner() {
        return winner;
    }
    public GameStatusEnum getGameStatus() {
        return gameStatus;
    }
    public Game setGameStatus(GameStatusEnum gameStatus) {
        this.gameStatus = gameStatus;
        return this;
    }
    public int getDimension() {
        return dimension;
    }
    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Board getBoard() {
        return board;
    }

    public int getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public void setCurrentPlayerIndex(int currentPlayerIndex) {
        this.currentPlayerIndex = currentPlayerIndex;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayerByIndex(int index) {
        return players.get(index);
    }

    public Game setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public List<Player> players;

    Game(List<Player> players) {
        this.players = players;
    }

    public Game setBoard(Board board) {
        this.board = board;
        return this;
    }

    public static GameBuilder getGameBuilder() {
        return new GameBuilder();
    }

    public boolean winningStrategy() {
        return true;
    }
    public void displayBoard() {
        System.out.println("Current board :");
        for (int i=0;i<this.board.cells.size();i++) {
            List<Cell> cellList = this.board.cells.get(i);
            for (int j = 0; j < this.board.cells.get(i).size(); j++) {
                char symbolInCell = cellList.get(j).symbol;
                if (j == this.board.cells.get(i).size() - 1) {
                    System.out.println(symbolInCell);
                } else {
                    System.out.print(symbolInCell);
                }
            }
        }
    }

    public boolean validateMove(Move move, Board board) {
        Cell targetCell = this.board.getBoard()
                .getCells()
                .get(move.currentCell.getRow())
                .get(move.currentCell.getCol());
        if(targetCell.getStatus().equals(CellStatusEnum.OCCUPIED)) return false;
        return true;
    }

    public Game nextMove() {
        Player currentPlayer = this.getPlayerByIndex(this.getCurrentPlayerIndex());
        System.out.println(currentPlayer.name + "! It's your turn.");
        Move move = currentPlayer.decideNextMove();
        if(move == null) {
            // Game drawn
            System.out.println("No moves left! Game drawn. Re-start?");
        }
        // Validate move
        if(validateMove(move, this.board) == false)  {
            System.out.println("Cell was occupied. Try another cell!");
            return this;
        }
        this.board.cells
                .get(move.currentCell.getRow())
                .get(move.currentCell.getCol())
                .setPlayer(currentPlayer)
                .setSymbol(currentPlayer.symbol)
                .setStatus(CellStatusEnum.OCCUPIED);
        this.setCurrentPlayerIndex((this.getCurrentPlayerIndex() + 1) % players.size());
        // Check winner
        return this;
    }

    public static class GameBuilder {

        public int dimension;
        public Board board;
        public List<Player> players;

        public int getDimension() {
            return dimension;
        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public Board getBoard() {
            return board;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public void validations() throws PlayersEmptyException, DimensionCountLowerThanPlayersCountException {
            // players shouldn't be empty
            if(players.size() == 0) {
                throw new PlayersEmptyException("Atleast one player required to start a Game");
            }
            // dimensions required & greater than players count
            if(dimension == 0 || dimension < players.size()) {
                String s = "Board dimensions should be greater than players count " + players.size();
                throw new DimensionCountLowerThanPlayersCountException(s);
            }
        }

        public Game build() throws RuntimeException {
            try {
                validations();
            }
            catch(Exception e) {
                throw new RuntimeException("q");
            }

            Game game = new Game(players);
            game.setDimension(dimension);
            game.setBoard(new Board(players.size()));
            game.setGameStatus(GameStatusEnum.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
            return game;
        }
    }
}
