package ai;


import map.MapGrid;
import player.Player;

public class EnemyAI {

     Player enemy;
     Player human;
     MapGrid map;

    public EnemyAI(Player enemy, Player human, MapGrid map) {
        this.enemy = enemy;
        this.human = human;
        this.map = map;
    }

    public void playTurn() {
        enemy.getResources().add("GOLD", 5);
        System.out.println("AI plays its turn ");
    }
}
