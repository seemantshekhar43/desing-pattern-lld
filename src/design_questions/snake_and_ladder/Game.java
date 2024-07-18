package design_questions.snake_and_ladder;

import java.util.*;

public class Game {

    private final Board board;
    private final Dice dice;
    private final Queue<Player> players;
    private final int winningSpot;
    private Player winner;
    private final Stack<Move> moves;

    private Game(Board board, List<Player> players, Dice dice, int winningSpot) {
        this.board = board;
        this.dice = dice;
        this.players = new ArrayDeque<>(players);
        this.winningSpot = winningSpot;
        this.moves = new Stack<>();
        resetGame();
    }

    public static Game initialize(int nRows, int nCols, List<Player> players, int diceStart, int diceEnd, List<Jump> jumps){
        Board gameBoard = new Board(nRows, nCols);
        for(Jump jump: jumps){
            gameBoard.addJump(jump.getStart(), jump);
        }
        return new Game(gameBoard, players, new Dice(diceStart, diceEnd), nRows *nCols);
    }

    public void resetGame(){
        this.winner = null;
        this.moves.clear();
        this.players.forEach(player -> player.setCurrentPosition(0));
    }

    public Player play(){

        System.out.println("------------------Starting Snake and Ladder!--------------------");

        while (winner == null){
            Player currentPlayer = nextPlayer();
            System.out.println("It's " + currentPlayer.getUserName() + "'s turn. He's currently at: " + currentPlayer.getCurrentPosition());
            //Roll dice until it's a valid move
            int diceValue = this.dice.roll();
            System.out.println(currentPlayer.getUserName() + " has rolled the dice and value is: " + diceValue);
            while(currentPlayer.getCurrentPosition() + diceValue > this.winningSpot - 1){
                System.out.println("Invalid Move! Rolling dice again!");
                diceValue = this.dice.roll();
                System.out.println(currentPlayer.getUserName() + " has rolled the dice and value is: " + diceValue);
            }

            int nextPosition = currentPlayer.getCurrentPosition() + diceValue;
            //check if snake or ladder is present
            nextPosition = jumpIfPossible(nextPosition);

            //add it into moves
            Move move = new Move(currentPlayer.getCurrentPosition(), nextPosition, diceValue, currentPlayer);
            moves.add(move);

            //check if we got a winner
            currentPlayer.setCurrentPosition(nextPosition);
            System.out.println(currentPlayer.getUserName() + " has reached: " + currentPlayer.getCurrentPosition());
            if (currentPlayer.getCurrentPosition() == this.winningSpot - 1) {
                this.winner = currentPlayer;
                System.out.println("We got a winner!");
            }

        }
        return this.winner;
    }

    private Player nextPlayer(){
        Player nextPlayer = this.players.remove();
        players.add(nextPlayer);
        return nextPlayer;
    }

    private int jumpIfPossible(int position){
        Cell cell = board.getCell(position);
        if(cell.getJump() != null){
            if(cell.getJump().getJumpType().equals(JumpType.SNAKE)){
                System.out.println("OOPS!!! Caught by snake! ");
            }else{
                System.out.println("Yeyyy!!! Going uppppp!! ");
            }
            return cell.getJump().getEnd();
        }
        return position;
    }
}
