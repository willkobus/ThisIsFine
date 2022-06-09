package game;

import java.util.ArrayList;

class Player {
    private String currentRoom;
    private ArrayList<String> inventory = new ArrayList<>();

    public Player(){
        currentRoom = "lobby";
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

}