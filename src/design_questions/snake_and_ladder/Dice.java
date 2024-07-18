package design_questions.snake_and_ladder;

public class Dice {
    private final int start;
    private final int end;

    public Dice(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int roll(){
        return (int)(Math.random() * (end - start + 1)) + start;
    }
}
