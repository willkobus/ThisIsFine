package game;

public abstract class Puzzle {
    private boolean solved;

    public boolean puzzleAction(int i) {
        return false;
    }

    public boolean isSolved() {
        return solved;
    }

    public String toString() {
        return solved + "";
    }
}