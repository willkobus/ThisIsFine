package game.actions;

import game.JSONRead;
import game.Player;
import org.json.simple.JSONObject;

public class Move {
    static JSONRead jsonReader = new JSONRead();

    public static boolean move(Player player, String direction) throws Exception {
        int moveCount = player.getMoveCount();
        JSONObject room = jsonReader.readJSON();
        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());

        String destRoom;

        if (currentRoom.containsKey(direction)) {
            destRoom = (String) currentRoom.get(direction);
            player.setCurrentRoom(destRoom);

            moveCount ++;
            player.setMoveCount(moveCount);
            player.playerInfo(player);

            return true;
        } else {
            System.out.println("No exit in that direction");
            player.playerInfo(player);
            return false;
        }
    }
}