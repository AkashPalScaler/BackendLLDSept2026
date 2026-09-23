package com.scaler.TicTacToe.Models;

public class Cell {
    private Integer row;
    private Integer column;
    private Symbol symbol;
    private CellStatus status;
    public Cell(Integer row, Integer column) {
        this.row = row;
        this.column = column;
        this.status = CellStatus.EMPTY;
    }

    public void display() {
        if(this.status == CellStatus.EMPTY){
            System.out.print("|   |");
        }else{
            System.out.print("| ");
            this.symbol.displaySymbol();
            System.out.print(" |");
        }
    }
}
