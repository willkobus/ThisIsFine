package game;

import static game.readFromJSONSeparateLines.welcomeTextFromSeparateLines;

public class Game {

    Player player = new Player();
    ActionParser actionParser = new ActionParser();

    public Game() throws Exception {
    }

    public void execute() throws Exception {
        AsciiArts.asciiArtThisIsFine();
        welcome();
        welcomeTextFromSeparateLines("gameRules");
//        welcomeTextFromSeparateLines("help");

        playGame();
    }

    private boolean playGame() throws Exception {
        RoomFactory.initializeRoom();
        player.playerInfo();
        RoomFactory.displayRoomInfo(player);
        return !actionParser.playerMove(player);

    }

    // Welcome method
    public static void welcome() throws Exception {
        welcomeTextFromSeparateLines("welcome");
    }

}