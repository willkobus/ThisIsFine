package game;

import static game.ColorEnums.*;
import static game.ColorEnums.RESET_TEXT;

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

    public String description() {
        return CYAN_FONT + "\nPULL" + RESET_TEXT + " or " + CYAN_FONT + "PUSH" + RESET_TEXT  + " a switch [pull 1] to activate itself and others. " +
                "You will receive a key once all of the switches are " + GREEN_FONT + "turned on.\n" + RESET_TEXT;
    }

}