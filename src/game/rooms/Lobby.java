package game.rooms;


import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class Lobby extends Room{
    ArrayList<String> roomItems;
    ArrayList<String> exits;
    public Lobby(String name, String description, String detailed,ArrayList<String> items, ArrayList<String> exits) throws Exception{
        this.name = name;
        this.description = description;
        this.detailedDescription = detailed;
        roomItems = items;
        this.exits = exits;
        this.south = "exit";
        this.north = "breaker room";
        this.east = null;
        this.west = null;

    }

    public ArrayList<String> getRoomItems(){
        return roomItems;
    }

    public void deleteRoomItem(String item){
        int removeIndex = roomItems.indexOf(item);
        roomItems.remove(removeIndex);

    }

}