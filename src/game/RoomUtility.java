package game;

import java.util.Map;

abstract class RoomUtility {
    private static final Map<String, Room> roomMap = RoomFactory.getRoomMap();

    public static void displayGameInfo(Player player) {
        Room currentRoom = roomMap.get(player.getCurrentRoom());
        System.out.println("Move total: " + player.getMoveCount());
        System.out.println("Your inventory: " + player.getInventory());
        System.out.println("You are in the: " + player.getCurrentRoom());
        System.out.println(currentRoom.getDescription());
        System.out.printf("Items in %s: %s\n", currentRoom.getName(), currentRoom.getRoomItems());
        System.out.printf("Ways out of %s: %s\n", currentRoom.getName(), currentRoom.getExits());
    }

    public static Room getRoom(Player player) {
        Room room;
        room = roomMap.get(player.getCurrentRoom());
        return room;
    }

}