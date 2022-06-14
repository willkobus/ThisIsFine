package game.rooms;

import game.JSONRead;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Room {
    private String STARTING_ROOM = "lobby";


    JSONObject rooms = JSONRead.readJSON("resources/rooms.json");
    JSONObject currentRoom = (JSONObject) rooms.get(STARTING_ROOM);
    ArrayList<String> roomItems = (ArrayList<String>) currentRoom.get("items");
    String north;
    String south;
    String east;
    String west;

    public Room() throws Exception {

    }

    public ArrayList<String> getRoomItems() {
        return roomItems;
    }

    public void deleteRoomItem(String item) {
    }
////    JSONObject currentRoom = (JSONObject) rooms.get(STARTING_ROOM);
    String name = (String) currentRoom.get("name");
    String description = (String) currentRoom.get("description");
    String detailedDescription = (String) currentRoom.get("detailed");
    ArrayList<String> items = (ArrayList<String>) currentRoom.get("items");
    //String[] exits = (String[]) currentRoom.get("exits");

    public Room(String name, String description, String detailedDescription) throws Exception{
        this.name = name;
        this.description = description;
        this.detailedDescription = detailedDescription;
    }

    public String getDirection(String desiredDirection){
        String direction = "";
        switch (desiredDirection){
            case "north":
                direction = getNorth();
                break;
            case "west":
                direction = getWest();
                break;
            case "east":
                direction = getEast();
                break;
            case "south":
                direction = getSouth();
                break;
        }
        return direction;
    }

    public String getNorth() {
        return north;
    }

    public String getSouth() {
        return south;
    }

    public String getEast() {
        return east;
    }

    public String getWest() {
        return west;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }
}