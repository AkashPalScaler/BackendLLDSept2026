package com.scaler.TicTacToe.Models;

import com.scaler.TicTacToe.Exceptions.UniquePlayerException;
import com.scaler.TicTacToe.Strategies.WinningStrategy;
import com.scaler.TicTacToe.Validations.UniquePlayersValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Game {
    private Board board;
    private List<Player> players;
    private GameStatus status;
    private Player winner;
    private Integer nextPlayerIndex;
//    private List<WinningStrategyType> winningStrategyTypes; // Whenever required call factory
    private List<WinningStrategy> winningStrategies;
    private List<Move> moves;

    private Game(GameBuilder gameBuilder) {
        this.board = new Board(gameBuilder.dimension);
        this.players = gameBuilder.players;
        this.winningStrategies = new ArrayList<>();
        for(WinningStrategyType type : gameBuilder.winningStrategyTypes){
            // Call the simple factory with the type and add it in the
            // winningStrategy list
        }
        this.status = GameStatus.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerIndex = 0;
        this.moves = new ArrayList<>();
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public static class GameBuilder {
        private Integer dimension;
        private List<Player> players;
        private List<WinningStrategyType> winningStrategyTypes;

        public GameBuilder setDimension(Integer dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setWinningStrategyTypes(List<WinningStrategyType> winningStrategyTypes) {
            this.winningStrategyTypes = winningStrategyTypes;
            return this;
        }

        public Game build(){
            // Validations : HW - Rest of the validations
            UniquePlayersValidation.checkUniqueSymbol(this.players);
            return new Game(this);
        }
    }
}
// Game.getBuilder().setDimension().setPlayers()...build();