package game;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SlidePuzzleTest {
    SlidePuzzle puzzle;

    @Before
    public void setUp() {
        puzzle = new SlidePuzzle();
    }

    @Test
    public void move_validChoices() {
        System.out.println(puzzle.toString());
        puzzle.move(6);
        System.out.println(puzzle.toString());
        puzzle.move(5);
        System.out.println(puzzle.toString());
        puzzle.move(4);
        System.out.println(puzzle.toString());
        puzzle.move(1);
        System.out.println(puzzle.toString());
    }

    @Test
    public void checkSolved_shouldReturnFalse() {
        puzzle.move(6);

        assertFalse(puzzle.isSolved());
    }

    @Test
    public void checkSolved_shouldReturnTrue() {
        System.out.println(puzzle.toString());
        puzzle.move(6);
        System.out.println(puzzle.toString());
        puzzle.move(6);
        System.out.println(puzzle.toString());

        assertTrue(puzzle.isSolved());
    }

    @Test
    public void move_outOfBoundsChoice_shouldReturnFalse() {
        assertFalse(puzzle.move(9));
    }

    @Test
    public void move_nonAdjacentChoice_shouldReturnFalse() {
        assertFalse(puzzle.move(2));
    }

    @Test
    public void testToString() {
        System.out.println(puzzle.grid);
        System.out.println(puzzle.toString());
    }
}