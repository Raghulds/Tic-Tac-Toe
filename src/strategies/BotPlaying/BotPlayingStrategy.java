package strategies.BotPlaying;

import Objects.Board;
import Objects.Move;
import Objects.Player;

public interface BotPlayingStrategy {

    public Move decideNextMove(Player player, Board board);
}
