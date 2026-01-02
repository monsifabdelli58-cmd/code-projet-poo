package game;

import map.MapGrid;
import player.Player;
import ai.EnemyAI;

public class GameController {

    private MapGrid map;
    private Player human;
    private Player enemy;
    private EnemyAI ai;
    private int turn;

    public void startNewGame() {
        map = new MapGrid(5, 5);
        human = new Player("Human");
        enemy = new Player("AI");
        ai = new EnemyAI(enemy, human, map);
        turn = 1;

        System.out.println("Game started!");
        nextTurn();
    }

    public void nextTurn() {
        System.out.println("Turn " + turn);
        ai.playTurn();
        turn++;
    }
}
