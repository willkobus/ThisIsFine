package game;

import game.rooms.Room;

import java.util.Map;



public class Game {

    Player player = new Player();
    ActionParser actionParser = new ActionParser();


    public void execute() {
        welcome();

        playGame();

        if (player.checkWin()) {
            winScreen();
        }
    }

    private boolean playGame() {
        RoomFactory.initializeRoom();
        RoomUtility.displayGameInfo(player);
        return !actionParser.playerMove(player);
    }

    // Welcome method
    public static void welcome() {
        AsciiArts.asciiArtThisIsFine();
        JSONRead.gameText("welcome");
        JSONRead.gameText("gameRules");
    }

    public static void winScreen() {
        //welcomeTextFromSeparateLines("welcome");
        AsciiArts.asciiArtWin();
    }
}