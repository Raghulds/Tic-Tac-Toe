package Objects;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public List<List<Cell>> cells;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    Board(int size) {
        this.setSize(size);
        cells = new ArrayList<>();
        for (int i=0;i<size;i++) {
            cells.add(new ArrayList<Cell>());
            for(int j=0;j<size;j++) {
                cells.get(i).add(new Cell(i, j));
            }
        }
    }

    public Board getBoard() {
        return this;
    }
}
