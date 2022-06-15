package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwitchPuzzleTest {

    @Test
    public void eightSwitch_toggleSwitch() {
        EightSwitchPuzzle eightPuzzle = new EightSwitchPuzzle();

        eightPuzzle.puzzleAction(0);
        eightPuzzle.puzzleAction(2);
        eightPuzzle.puzzleAction(5);

        assertTrue(eightPuzzle.isSolved());
    }

    @Test
    public void eightSwitch_toString() {
        EightSwitchPuzzle eightPuzzle = new EightSwitchPuzzle();
        System.out.println(eightPuzzle);
    }

    @Test
    public void fiveSwitch_toggleSwitch() {
        FiveSwitchPuzzle fivePuzzle = new FiveSwitchPuzzle();

        fivePuzzle.puzzleAction(2);
        fivePuzzle.puzzleAction(3);

        assertTrue(fivePuzzle.isSolved());
    }

    @Test
    public void fiveSwitch_testToString() {
        FiveSwitchPuzzle fivePuzzle = new FiveSwitchPuzzle();
        System.out.println(fivePuzzle);
    }

    @Test
    public void fourSwitch_toggleSwitch() {
        FourSwitchPuzzle fourPuzzle = new FourSwitchPuzzle();

        fourPuzzle.puzzleAction(2);
        fourPuzzle.puzzleAction(2);

        fourPuzzle.puzzleAction(1);
        fourPuzzle.puzzleAction(0);

        assertTrue(fourPuzzle.isSolved());
    }

    @Test
    public void fourSwitch_toString() {
        FourSwitchPuzzle fourPuzzle = new FourSwitchPuzzle();
        System.out.println(fourPuzzle);
    }
}