package game;

import static game.ColorEnums.*;
import static game.ColorEnums.RESET_TEXT;

class FiveSwitchPuzzle extends Puzzle {
    private final boolean[] switches = new boolean[5];
    private boolean solved = false;

    public FiveSwitchPuzzle() {
        switches[0] = true;
        for (int i = 1; i < 5; i++) {
            switches[i] = false;
        }
    }

    public boolean puzzleAction(int index) {
        switches[index] = !switches[index];
        if (index >= 3) {
            index -= 5;
            switches[index + 2] = !switches[index + 2];
            switches[index + 3] = !switches[index + 3];
        }
        else if (index == 2) {
            switches[index + 2] = !switches[index + 2];
            index -= 5;
            switches[index + 3] = !switches[index + 3];
        }
        else {
            switches[index + 2] = !switches[index + 2];
            switches[index + 3] = !switches[index + 3];
        }

        solved = checkSolved();
        return true;
    }

    @Override
    public boolean isSolved() {
        return solved;
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

    private String switchString(boolean b, int index) {
        if (b) {
            return GREEN_FONT + index + " " + RESET_TEXT;
        }
        else {
            return RED_FONT + index + " " + RESET_TEXT;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("  " + switchString(switches[0], 0) + "\n");

        str.append(switchString(switches[4], 4) + "  ");
        str.append(switchString(switches[1], 1) + "\n ");
        str.append(switchString(switches[3], 3));
        str.append(switchString(switches[2], 2));

        return str.toString();
    }
}