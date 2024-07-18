package design_questions.snake_and_ladder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player haskell = new Player("Haskell");
        Player lambda = new Player("lambda");
        Player monad = new Player("monad");

        List<Player> playerList = new ArrayList<>();
        playerList.add(haskell);
        playerList.add(lambda);
        playerList.add(monad);

        List<Jump> jumps = new ArrayList<>();
        //snakes
        jumps.add(new Jump(23, 4, JumpType.SNAKE));
        jumps.add(new Jump(76, 23, JumpType.SNAKE));
        jumps.add(new Jump(45, 28, JumpType.SNAKE));
        jumps.add(new Jump(97, 3, JumpType.SNAKE));
        jumps.add(new Jump(81, 40, JumpType.SNAKE));

        //ladders
        jumps.add(new Jump(7, 30, JumpType.LADDER));
        jumps.add(new Jump(18, 32, JumpType.LADDER));
        jumps.add(new Jump(37, 80, JumpType.LADDER));
        jumps.add(new Jump(62, 95, JumpType.LADDER));
        jumps.add(new Jump(44, 86, JumpType.LADDER));

        Game game = Game.initialize(10, 10, playerList, 1, 6, jumps);

        Player winner = game.play();

        System.out.println("Game Finished! Winner is: " + winner.getUserName());
    }
}
