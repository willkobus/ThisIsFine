package game;

class FiveSwitchPuzzle {
    private boolean[] switches = new boolean[5];
    private boolean solved = false;

    FiveSwitchPuzzle() {
        switches[0] = true;
        for (int i = 1; i < 5; i++) {
            switches[i] = false;
        }
    }

    void puzzleAction(int index) {
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

    public boolean isSolved() {
        return solved;
    }

    private String switchString(boolean b) {
        if (b) {
            return "X ";
        }
        else {
            return "O ";
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("  " + switchString(switches[0]) + "\n");

        str.append(switchString(switches[4]) + "  ");
        str.append(switchString(switches[1]) + "\n ");
        str.append(switchString(switches[3]));
        str.append(switchString(switches[2]));

        return str.toString();
    }
}