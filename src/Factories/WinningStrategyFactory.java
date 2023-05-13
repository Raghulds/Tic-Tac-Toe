package Factories;

import strategies.GameWinning.GameWinningStrategy;
import strategies.GameWinning.OrderOneGameWinningStrategy;

public class WinningStrategyFactory {

    public static GameWinningStrategy getStrategyForGameWinning(int dimension) {
        return new OrderOneGameWinningStrategy(dimension);
    }
}
