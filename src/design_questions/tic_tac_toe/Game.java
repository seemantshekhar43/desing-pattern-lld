package design_questions.tic_tac_toe;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Game {
    private final List<Player> players;
    private final int numRows;
    private final int numCols;
    private final Board board;
    private Player winner;
    private final Stack<Move> moves;

    private Player currentPlayer;
    private int currentPlayerIndex;
    private GameStatus gameStatus;

    public Game(List<Player> players, int numRows, int numCols) {
        this.players = players;
        this.numRows = numRows;
        this.numCols = numCols;
        this.board = new Board(numRows, numCols);
        this.moves = new Stack<>();
        resetGame();
    }

    public void resetGame() {
        this.board.reset();
        moves.clear();
        this.winner = null;
        this.currentPlayer = null;
        this.currentPlayerIndex = -1;
        this.gameStatus = GameStatus.NEW;
    }

    public boolean validateMove(Move move) {
        int x = move.getX();
        int y = move.getY();
        return x >= 0 && x < numRows && y >= 0 && y < numCols && this.board.isCellEmpty(x, y);
    }

    public void checkGameStatus(Move move) {
        boolean isWinner = false;

        int x = move.getX();
        int y = move.getY();
        Mark mark = move.getMark();
        Mark[][] grid = this.board.getGrid();

        boolean isSame = true;
        //check vertically
        for(int i = 0; i < numRows && !isWinner; i++){
            if(grid[i][y] != mark){
                isSame = false;
                break;
            }
        }
        isWinner = isSame;

        //check horizontally
        isSame = true;
        for(int i = 0; i < numCols && !isWinner; i++){
            if(grid[x][i] != mark){
                isSame = false;
                break;
            }
        }
        isWinner = isSame;

        //check diagonally
        if(x == y || numRows - x - 1 == y){
            System.out.println("came inside diagonal check");
            isSame = true;
            for(int i = 0; i < numCols && !isWinner; i++){
                if(grid[i][i] != mark){
                    isSame = false;
                    break;
                }
            }
            isWinner = isSame;

            isSame = true;
            for(int i = 0; i < numCols && !isWinner; i++){
                if(grid[i][numRows - i - 1] != mark){
                    isSame = false;
                    break;
                }
            }
            isWinner = isSame;
        }

        if(isWinner){
            this.winner = currentPlayer;
            this.gameStatus = GameStatus.WINNER;
            return;
        }

        //check draw
        for(int i = 0; i < numRows; i++){
            for (int j = 0; j < numCols; j++){
                if(grid[i][j]== Mark.EMPTY){
                    this.gameStatus = GameStatus.PLAYING;
                    return;
                }
            }
        }
        this.gameStatus = GameStatus.DRAW;
    }

    public Move inputMoveFromPlayer(Scanner scanner) {
        while (true) {
            System.out.print(currentPlayer.getName() + "'s[" + currentPlayer.getMark() + "] move. Enter cell coordinate(x, y) to place your mark:  ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Move move = new Move(x, y, currentPlayer, currentPlayer.getMark());
            if (validateMove(move)) {
                return move;
            } else {
                System.out.println("Invalid move. Please try again!");
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        this.gameStatus = GameStatus.PLAYING;
        while (gameStatus == GameStatus.PLAYING) {
            //set current player
            this.currentPlayerIndex = (this.currentPlayerIndex + 1) % players.size();
            this.currentPlayer = this.players.get(currentPlayerIndex);

            //Input a valid move from player
            final Move move = inputMoveFromPlayer(scanner);

            //play move
            this.board.addMark(move.getX(), move.getY(), move.getMark());

            //register move
            this.moves.push(move);

            //check game status
            checkGameStatus(move);

            // display board
            this.board.display();
        }

        switch (gameStatus) {
            case DRAW: {
                System.out.println("Game Drawn!!");
                break;
            }
            case WINNER: {
                System.out.println(winner.getName() + " won the game!!");
                break;
            }
            default:
        }

    }


}
