package design_questions.tic_tac_toe;

public class Move {
    private final int x;
    private final int y;
    private final Player player;
    private final Mark mark;

    public Move(int x, int y, Player player, Mark mark) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.mark = mark;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player getPlayer() {
        return player;
    }

    public Mark getMark() {
        return mark;
    }
}
