package com.scaler.TicTacToe;

import com.scaler.TicTacToe.Controllers.GameController;
import com.scaler.TicTacToe.Models.*;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        GameController gameController = new GameController();

        // UserController -> registerUser -> a actual user will be created in DB with a user ID
        List<Player> players = new ArrayList<>();
        players.add(new HumanPlayer("Akash", new Symbol('X'), "akash.pal@gmail.com"));
        players.add(new BotPlayer("Botty", new Symbol('O'), BotDifficultyLevel.EASY));

        // GameController.startGame(3, list.of(userid1, userid2))

        List<WinningStrategyType> winningStrategyTypes = new ArrayList<>();
        winningStrategyTypes.add(WinningStrategyType.ROW);
        winningStrategyTypes.add(WinningStrategyType.COLUMN);


        Game game = gameController.startGame(3, players, winningStrategyTypes);
        gameController.displayBoard(game);

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            gameController.makeMove(game);
            gameController.displayBoard(game);
        }
    }
}
// Before ORM - DB - seelct query - userInfoList[id, name, email, password]
// - new HumanPlayer(userInfoList[0], userInfoList[1],...)
// ORM - Object relation mapping - Player player = getUserById(userId);