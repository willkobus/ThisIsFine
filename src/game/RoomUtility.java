package game;

import java.util.ArrayList;
import java.util.Map;

abstract class RoomUtility {
    private static final Map<String, Room> roomMap = RoomFactory.getRoomMap();

    public static void displayGameInfo(Player player) {
        Room currentRoom = roomMap.get(player.getCurrentRoom());
        System.out.println("Move total: " + player.getMoveCount());
        System.out.println("Your inventory: ");
        printArrayListFields(player.getInventory());
        System.out.println("You are in the: " + player.getCurrentRoom());
        System.out.println(currentRoom.getDescription());
        System.out.println("Items in this room:");
        printArrayListFields(currentRoom.getRoomItems());
        System.out.println("Ways out of here:");
        printArrayListFields(currentRoom.getExits());
    }

    public static Room getRoom(Player player) {
        Room room;
        room = roomMap.get(player.getCurrentRoom());
        return room;
    }

    private static void printArrayListFields(ArrayList<String> arrayList){
        if(arrayList.size() > 0) {
            for (String entry : arrayList) {
                if (entry.equals("key")){
                    System.out.println("\t" + ColorEnums.BLUE_FONT + entry.toUpperCase() + ColorEnums.RESET_TEXT);
                }
                else {
                    System.out.println("\t" + ColorEnums.GREEN_FONT + entry + ColorEnums.RESET_TEXT);
                }
            }
        }else{
            System.out.println("\t" + ColorEnums.RED_FONT + "EMPTY" + ColorEnums.RESET_TEXT);
        }
        System.out.println();
    }

}