package Objects;

public class Move {

    public Player player;
    public Cell currentCell;

    public Player getPlayer() {
        return player;
    }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public Move(Player player, Cell currentCell) {
        this.player = player;
        this.currentCell = currentCell;
    }
}
