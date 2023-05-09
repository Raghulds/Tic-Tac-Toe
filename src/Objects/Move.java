package Objects;

public class Move {

    public Player player;
    public Cell currentCell;

    public Move(Player player, Cell currentCell) {
        this.player = player;
        this.currentCell = currentCell;
    }
}
