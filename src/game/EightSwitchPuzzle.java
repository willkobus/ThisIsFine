package game;

import static game.ColorEnums.*;

class EightSwitchPuzzle extends Puzzle {
    private boolean[] switches = new boolean[8];
    private boolean solved = false;

    public EightSwitchPuzzle() {
        switches[0] = false;
        switches[1] = true;
        for (int i = 2; i < 8; i++) {
            switches[i] = false;
        }
    }

    public boolean puzzleAction(int index) {
        if (index < 0 || index > 7) {
            return false;
        }

        if (index == 0) {
            switches[7] = !switches[7];
        }
        else {
            switches[index - 1] = !switches[index - 1];
        }

        switches[index] = !switches[index];

        if (index == 7) {
            switches[0] = !switches[0];
        }
        else {
            switches[index + 1] = !switches[index + 1];
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

        for (int i = 0; i <= 2; i++) {
            str.append(switchString(switches[i]));
        }
        str.append("\n");
        str.append(switchString(switches[7]) + "  ");
        str.append(switchString(switches[3]) + "\n");
        for (int i = 6; i >= 4; i--) {
            str.append(switchString(switches[i]));
        }
        return str.toString();
    }
}