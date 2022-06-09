package game;

import java.util.Scanner;

class MoveSelection {
    private String[] moveString;
    private String moveChoice;
    private boolean validInput = false;

    Scanner scanner = new Scanner(System.in);
    TextParser parser = new TextParser();
    Moves moveExecution = new Moves();


    public void playerMove(Player player) throws Exception{

        while (!validInput) {
            System.out.println("Enter your action (example: move east, take <item name>) > ");
            String action = scanner.nextLine();
            moveString = parser.parseInput(action);
            moveChoice = moveString[0].toLowerCase();
            switch (moveChoice) {
                case "move":
                    moveExecution.move(player, moveString[1].toLowerCase());
                    validInput = true;
                    break;
                case "take":
                    moveExecution.take(moveString[1]);
                    validInput = true;
                    break;
                case "use":
                    moveExecution.use(moveString[1]);
                    validInput = true;
                    break;
                default:
                    System.out.println("Sorry that is not a valid input\nIf you need help just type help!");
            }
        }

    }

    public static void main(String[] args) throws Exception{
        MoveSelection moveSelector = new MoveSelection();
        Player player = new Player();
        moveSelector.playerMove(player);
    }


}