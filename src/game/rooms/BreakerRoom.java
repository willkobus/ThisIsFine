package game.rooms;

import java.util.ArrayList;

public class BreakerRoom extends Room{
    ArrayList<String> roomItems;
    ArrayList<String> exits;
    public BreakerRoom(String name, String description, String detailed, ArrayList<String> items, ArrayList<String> exits) throws Exception{
        this.name = name;
        this.description = description;
        this.detailedDescription = detailed;
        roomItems = items;
        this.exits = exits;
        this.south = "lobby";
        this.north = null;
        this.west = null;
        this.east = null;
    }

    public ArrayList<String> getRoomItems(){
        return roomItems;
    }

    public void deleteRoomItem(String item){
        int removeIndex = roomItems.indexOf(item);
        roomItems.remove(removeIndex);

    }
}
