package game.actions;

import game.Player;

public class Restart {
    public Restart() {
    }

    public static boolean restart(Player currentPlayer) throws Exception {
        System.out.println();
        System.out.println("New Game started. Move counter and inventory reset, and you have been returned to the starting area\n");
        currentPlayer = new Player();
        currentPlayer.playerInfo(currentPlayer);
        return true;
    }
}