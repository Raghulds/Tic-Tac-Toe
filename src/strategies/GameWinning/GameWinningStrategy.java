package strategies.GameWinning;

import Objects.Board;
import Objects.Player;

public interface GameWinningStrategy {
    public Player checkWinner(Board board);
}
