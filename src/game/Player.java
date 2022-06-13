package game;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Player {
    private JSONRead jsonReader = new JSONRead();
    private String currentRoom;
    private ArrayList<String> inventory;
    private int moveCount;

    public Player(){
        currentRoom = "lobby";
        inventory = new ArrayList<>();
        moveCount = 0;

    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void addToInventory(String item){
        inventory.add(item);
    }

    public void playerInfo(Player player) throws Exception{
        JSONObject room = jsonReader.readJSON();
        JSONObject currentRoom = (JSONObject) room.get(player.getCurrentRoom());
        System.out.println("Move Total: " + player.getMoveCount());
        System.out.println("You are in the: " + player.getCurrentRoom() + ". " + currentRoom.get("description"));
        System.out.println("Your Inventory: " + player.getInventory());
        System.out.println("Items in room: " + currentRoom.get("items"));
        System.out.println(currentRoom.get("exits"));
    }
}