package game.actions;

import game.Player;

public class Use {
    public static boolean use(Player player, String item) throws Exception {
        System.out.println("You have used " + item);
        player.playerInfo(player);
        return true;
    }
}