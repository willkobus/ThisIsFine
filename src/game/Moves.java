package game;

import game.rooms.Room;
import org.json.simple.JSONObject;

public class Moves {
    private final static int REQUIRED_KEYS = 1;
    private final static String EXIT_ROOM = "lobby";


    public static boolean move(Player player, String direction) throws Exception {
        int moveCount = player.getMoveCount();
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

    public static boolean use(Player player, String item) throws Exception {
        if (player.getInventory().contains(item)) {
            System.out.println("You have used " + item);

            if (item.equals("key") || item.equals("keys")) {
                int count = (int) player.getInventory().stream().filter(i -> i.equals("key")).count();

                if (count == REQUIRED_KEYS && player.getCurrentRoom().equalsIgnoreCase(EXIT_ROOM)) {
                    player.wins();
                    return true;
                }
            }
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
        Room room = RoomFactory.getRoom(player);
        if (room.getRoomItems().size() > 0 && room.getRoomItems().contains(item)) {
            if(room.getName().equals("breaker room") && item.equals("key")){
                System.out.println("The key cannot be picked up until the puzzle is solved");
            }
            else {
                System.out.println("You have picked up " + item);
                player.addToInventory(item);
                RoomFactory.deleteFromRoom(player, item);
            }
        }
        else {
            System.out.println(item + "cannot be picked up. Either room is empty or item is not in room");
        }
        player.playerInfo();
        RoomFactory.displayRoomInfo(player);
        return true;
    }

    public static boolean restart() throws Exception {
        System.out.println();
        System.out.println("New Game started. Move counter and inventory reset, and you have been returned to the starting area\n");
        Game game = new Game();
        game.execute();
        return true;
    }

    public static boolean look(Player player) throws Exception {
        Room room = RoomFactory.getRoom(player);
        System.out.println();
        System.out.println(room.getDetailedDescription());
        if (room.getPuzzle() != null) {
            System.out.println(RoomFactory.getRoom(player).getPuzzle().toString());
        }
        System.out.println();

        player.playerInfo();

        return true;
    }
}