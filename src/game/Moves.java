package game;

import game.JSONRead;
import game.Player;
import game.Puzzle;
import org.json.simple.JSONObject;

public class Moves {
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
            player.playerInfo();

            return true;
        } else {
            System.out.println("No exit in that direction");
            player.playerInfo();
            return false;
        }
    }

    public static boolean item(Player player, String[] item) throws Exception {
        if (player.getInventory().contains(item[1])) {
            // TODO: add a remove item method to player
            // player.removeFromInventory(item[1]);
            System.out.println("You have used " + item[1]);
        }
        else {
            System.out.println("You do not have that item.");
        }

        player.playerInfo();
        return true;
    }

    public static boolean puzzle(Puzzle game, String[] item) {
        int puzzleChoice = -1;
        puzzleChoice = Integer.parseInt(item[1]);
        return game.puzzleAction(puzzleChoice);
    }

    public static boolean take(Player player, String item) throws Exception {
        System.out.println("You have picked up " + item);
        player.playerInfo();
        return true;
    }

    public static boolean restart(Player currentPlayer) throws Exception {
        System.out.println();
        System.out.println("New Game started. Move counter and inventory reset, and you have been returned to the starting area\n");
        currentPlayer = new Player();
        currentPlayer.playerInfo();
        return true;
    }

    public static boolean look(Player player) throws Exception {
        JSONObject room = jsonReader.readJSON();
        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());
        System.out.println();
        System.out.println(currentRoom.get("detailed"));
        System.out.println();

        player.playerInfo();

        return true;
    }
}