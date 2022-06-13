package game.actions;

import game.Player;

public class Take {
    public static boolean take(Player player, String item) throws Exception {
        System.out.println("You have picked up " + item);
        player.playerInfo(player);
        return true;
    }
}