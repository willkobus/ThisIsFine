package game;

import com.apps.util.Console;
import game.rooms.Room;

import java.util.Scanner;

import static game.AsciiArts.asciiArtLose;


class ActionParser {
    private String[] moveString;
    private boolean validInput = false;

    private final Scanner scanner = new Scanner(System.in);
    private final TextParser parser = new TextParser();
    
    public boolean playerMove(Player player) {
        boolean quit = false;

        while (!quit && !player.checkWin()) {
            while (!validInput) {
                Room room = RoomUtility.getRoom(player);
                System.out.println("Enter your action (example: move east, take <item name>) > ");
                String action = scanner.nextLine();
                moveString = parser.parseInput(action);

                Console.clear();

                switch (moveString[0]) {
                    case "move":
                        validInput = Moves.move(player, moveString[1].toLowerCase());
                        break;
                    case "take":
                        validInput = Moves.take(player, moveString[1]);
                        break;
                    case "use":
                        validInput = Moves.use(player, moveString[1]);
                        break;
                    case "pull":
                        validInput = Moves.puzzle(room.getPuzzle(), moveString);
                        if (room.getPuzzle() != null){
                        System.out.println(room.getPuzzle().toString());
                        }

                        if (validInput) {
                            player.setMoveCount(player.getMoveCount() + 1);
                            if (room.getPuzzle().isSolved() && room.getRoomItems().contains("key")) {
                                player.addToInventory("key");
                                RoomUtility.getRoom(player).deleteRoomItem("key");

                                System.out.println("You solved the puzzle! You grab the key.");
                                RoomUtility.displayGameInfo(player);
                            }
                        }
                        break;
                    case "look":
                        validInput = Moves.look(player);
                        break;
                    case "restart":
                        validInput = Moves.restart();
                        break;
                    case "quit":
                        quit = true;
                        validInput = true;
                        asciiArtLose();
                        break;
                    case "help":
                        JSONRead.gameText("help");
                        break;
                    default:
                        System.out.println("Sorry that is not a valid input\nIf you need help just type help!");
                }
            }
            if (!quit) validInput = false;
        }

        return quit;
    }

}