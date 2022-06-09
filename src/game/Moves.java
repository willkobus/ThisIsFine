package game;

import org.json.simple.JSONObject;

class Moves {

    public void move(Player player, String direction) throws Exception {
        JSONRead jsonReader = new JSONRead();
        JSONObject room = jsonReader.readJSON();
//        System.out.println("You have moved " + direction);
        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());
        System.out.println(currentRoom.get("name"));
        String destRoom;
        JSONObject newRoom;
        if (currentRoom.containsKey(direction)) {
            destRoom = (String) currentRoom.get(direction);
            player.setCurrentRoom(destRoom);

            System.out.println("You are now in the: " + player.getCurrentRoom());
            System.out.println(((JSONObject) room.get(player.getCurrentRoom())).get("description"));

            //System.out.println(room);
            //System.out.println(room.get("description"));
        } else {
            System.out.println("No exit in that direction");

        }
    }

    public void take(String item){
        System.out.println("You have picked up " + item);
    }

    public void use(String item){
        System.out.println("You have used " + item);
    }
}