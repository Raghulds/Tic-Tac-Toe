package strategies.BotPlaying;

import Enums.CellStatusEnum;
import Objects.Board;
import Objects.Cell;
import Objects.Move;
import Objects.Player;

public class RandomPlayWinningStrategy implements BotPlayingStrategy {

    public Move decideNextMove(Player player, Board board) {
        for(int i=0;i<board.getBoard().getSize();i++) {
            for (int j = 0; j < board.getBoard().getSize(); j++) {
                if(board.getCells().get(i).get(j).equals(CellStatusEnum.FREE)) {
                    return new Move(player, new Cell(i, j));
                }
            }
        }
        return null;
    }
}
