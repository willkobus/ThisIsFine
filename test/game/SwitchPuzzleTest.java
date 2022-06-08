package game;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwitchPuzzleTest {

    @Test
    public void eightSwitch_toggleSwitch() {
        EightSwitchPuzzle eightPuzzle = new EightSwitchPuzzle();

        eightPuzzle.toggleSwitch(0);
        eightPuzzle.toggleSwitch(2);
        eightPuzzle.toggleSwitch(5);

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

        fivePuzzle.toggleSwitch(2);
        fivePuzzle.toggleSwitch(3);

        assertTrue(fivePuzzle.isSolved());
    }

    @Test
    public void fiveSwitch_testToString() {
        FiveSwitchPuzzle fivePuzzle = new FiveSwitchPuzzle();
        System.out.println(fivePuzzle.toString());
    }

    @Test
    public void fourSwitch_toggleSwitch() {
        FourSwitchPuzzle fourPuzzle = new FourSwitchPuzzle();

        fourPuzzle.toggleSwitch(2);
        fourPuzzle.toggleSwitch(2);

        fourPuzzle.toggleSwitch(1);
        fourPuzzle.toggleSwitch(0);

        assertTrue(fourPuzzle.isSolved());
    }

    @Test
    public void fourSwitch_toString() {
        FourSwitchPuzzle fourPuzzle = new FourSwitchPuzzle();
        System.out.println(fourPuzzle.toString());
    }
}