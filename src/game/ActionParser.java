package game;

import game.actions.*;

import java.util.Scanner;

class ActionParser {
    private String[] moveString;
    private String moveChoice;
    private boolean validInput = false;

    private Scanner scanner = new Scanner(System.in);
    private TextParser parser = new TextParser();
    
    public boolean playerMove(Player player) throws Exception{
        boolean quit = false;

        while (!quit) {
            while (!validInput) {
                System.out.println("Enter your action (example: move east, take <item name>) > ");
                String action = scanner.nextLine();
                moveString = parser.parseInput(action);
                moveChoice = moveString[0].toLowerCase();
                switch (moveChoice) {
                    case "move":
                        validInput = Move.move(player, moveString[1].toLowerCase());
                        break;
                    case "take":
                        validInput = Take.take(player, moveString[1]);
                        break;
                    case "use":
                        validInput = Use.use(player, moveString[1]);
                        break;
                    case "look":
                        validInput = Look.look(player);
                        break;
                    case "restart":
                        validInput = Restart.restart(player);
                        break;
                    case "quit":
                        quit = true;
                        validInput = true;
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