package com.scaler.TicTacToe.Strategies;

import com.scaler.TicTacToe.Models.Board;
import com.scaler.TicTacToe.Models.Move;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }

    @Override
    public void undoCountMapUpdate(Move move) {

    }
}
// Homework:
// If(i == j) : update diagonalCountMap[0]
// If(i+j == N-1) : update diagonalCountMap[1]