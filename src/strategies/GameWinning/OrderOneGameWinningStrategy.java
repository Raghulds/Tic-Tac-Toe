package strategies.GameWinning;

import Objects.Board;
import Objects.Cell;
import Objects.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderOneGameWinningStrategy implements GameWinningStrategy {

    private Map<Character, Integer> topLeftSymbolCount = new HashMap();
    private Map<Character, Integer> topRightSymbolCount = new HashMap();
    private List<HashMap<Character, Integer>> rowSymbolCounts = new ArrayList();
    private List<HashMap<Character, Integer>> colSymbolCounts = new ArrayList();

    private boolean checkIfMoveWasOnLeftTopDiagonal(int row, int col) {
        return row == col;
    }
    private boolean checkIfMoveWasOnRightTopDiagonal(int row, int col, int dimension) {
        return row + col == dimension - 1;
    }
    public OrderOneGameWinningStrategy(int dimension) {
        for(int i=0;i<dimension;i++) {
            rowSymbolCounts.add(new HashMap<Character, Integer>());
            colSymbolCounts.add(new HashMap<Character, Integer>());
        }
    }
    @Override
    public boolean checkWinner(Board board, Player player, Cell movedTo) {
        int row = movedTo.getRow();
        int col = movedTo.getCol();
        char symbol = player.getSymbol();
        int dimension = board.getBoard().getSize();

        // Add occurrences of symbols in row view
        if(!rowSymbolCounts.get(row).containsKey(symbol)) {
            rowSymbolCounts.get(row).put(symbol, 0);
        }
        rowSymbolCounts.get(row).put(symbol, rowSymbolCounts.get(row).get(symbol) + 1);

        // Add occurrences of symbols in column view
        if(!colSymbolCounts.get(col).containsKey(symbol)) {
            colSymbolCounts.get(col).put(symbol, 0);
        }
        colSymbolCounts.get(col).put(symbol, colSymbolCounts.get(col).get(symbol) + 1);

        // Check equality in row & column
        if(rowSymbolCounts.get(row).get(symbol) == dimension || colSymbolCounts.get(col).get(symbol) == dimension) {
            return true;
        }

        // Add occurrences of symbols in Left top diagonal view
        if(checkIfMoveWasOnLeftTopDiagonal(row, col)){
            if(!topLeftSymbolCount.containsKey(symbol)){
                topLeftSymbolCount.put(symbol, 0);
            }

            topLeftSymbolCount.put(
                    symbol, topLeftSymbolCount.get(symbol) + 1
            );
        }

        // Add occurrences of symbols in Right top diagonal view
        if(checkIfMoveWasOnRightTopDiagonal(row, col, dimension)){
            if(!topRightSymbolCount.containsKey(symbol)){
                topRightSymbolCount.put(symbol, 0);
            }

            topRightSymbolCount.put(
                    symbol, topRightSymbolCount.get(symbol) + 1
            );
        }

        // Check equality in diagonals
        if(checkIfMoveWasOnLeftTopDiagonal(row, col) && (topLeftSymbolCount.get(symbol) == dimension)) {
            System.out.println(checkIfMoveWasOnLeftTopDiagonal(row, col) && (topLeftSymbolCount.get(symbol) == dimension));
            return true;
        }
        if(checkIfMoveWasOnRightTopDiagonal(row, col, dimension) && (topRightSymbolCount.get(symbol) == dimension)) {
            return true;
        }

        return false;
    }
}
