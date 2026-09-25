package com.scaler.TicTacToe.Controllers;

import com.scaler.TicTacToe.Models.Game;
import com.scaler.TicTacToe.Models.GameStatus;
import com.scaler.TicTacToe.Models.Player;
import com.scaler.TicTacToe.Models.WinningStrategyType;

import java.util.ArrayList;
import java.util.List;
// API - /subdomain/api/v1/startgame - gameID
// API - /subdomain/api/v1/gamedetails(gameId) -
// API - /subdomain/api/v1/makemove(gameId) -

public class GameController {
    public Game startGame(Integer dimension, List<Player> players, List<WinningStrategyType> winningStrategyTypes) {
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategyTypes(winningStrategyTypes)
                .build();
    }

    public void displayBoard(Game game) {
        // We will fetch game object using gameId
        game.displayBoard();
    }

    public void makeMove(Game game){
        game.makeMove();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getStatus();
    }

    public String getGameWinner(Game game) {
        return game.getWinner().getName();
    }

    public void undo(Game game) {
        game.undo();
    }
}
