package game;


import java.util.ArrayList;

public class Player {
    private static final int MOVE_MAX = 100;
    private String currentRoom;
    private ArrayList<String> inventory;
    private int moveCount;
    private boolean hasWon = false;
    private boolean hasLost = false;

    public Player() {
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

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
        if (moveCount > MOVE_MAX) {
            hasLost = true;
        }
    }

    public void addToInventory(String item){
        inventory.add(item);
    }

    public void removeFromInventory(String item){
        inventory.remove(item);
    }

    public void wins() {
        this.hasWon = true;
    }

    public boolean checkWin() {
        return hasWon;
    }

    public boolean checkLose() {
        return hasLost;
    }
}