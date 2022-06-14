package game;

import game.rooms.Room;
import org.json.simple.JSONObject;

public class Moves {
//    static JSONRead jsonReader = new JSONRead();

    public static boolean move(Player player, String direction) throws Exception {
        int moveCount = player.getMoveCount();
//        JSONObject room = JSONRead.readJSON();
//        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());
        Room room = RoomFactory.getRoom(player);

        String destRoom;

        if (room.getDirection(direction) != null) {
            destRoom = room.getDirection(direction);
            player.setCurrentRoom(destRoom);

            moveCount ++;
            player.setMoveCount(moveCount);
            player.playerInfo();
            RoomFactory.displayRoomInfo(player);

            return true;
        } else {
            System.out.println("No exit in that direction");
            player.playerInfo();
            RoomFactory.displayRoomInfo(player);
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
        if (game == null) {
            System.out.println("There is no puzzle in this room");
            return false;
        }
        int puzzleChoice = -1;

        // Assumed input is "pull #", will need error trapping in the future.
        if (item[1].matches("[0-9]")) {
            puzzleChoice = Integer.parseInt(item[1]);
            return game.puzzleAction(puzzleChoice);
        }
        else {
            return false;
        }

    }

    public static boolean take(Player player, String item) throws Exception {
        System.out.println("You have picked up " + item);
        player.addToInventory(item);
        RoomFactory.deleteFromRoom(player, item);
        player.playerInfo();
        RoomFactory.displayRoomInfo(player);
        return true;
    }

    public static boolean restart() throws Exception {
        System.out.println();
        System.out.println("New Game started. Move counter and inventory reset, and you have been returned to the starting area\n");
        Player currentPlayer = new Player();
        currentPlayer.playerInfo();
        RoomFactory.initializeRoom();
        return true;
    }

    public static boolean look(Player player) throws Exception {
        JSONObject room = JSONRead.readJSON("resources/rooms.json");
        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());
        System.out.println();
        System.out.println(currentRoom.get("detailed"));
        // TODO: IF there's a puzzle, print out the puzzle
        // System.out.println(RoomFactory.getRoom(player).getPuzzle().toString());
        System.out.println();

        player.playerInfo();

        return true;
    }
}