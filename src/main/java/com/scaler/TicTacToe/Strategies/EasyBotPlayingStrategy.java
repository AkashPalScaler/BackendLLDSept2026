package com.scaler.TicTacToe.Strategies;

import com.scaler.TicTacToe.Models.Board;
import com.scaler.TicTacToe.Models.Cell;
import com.scaler.TicTacToe.Models.CellStatus;
import com.scaler.TicTacToe.Models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayerStrategy {
    // Also can return just cell
    @Override
    public Move makeMove(Board board) {
        // scan through the board and return the next empty move
        for(List<Cell> row : board.getGrid()){
            for(Cell cell : row){
                if(cell.getStatus().equals(CellStatus.EMPTY)){
                    return new Move(null, new Cell(cell.getRow(), cell.getColumn()));
                }
            }
        }
        return null;
    }
}
