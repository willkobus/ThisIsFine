package game;

import java.util.ArrayList;

class Player {
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
}