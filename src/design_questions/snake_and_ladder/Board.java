package design_questions.snake_and_ladder;

import java.util.Arrays;

public class Board {

    private final int nRows;
    private final int nCols;
    private final Cell[][] grid;

    public Board(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.grid = new Cell[nRows][nCols];
        reset();
    }

    public void reset(){
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                this.grid[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int position){
        int rowIndex = position / nCols;
        int colIndex = position  % nCols;
        return this.grid[rowIndex][colIndex];
    }

    public void addJump(int position, Jump jump){
        int rowIndex = position / nCols;
        int colIndex = position  % nCols;
        System.out.println(jump.getJumpType() + " inserted at: " + rowIndex + " , " + colIndex + " for position: " + position);
        this.grid[rowIndex][colIndex].setJump(jump);
    }
}
