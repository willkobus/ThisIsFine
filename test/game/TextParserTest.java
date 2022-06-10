package game;


import org.junit.Before;

import static org.junit.Assert.*;

public class TextParserTest {

    TextParser parser;

    @Before
    public void setUp() {
        parser = new TextParser();
    }

    @org.junit.Test
    public void parseInput_array_should_contain_move_when_input_contains_move() {
        String input = "move east";
        String[] parsedString = parser.parseInput(input);
        assertEquals("move", parsedString[0]);
    }

    @org.junit.Test
    public void parseInput_array_should_contain_take_when_input_contains_take() {
        String input = "take east";
        String[] parsedString = parser.parseInput(input);
        assertEquals("take", parsedString[0]);
    }

    @org.junit.Test
    public void parseInput_array_should_contain_use_when_input_contains_use() {
        String input = "use east";
        String[] parsedString = parser.parseInput(input);
        assertEquals("use", parsedString[0]);
    }
}