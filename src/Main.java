import Controllers.GameController;
import Enums.GameStatusEnum;
import Enums.PlayerDifficultyEnum;
import Enums.PlayerTypeEnum;
import Objects.Bot;
import Objects.Game;
import Objects.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Tic Tac Toe");

        Scanner in = new Scanner(System.in);
        GameController gameControl = new GameController();

        System.out.println("What is the dimension of the board?");
        int dimension = in.nextInt();

        System.out.println("Will there be a bot in the game? y/N");
        String isBotPlaying = in.next();

        List<Player> players = new ArrayList<>();

        int noOfPlayers = dimension;
        if(isBotPlaying.equals('y') || players.size() == 1) {
            noOfPlayers = dimension - 1;
        }

        for(int i=0;i< noOfPlayers;i++) {
            System.out.println("Enter the name for player " + (i+1) + ":");
            String playerName = in.next();
            System.out.println("Enter the symbol for player " + (i+1) + ":");
            char playerSymbol = in.next().charAt(0);
            players.add(new Player(playerName, playerSymbol, PlayerTypeEnum.HUMAN, i));
        }

        if(isBotPlaying.equals('y') || noOfPlayers == 1) {
            // generate any char other than Player's symbol
            Random random = new Random();
            String botSymbol = String.valueOf((char)(random.nextInt(26) + 'A'));
            players.add(new Bot("Bot 1", '*', PlayerDifficultyEnum.EASY, players.size() + 1));
        }

        Game game = gameControl.createGame(dimension, players);

        while(game.getGameStatus().equals(GameStatusEnum.IN_PROGRESS)) {
            game.displayBoard();
            gameControl.nextMove(game);
        }
    }
}