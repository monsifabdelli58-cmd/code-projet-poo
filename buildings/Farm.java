package buildings;



import player.Player;

public class Farm extends Building {

    @Override
    public void produce(Player player) {
        player.getResources().add("FOOD", 5);
    }
}
