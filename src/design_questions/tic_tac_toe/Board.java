package design_questions.tic_tac_toe;

import java.util.Arrays;

public class Board {

    private final int nRows;
    private final int nCols;
    private final Mark[][] grid;

    public Board(int nRows, int nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
        this.grid = new Mark[nRows][nCols];
        reset();
    }

    public void reset(){
        for(Mark[] marks : grid){
            Arrays.fill(marks, Mark.EMPTY);
        }
    }

    public void display() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                sb.append(grid[i][j] == Mark.EMPTY ? " " : grid[i][j].name());
                if (j < nCols - 1) {
                    sb.append(" | ");
                }
            }
            sb.append("\n");
            if (i < nRows - 1) {
                sb.append("-".repeat(4 * nCols - 3));
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    public void addMark(int x, int y, Mark mark){
        grid[x][y] = mark;
    }

    public void removeMark(Move move){
        grid[move.getX()][move.getY()] = Mark.EMPTY;
    }

    public boolean isCellEmpty(int x, int y){
        return this.grid[x][y].equals(Mark.EMPTY);
    }

    public Mark[][] getGrid() {
        return grid;
    }
}
