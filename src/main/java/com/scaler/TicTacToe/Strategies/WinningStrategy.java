package com.scaler.TicTacToe.Strategies;

import com.scaler.TicTacToe.Models.Board;
import com.scaler.TicTacToe.Models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
