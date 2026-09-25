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

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }
}
