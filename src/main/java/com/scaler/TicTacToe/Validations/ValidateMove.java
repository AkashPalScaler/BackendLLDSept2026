package com.scaler.TicTacToe.Validations;

import com.scaler.TicTacToe.Models.Board;
import com.scaler.TicTacToe.Models.Cell;
import com.scaler.TicTacToe.Models.CellStatus;
import com.scaler.TicTacToe.Models.Move;

public class ValidateMove {
    public static void validate(Board board, Move move) {
        Cell cell = move.getCell();
        if(cell.getRow() < 0 || cell.getRow() >= board.getDimension() || cell.getColumn() < 0 || cell.getRow() >= board.getDimension()) {
            throw new IllegalArgumentException("Invalid move: out of bounds");
        }
        if(board.getGrid().get(cell.getRow()).get(cell.getColumn()).getStatus().equals(CellStatus.FILLED)) {
            throw new IllegalArgumentException("Invalid move: cell is already filled");
        }
    }
}
