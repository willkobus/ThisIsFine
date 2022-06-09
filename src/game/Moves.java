package game;

import org.json.simple.JSONObject;

class Moves {
    JSONRead jsonReader = new JSONRead();

    public boolean move(Player player, String direction) throws Exception {
        int moveCount = player.getMoveCount();
        JSONObject room = jsonReader.readJSON();
        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());

        System.out.println(currentRoom.get("name"));
        String destRoom;

        if (currentRoom.containsKey(direction)) {
            destRoom = (String) currentRoom.get(direction);
            player.setCurrentRoom(destRoom);

            moveCount ++;
            player.setMoveCount(moveCount);
            roomInfo(player);

            return true;
        } else {
            System.out.println("No exit in that direction");
            return false;
        }
    }

    public boolean take(String item){
        System.out.println("You have picked up " + item);
        return true;
    }

    public boolean use(String item){
        System.out.println("You have used " + item);
        return true;
    }

    public boolean look(Player player) throws Exception{
        JSONObject room = jsonReader.readJSON();
        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());
        System.out.println();
        System.out.println(currentRoom.get("detailed"));
        System.out.println();

        roomInfo(player);
        return true;
    }

    private void roomInfo(Player player) throws Exception{
        JSONObject room = jsonReader.readJSON();
        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());
        System.out.println("Move Total: " + player.getMoveCount());
        System.out.println("You are in the: " + player.getCurrentRoom() + ". " + currentRoom.get("description"));
        System.out.println("Items in room: " + currentRoom.get("items"));
        System.out.println(currentRoom.get("exits"));
    }

    public boolean restart(Player currentPlayer) throws Exception{
        currentPlayer = new Player();
        roomInfo(currentPlayer);
        return true;
    }
}