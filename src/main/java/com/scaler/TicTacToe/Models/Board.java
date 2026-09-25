package com.scaler.TicTacToe.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Board {
    private Integer dimension;
    private List<List<Cell>> grid;

    public Board(Integer dimension) {
        this.dimension = dimension;
        this.grid = new ArrayList<>();

        for(int i = 0; i < dimension; i++){
            List<Cell> row = new ArrayList<>();
            for(int j = 0; j < dimension; j++){
                row.add(new Cell(i, j));
            }
            this.grid.add(row);
        }
    }

    public void displayBoard(){
        for(List<Cell> row : this.grid){
            for(Cell cell : row){
                cell.display();
            }
            System.out.println();
        }
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }
}
