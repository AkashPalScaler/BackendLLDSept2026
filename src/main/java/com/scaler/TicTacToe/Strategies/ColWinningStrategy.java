package com.scaler.TicTacToe.Strategies;

import com.scaler.TicTacToe.Models.Board;
import com.scaler.TicTacToe.Models.Cell;
import com.scaler.TicTacToe.Models.Move;
import com.scaler.TicTacToe.Models.Player;

import java.util.HashMap;

public class ColWinningStrategy implements WinningStrategy {
    HashMap<Integer, HashMap<Character, Integer>> colCountMap = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        // Update the rowCountMap
        Cell cell = move.getCell();
        Player player = move.getPlayer();
        Character symbol = player.getSymbol().getSymchar();

        Integer col = cell.getColumn();

        colCountMap.putIfAbsent(col, new HashMap<>());
        HashMap<Character, Integer> countMap = colCountMap.get(col);

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
        Integer col = cell.getColumn();
        Player player = move.getPlayer();
        Character symbol = player.getSymbol().getSymchar();
//        rowCountMap.putIfAbsent(row, new HashMap<>()); // redundant
        HashMap<Character, Integer> countMap = colCountMap.get(col);
//        countMap.putIfAbsent(symbol, 0); // redundant
        countMap.put(symbol, countMap.get(symbol) - 1);
    }
}
