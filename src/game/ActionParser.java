package game;

import java.util.Scanner;

class ActionParser {
    private String[] moveString;
    private String moveChoice;
    private boolean validInput = false;

    private Scanner scanner = new Scanner(System.in);
    private TextParser parser = new TextParser();
    private Moves moveExecution = new Moves();


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
                        validInput = moveExecution.move(player, moveString[1].toLowerCase());
                        break;
                    case "take":
                        validInput = moveExecution.take(moveString[1]);
                        break;
                    case "use":
                        validInput = moveExecution.use(moveString[1]);
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

    public static void main(String[] args) throws Exception{
        ActionParser moveSelector = new ActionParser();
        Player player = new Player();
        moveSelector.playerMove(player);
    }
}