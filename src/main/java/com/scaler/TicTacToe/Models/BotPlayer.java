package com.scaler.TicTacToe.Models;

public class BotPlayer extends Player {
    private BotDifficultyLevel difficultyLevel;

    public BotPlayer(String name, Symbol symbol, BotDifficultyLevel difficultyLevel) {
        super(name, symbol);
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println(this.getName() + " is planning it's move...");
        return null;
    }
}
// Break till 10:20PM