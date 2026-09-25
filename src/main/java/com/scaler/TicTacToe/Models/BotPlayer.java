package com.scaler.TicTacToe.Models;

import com.scaler.TicTacToe.Factories.BotPlayerStrategyFactory;
import com.scaler.TicTacToe.Strategies.BotPlayerStrategy;

public class BotPlayer extends Player {
    private BotDifficultyLevel difficultyLevel;

    public BotPlayer(String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(name, symbol);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println(this.getName() + " is planning it's move...");
        BotPlayerStrategy playerStrategy = BotPlayerStrategyFactory.getStrategy(this.difficultyLevel);
        Move move = playerStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
// Minimax algorithm