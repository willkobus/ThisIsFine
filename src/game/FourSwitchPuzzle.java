package game;

import static game.ColorEnums.*;
import static game.ColorEnums.RESET_TEXT;

public class FourSwitchPuzzle extends Puzzle {
    private boolean[] switches = new boolean[4];
    private boolean solved = false;

    public FourSwitchPuzzle() {
        switches[0] = true;
        switches[1] = false;
        switches[2] = true;
        switches[3] = false;
    }

    public boolean puzzleAction(int index) {
        if (index == 0) {
            switches[0] = !switches[0];
        }
        else if (index == 1) {
            switches[0] = !switches[0];
            switches[1] = !switches[1];
            switches[3] = !switches[3];
        }
        else if (index == 2) {
            switches[0] = !switches[0];
            switches[1] = !switches[1];
            switches[2] = !switches[2];
            switches[3] = !switches[3];
        }
        else {
            switches[0] = !switches[0];
            switches[3] = !switches[3];
        }

        solved = checkSolved();
        return true;
    }

    private boolean checkSolved() {
        boolean isSolved = true;

        for (boolean b : switches) {
            if (!b) {
                isSolved = false;
            }
        }

        return isSolved;
    }

    private String switchString(boolean b) {
        if (b) {
            return GREEN_FONT +"X " + RESET_TEXT;
        }
        else {
            return RED_FONT + "O " + RESET_TEXT;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            str.append(switchString(switches[i]));
        }

        return str.toString();
    }
}