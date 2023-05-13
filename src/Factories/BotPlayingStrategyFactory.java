package Factories;

import Enums.PlayerDifficultyEnum;
import strategies.BotPlaying.BotPlayingStrategy;
import strategies.BotPlaying.RandomPlayWinningStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getStrategyForDifficultyLevel(PlayerDifficultyEnum difficultyLevel) {
        return new RandomPlayWinningStrategy();
    }
}
