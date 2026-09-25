package com.scaler.TicTacToe.Strategies;

import com.scaler.TicTacToe.Models.Board;
import com.scaler.TicTacToe.Models.Cell;
import com.scaler.TicTacToe.Models.Move;
import com.scaler.TicTacToe.Models.Player;

import java.util.HashMap;

// For each row - 1 row map - {symbol : count}
// Row 1 -> { X -> 0, O -> 0}
// Row 2 -> { X -> 0, O -> 0}
// Row 3 -> { X -> 0, O -> 0}

// RowCount {2 -> {X -> 1} } // Player(X) made a move at (2,something)
public class RowWinningStrategy implements WinningStrategy {
    HashMap<Integer, HashMap<Character, Integer>> rowCountMap = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        // Update the rowCountMap
        Cell cell = move.getCell();
        Player player = move.getPlayer();
        Character symbol = player.getSymbol().getSymchar();

        Integer row = cell.getRow();

        rowCountMap.putIfAbsent(row, new HashMap<>());
        HashMap<Character, Integer> countMap = rowCountMap.get(row);

        countMap.putIfAbsent(symbol, 0);
        countMap.put(symbol, countMap.get(symbol) + 1);

        // Check if count reached board size
        if(countMap.get(symbol) == board.getDimension()){
            return true;
        }
        return false;
    }

    @Override
    public void undoCountMapUpdate(Move move) {

        Cell cell = move.getCell();
        Integer row = cell.getRow();
        Player player = move.getPlayer();
        Character symbol = player.getSymbol().getSymchar();

//        rowCountMap.putIfAbsent(row, new HashMap<>()); // redundant
        HashMap<Character, Integer> countMap = rowCountMap.get(row);
//        countMap.putIfAbsent(symbol, 0); // redundant
        countMap.put(symbol, countMap.get(symbol) - 1);
    }
}
