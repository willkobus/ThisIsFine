package game;

import java.util.Arrays;

class TextParser {
    public String[] parseInput(String input){
        String[] parsedInput = input.split(" ");
        System.out.println(Arrays.toString(parsedInput));

        return parsedInput;

    }
}