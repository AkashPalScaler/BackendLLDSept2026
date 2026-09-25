package com.scaler.TicTacToe.Strategies;

import com.scaler.TicTacToe.Models.Board;
import com.scaler.TicTacToe.Models.Move;

// Minimax -
// AI Minimax -
// Prompt - "I have this interface in a Java TicTacToe project:
//
//public interface BotPlayingStrategy {
//    Move makeMove(Board board);
//}
//
//Board has getDimension() and getBoard() (a List<List<Cell>>). Cell
//has getCellState() (EMPTY or FILLED), getRow(), getCol(), and
//getPlayer(). Move has a constructor Move(Player player, Cell cell).
//
//Implement HardBotPlayingStrategy using minimax: take a winning
//move immediately if one exists, block the opponent's winning move
//if they have one, and otherwise pick the best move assuming the
//opponent always plays optimally. Match the interface exactly —
//return a Move with player left as null, since the calling code
//sets the player afterward, the same convention used elsewhere in
//this codebase."

// Minimax algo visualiser - https://acad-backend-vizs.vercel.app/instructor-notes-machine-coding-4-code-tictactoe-2/minimax-tree-exploration-step-through-minimax-tree-builder/v2/
// Minimax algo (explosion problem) - https://acad-backend-vizs.vercel.app/instructor-notes-machine-coding-4-code-tictactoe-2/minimax-explosion-on-larger-boards/v2/

// Solution - depth-limiting
public class HardBotPlayingStrategy implements BotPlayerStrategy {

    @Override
    public Move makeMove(Board board) {
        return null;
    }
}
