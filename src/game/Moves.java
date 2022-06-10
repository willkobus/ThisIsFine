package game;

import org.json.simple.JSONObject;

class Moves {
    JSONRead jsonReader = new JSONRead();

    public boolean move(Player player, String direction) throws Exception {
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

    public boolean take(Player player, String item) throws Exception{
        System.out.println("You have picked up " + item);
        player.playerInfo(player);
        return true;
    }

    public boolean use(Player player,String item) throws Exception{
        System.out.println("You have used " + item);
        player.playerInfo(player);
        return true;
    }

    public boolean look(Player player) throws Exception{
        JSONObject room = jsonReader.readJSON();
        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());
        System.out.println();
        System.out.println(currentRoom.get("detailed"));
        System.out.println();

        player.playerInfo(player);

        return true;
    }

    public boolean restart(Player currentPlayer) throws Exception{
        System.out.println();
        System.out.println("New Game started. Move counter and inventory reset, and you have been returned to the starting area\n");
        currentPlayer = new Player();
        currentPlayer.playerInfo(currentPlayer);
        return true;
    }
}