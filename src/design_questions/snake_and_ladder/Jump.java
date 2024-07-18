package design_questions.snake_and_ladder;

public class Jump {
    private final int start;
    private final int end;
    private final JumpType jumpType;

    public Jump(int start, int end, JumpType jumpType) {
        this.start = start;
        this.end = end;
        this.jumpType = jumpType;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public JumpType getJumpType() {
        return jumpType;
    }
}
