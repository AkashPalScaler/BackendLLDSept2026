package com.scaler.TicTacToe.Models;

public class Symbol {
    private Character symchar;

    public Symbol(Character symchar) {
        this.symchar = symchar;
    }

    public Character getSymchar() {
        return symchar;
    }

    public void setSymchar(Character symchar) {
        this.symchar = symchar;
    }

    public void displaySymbol(){
        System.out.print(symchar);
    }
}
