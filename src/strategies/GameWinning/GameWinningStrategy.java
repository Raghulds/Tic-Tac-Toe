package strategies.GameWinning;

import Objects.Board;
import Objects.Cell;
import Objects.Player;

public interface GameWinningStrategy {
    public boolean checkWinner(Board board, Player player, Cell movedTo);
}
