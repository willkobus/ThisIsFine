package game;

import org.junit.Before;
import org.junit.Test;

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
        puzzle.puzzleAction(6);
        System.out.println(puzzle.toString());
        puzzle.puzzleAction(5);
        System.out.println(puzzle.toString());
        puzzle.puzzleAction(4);
        System.out.println(puzzle.toString());
        puzzle.puzzleAction(1);
        System.out.println(puzzle.toString());
    }

    @Test
    public void checkSolved_shouldReturnFalse() {
        puzzle.puzzleAction(6);

        assertFalse(puzzle.isSolved());
    }

    @Test
    public void checkSolved_shouldReturnTrue() {
        System.out.println(puzzle.toString());
        puzzle.puzzleAction(6);
        System.out.println(puzzle.toString());
        puzzle.puzzleAction(6);
        System.out.println(puzzle.toString());

        assertTrue(puzzle.isSolved());
    }

    @Test
    public void move_outOfBoundsChoice_shouldReturnFalse() {
        assertFalse(puzzle.puzzleAction(9));
    }

    @Test
    public void move_nonAdjacentChoice_shouldReturnFalse() {
        assertFalse(puzzle.puzzleAction(2));
    }

    @Test
    public void shuffle() {
        puzzle = new SlidePuzzle(5);
        System.out.println(puzzle.toString());
    }

    @Test
    public void testToString() {
        System.out.println(puzzle.grid);
        System.out.println(puzzle.toString());
    }
}