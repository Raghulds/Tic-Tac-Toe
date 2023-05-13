package Objects;

import Enums.PlayerTypeEnum;

import java.util.Scanner;

public class Player {
    public String name;
    public char symbol;
    public PlayerTypeEnum type = PlayerTypeEnum.HUMAN;
    public int index;
    public Player(String name, char symbol, PlayerTypeEnum type, int index) {
        this.name = name;
        this.symbol = symbol;
        this.type = type;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public PlayerTypeEnum getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public Move decideNextMove() {
        Scanner in = new Scanner(System.in);
        System.out.println("To which row you want to move?");
        int row = in.nextInt();
        System.out.println("To which column you want to move?");
        int col = in.nextInt();

        return new Move(this, new Cell(row, col));
    }
}
