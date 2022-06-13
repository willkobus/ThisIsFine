package game;

abstract class Puzzle {
    private boolean solved = false;

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