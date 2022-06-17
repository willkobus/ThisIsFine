package game;

public class Moves {
    private final static int REQUIRED_KEYS = 4;
    private final static String EXIT_ROOM = "lobby";

    public static boolean move(Player player, String direction) {
        int moveCount = player.getMoveCount();
        Room room = RoomUtility.getRoom(player);
        String destinationRoom;

        if(!direction.equals("north") && !direction.equals("west") && !direction.equals("south") && !direction.equals("east")){
            System.out.printf("\"%s\" is not a valid direction", direction.toUpperCase());
            RoomUtility.displayGameInfo(player);
            return false;
        }

        if (room.getDirection(direction) != null) {
            destinationRoom = room.getDirection(direction);
            player.setCurrentRoom(destinationRoom);

            moveCount ++;
            player.setMoveCount(moveCount);

            RoomUtility.displayGameInfo(player);

            return true;
        } else {
            System.out.println("No exit in that direction");
            RoomUtility.displayGameInfo(player);
            return false;
        }
    }

    public static boolean use(Player player, String item) {
        if (player.getInventory().contains(item)) {
            if (item.equals("coffee")){
                System.out.println("You drink the " + item + ". It was fine. Just...fine");
                return true;
            }
            if(item.equals("cookie")){
                System.out.println("You eat the " + item + ". Definitely store bought. At least it was chocolate chip.");
                return true;
            }

            if (item.equals("key") || item.equals("keys")) {
                int count = (int) player.getInventory().stream().filter(i -> i.equals("key")).count();

                if (count == REQUIRED_KEYS && player.getCurrentRoom().equalsIgnoreCase(EXIT_ROOM)) {
                    player.wins();
                    return true;
                }
            }
            System.out.println("You have used " + item + ". It does not appear to have done anything");
            player.removeFromInventory(item);
        }
        else {
            System.out.println("You do not have that item.");
        }

        RoomUtility.displayGameInfo(player);
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

    public static boolean take(Player player, String item) {
        Room room = RoomUtility.getRoom(player);
        if (room.getRoomItems().size() > 0 && room.getRoomItems().contains(item)) {
            if(room.getPuzzle() != null && room.getPuzzle().isSolved()
                    && item.equalsIgnoreCase("key")){
                System.out.println("The key cannot be picked up until the puzzle is solved");
            }
            else {
                System.out.println("You have picked up " + item);
                player.addToInventory(item);
                room.deleteRoomItem(item);
            }
        }
        else {
            System.out.printf("\"%s\" cannot be picked up. Either room is empty or item is not in room\n", item);
        }
        RoomUtility.displayGameInfo(player);
        return true;
    }

    public static boolean restart() {
        System.out.println();
        System.out.println("New Game started. Move counter and inventory reset, and you have been returned to the starting area\n");
        Game game = new Game();
        game.execute();
        return true;
    }

    public static boolean look(Player player) {
        Room room = RoomUtility.getRoom(player);
        System.out.println();
        System.out.println(room.getDetailedDescription());
        if (room.getPuzzle() != null) {
            System.out.println(RoomUtility.getRoom(player).getPuzzle().description());
            System.out.println(RoomUtility.getRoom(player).getPuzzle().toString());
        }
        System.out.println();

        RoomUtility.displayGameInfo(player);

        return true;
    }

    public static boolean drop(Player player, String item){
        Room room = RoomUtility.getRoom(player);
        if(!player.getInventory().contains(item)){
            System.out.println(item.toUpperCase() + " cannot be dropped. It is not in your inventory");
            RoomUtility.displayGameInfo(player);
            return false;
        }
        player.removeFromInventory(item);
        room.addRoomItem(item);
        RoomUtility.displayGameInfo(player);
        return true;
    }
}