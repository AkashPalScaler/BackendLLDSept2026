package com.scaler.TicTacToe.Strategies;

import com.scaler.TicTacToe.Models.Board;
import com.scaler.TicTacToe.Models.Move;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
