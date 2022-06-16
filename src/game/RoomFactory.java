package game;

import game.rooms.Room;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract class RoomFactory {
    private static JSONObject rooms;
    private static Set<String> keys;
    private static final Map<String, Room> roomMap = new HashMap<>();

    public static void initializeRoom() {
        rooms = JSONRead.readJSON("resources/rooms.json");
        keys = rooms.keySet();

        for (String name : keys) {
            JSONObject currentRoom = (JSONObject) rooms.get(name);
            String room = (String) currentRoom.get("name");

            Room roomObj = new Room(name,(String) currentRoom.get("description"), (String) currentRoom.get("detailed"),
                    (ArrayList<String>) currentRoom.get("items"), (ArrayList<String>) currentRoom.get("exits"));
            if (currentRoom.containsKey("east")) {
                roomObj.setEast((String) currentRoom.get("east"));
            }
            if (currentRoom.containsKey("north")) {
                roomObj.setNorth((String) currentRoom.get("north"));
            }
            if (currentRoom.containsKey("west")) {
                roomObj.setWest((String) currentRoom.get("west"));
            }
            if (currentRoom.containsKey("south")) {
                roomObj.setSouth((String) currentRoom.get("south"));
            }
            if (currentRoom.containsKey("puzzle")) {
                roomObj.setPuzzle(puzzleHelper((String) currentRoom.get("puzzle")));
            }
            roomMap.put(room,roomObj);
        }
    }
    private static Puzzle puzzleHelper(String puzzleType) {
        switch (puzzleType) {
            case "eight":
                return new EightSwitchPuzzle();
            case "five":
                return new FiveSwitchPuzzle();
            case "four":
                return new FourSwitchPuzzle();
            case "slide":
                return new SlidePuzzle();
            default:
                return null;
        }
    }

    public static Map<String, Room> getRoomMap() {
        return roomMap;
    }
}