package com.scaler.TicTacToe.Factories;

import com.scaler.TicTacToe.Models.BotDifficultyLevel;
import com.scaler.TicTacToe.Strategies.BotPlayerStrategy;
import com.scaler.TicTacToe.Strategies.EasyBotPlayingStrategy;

public class BotPlayerStrategyFactory {
    public static BotPlayerStrategy getStrategy(BotDifficultyLevel difficultyLevel) {
        if(difficultyLevel == BotDifficultyLevel.EASY){
            return new EasyBotPlayingStrategy();
        }else{
            throw new IllegalArgumentException("Invalid difficulty level");
        }
    }
}
