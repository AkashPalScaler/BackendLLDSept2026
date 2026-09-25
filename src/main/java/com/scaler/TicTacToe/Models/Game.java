package com.scaler.TicTacToe.Models;

import com.scaler.TicTacToe.Exceptions.UniquePlayerException;
import com.scaler.TicTacToe.Factories.WinningStrategyFactory;
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

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    private Game(GameBuilder gameBuilder) {
        this.board = new Board(gameBuilder.dimension);
        this.players = gameBuilder.players;
        this.winningStrategies = new ArrayList<>();
        for(WinningStrategyType type : gameBuilder.winningStrategyTypes){
            //TODO: Call the simple factory with the type and add it in the
            // winningStrategy list
            winningStrategies.add(WinningStrategyFactory.getStrategy(type));
        }
        this.status = GameStatus.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerIndex = 0;
        this.moves = new ArrayList<>();
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public void displayBoard() {
        this.board.displayBoard();
    }

    public void makeMove() {
        // Identify and fetch the current player
        Player player = players.get(nextPlayerIndex);
        // Ask current player to make a move
        Move move = player.makeMove(this.board);
        // Update the board and the cells
        Cell cellFromMove = move.getCell(); // Just for row,col info

        this.board.getGrid().get(cellFromMove.getRow()).get(cellFromMove.getColumn()).setStatus(CellStatus.FILLED);
        this.board.getGrid().get(cellFromMove.getRow()).get(cellFromMove.getColumn()).setSymbol(move.getPlayer().getSymbol());

        // update the moves history
        this.moves.add(move);

        // check winner logic - update game status and winner accordingly
        for(WinningStrategy strategy : winningStrategies){
            if(strategy.checkWinner(this.board, move)){
                //update the board status and winner
                this.status = GameStatus.WON;
                this.winner = move.getPlayer();
            }
        }
        // check draw - update game status accordingly
        if(board.getDimension() * board.getDimension() == moves.size()){
            this.status = GameStatus.DRAW;
        }
        // increment the nextPLayerIndex
        nextPlayerIndex = (nextPlayerIndex + 1) % winningStrategies.size();
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