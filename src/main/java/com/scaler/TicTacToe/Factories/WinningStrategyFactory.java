package com.scaler.TicTacToe.Factories;

import com.scaler.TicTacToe.Models.Board;
import com.scaler.TicTacToe.Models.WinningStrategyType;
import com.scaler.TicTacToe.Strategies.ColWinningStrategy;
import com.scaler.TicTacToe.Strategies.DiagonalWinningStrategy;
import com.scaler.TicTacToe.Strategies.RowWinningStrategy;
import com.scaler.TicTacToe.Strategies.WinningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getStrategy(WinningStrategyType type){
        if(type.equals(WinningStrategyType.ROW)){
            return new RowWinningStrategy();
        }else if (type.equals(WinningStrategyType.COLUMN)){
            return new ColWinningStrategy();
        }else if(type.equals(WinningStrategyType.DIAGONAL)){
            return new DiagonalWinningStrategy();
        }else{
            throw new IllegalArgumentException("Invalid WinningStrategyType");
        }
    }
}
