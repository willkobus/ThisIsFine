package game;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

class TextParser {
    public String[] parseInput(String input) {
        input = input.toLowerCase();
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(input.split(" ")));

        if ((inputList.get(0).equals("sound") || inputList.get(0).equals("music")) || inputList.size() > 2){
            inputList.set(0,inputList.get(0) + " " + inputList.get(1));
            inputList.remove(1);
        }


        JSONObject jsonObj = JSONRead.readJSON("gameText.json");
        JSONObject commandObj = (JSONObject) jsonObj.get("commands");
        Set<String> commandSet = commandObj.keySet();

        if (commandSet.contains(inputList.get(0))) {
            return inputList.toArray(new String[0]);
        }
        else {
            for (String command : commandSet) {
                ArrayList<String> commandList = (ArrayList<String>) commandObj.get(command);

                if (commandList.contains(inputList.get(0))) {
                    inputList.set(0, command);
                }
            }
        }


        inputList.trimToSize();
        return inputList.toArray(new String[0]);
    }
}