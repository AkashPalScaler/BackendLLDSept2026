package com.scaler.TicTacToe.Exceptions;

public class UniquePlayerException extends RuntimeException{
    public UniquePlayerException(String message){
        super(message);
    }
}
