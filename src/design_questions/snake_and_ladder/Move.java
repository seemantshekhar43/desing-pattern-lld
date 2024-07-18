package design_questions.snake_and_ladder;

public class Move {
    private final int currPosition;
    private final int nextPosition;
    private final int diceValue;
    private final Player player;

    public Move(int currPosition, int nextPosition, int diceValue, Player player) {
        this.currPosition = currPosition;
        this.nextPosition = nextPosition;
        this.diceValue = diceValue;
        this.player = player;
    }

    public int getCurrPosition() {
        return currPosition;
    }

    public int getNextPosition() {
        return nextPosition;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public Player getPlayer() {
        return player;
    }
}
