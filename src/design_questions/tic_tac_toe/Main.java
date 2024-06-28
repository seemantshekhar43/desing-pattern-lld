package design_questions.tic_tac_toe;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Rohit", Mark.X);
        Player player2 = new Player("Virat", Mark.O);

        Game game = new Game(List.of(new Player[]{player1, player2}), 3, 3);
        game.play();
    }
}
