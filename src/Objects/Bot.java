package Objects;

import Enums.CellStatusEnum;
import Enums.PlayerDifficultyEnum;
import Enums.PlayerTypeEnum;

public class Bot extends Player {

    public PlayerDifficultyEnum difficulty;

    public Bot(String name, char symbol, PlayerDifficultyEnum difficulty, int index) {
        super(name, symbol, PlayerTypeEnum.BOT, index);
        this.difficulty = difficulty;
    }

    public Move decideNextMove(Bot player, Board board) {
        for(int i=0;i<board.getBoard().getSize();i++) {
            for (int j = 0; j < board.getBoard().getSize(); j++) {
              if(board.getCells().get(i).get(j).equals(CellStatusEnum.FREE)) {
                  return new Move(player, new Cell(i, j));
              }
            }
        }
        return  null;
    }
}
