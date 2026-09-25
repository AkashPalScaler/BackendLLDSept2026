package com.scaler.TicTacToe.Models;

import com.scaler.TicTacToe.Validations.ValidateMove;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private String email;
    private Scanner scanner = new Scanner(System.in);
    public HumanPlayer(String name, Symbol symbol, String email) {
        super(name, symbol);
        this.email = email;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("It's " + this.getName() + "'s move!");
        System.out.println("Please enter the row:");
        Integer row  = scanner.nextInt();
        System.out.println("Please enter the column:");
        Integer col  = scanner.nextInt();
        Move move = new Move(this, new Cell(row, col));
        ValidateMove.validate(board, move);
        return move;
    }
}
