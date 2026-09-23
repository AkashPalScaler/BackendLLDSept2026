package com.scaler.TicTacToe;

import com.scaler.TicTacToe.Models.Board;
import com.scaler.TicTacToe.Models.Game;
import com.scaler.TicTacToe.Models.WinningStrategyType;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Board board = new Board(4);
        board.displayBoard();

        Game game = Game.getBuilder()
                .setDimension(3)
                .setPlayers(new ArrayList<>())
                .setWinningStrategyTypes(List.of(WinningStrategyType.ROW, WinningStrategyType.COLUMN))
                .build();

    }
}
