package game.actions;

import game.JSONRead;
import game.Player;
import org.json.simple.JSONObject;

public class Look {
    static JSONRead jsonReader = new JSONRead();

    public static boolean look(Player player) throws Exception {
        JSONObject room = jsonReader.readJSON();
        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());
        System.out.println();
        System.out.println(currentRoom.get("detailed"));
        System.out.println();

        player.playerInfo(player);

        return true;
    }
}