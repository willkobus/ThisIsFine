package game;

import game.rooms.BreakerRoom;
import game.rooms.Lobby;
import game.rooms.Room;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Set;

abstract class RoomFactory {
    private static JSONObject rooms;
    private static Set<String> keys;
    private static Lobby lobby;
    private static BreakerRoom breakerRoom;


    protected RoomFactory() throws Exception {
    }

    public static void initializeRoom() throws Exception {
        try {
            rooms = JSONRead.readJSON();
            keys = rooms.keySet();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(keys);
        for (String name : keys) {
            JSONObject currentRoom = (JSONObject) rooms.get(name);
            String room = (String) currentRoom.get("name");
            switch (room){
                case "lobby":
                    lobby = new Lobby(name,(String) currentRoom.get("description"), (String) currentRoom.get("detailed"),
                            (ArrayList<String>) currentRoom.get("items"), (ArrayList<String>) currentRoom.get("exits"));
                    break;
                case "breaker room":
                    breakerRoom = new BreakerRoom(name,(String) currentRoom.get("description"), (String) currentRoom.get("detailed"),
                            (ArrayList<String>) currentRoom.get("items"), (ArrayList<String>) currentRoom.get("exits"));
                    break;
            }
//            if (currentRoom.get("name").equals("lobby")){
//                lobby = new Lobby(name,(ArrayList<String>) currentRoom.get("items"));
//            }
//            else if (currentRoom.get("name").equals("breaker room")){
//                breakerRoom = new BreakerRoom(name,(ArrayList<String>) currentRoom.get("items"));
//           }

        }
    }

    public static void displayRoomInfo(Player player){
        System.out.printf("Items in %s: ", player.getCurrentRoom());
        String room = player.getCurrentRoom();
        switch (room){
            case "lobby":
                System.out.println(lobby.getRoomItems());
                break;
            case "breaker room":
                System.out.println(breakerRoom.getRoomItems());
                break;
        }
//        if (player.getCurrentRoom().equals("lobby")){
//            System.out.println(lobby.getRoomItems());
//        }
//        else if (player.getCurrentRoom().equals("breaker room")){
//            System.out.println(breakerRoom.getRoomItems());
//        }
    }

    public static void deleteFromRoom(Player player, String item){
        String room = player.getCurrentRoom();
        switch (room){
            case "lobby":
                lobby.deleteRoomItem(item);
                break;
            case "breaker room":
                breakerRoom.deleteRoomItem(item);
                break;
        }

    }


    public static Room getRoom(Player player){
        String currentRoom = player.getCurrentRoom();
        Room room = null;
        switch (currentRoom){
            case "lobby":
                room = getLobby();
                break;
            case "breaker room":
                room = getBreakerRoom();
                break;
        }
        return room;
    }

    public static Lobby getLobby() {
        return lobby;
    }

    public static BreakerRoom getBreakerRoom() {
        return breakerRoom;
    }
}