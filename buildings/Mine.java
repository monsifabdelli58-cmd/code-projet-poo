package buildings;


import player.Player;

public class Mine extends Building {

    @Override
    public void produce(Player player) {
        player.getResources().add("GOLD", 10);
    }
}
