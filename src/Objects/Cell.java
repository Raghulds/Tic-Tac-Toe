package Objects;

import Enums.CellStatusEnum;

public class Cell {
    public int row;
    public int col;
    public char symbol;
    public Player player;
    public CellStatusEnum status;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.status = CellStatusEnum.FREE;
        this.symbol = '-';
    }

    public char getSymbol() {
        return symbol;
    }

    public Cell setSymbol(char symbol) {
        this.symbol = symbol;
        return this;
    }

    public Cell setStatus(CellStatusEnum status) {
        this.status = status;
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public Cell setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellStatusEnum getStatus() {
        return status;
    }
}
