package game.map;

import java.util.HashMap;
import java.util.Map;

public class Tile {
    private String type;
    private boolean accessible;
    private Map<String, Integer> bonuses; 

    public Tile(String type, boolean accessible) {
        this.type = type;
        this.accessible = accessible;
        this.bonuses = new HashMap<>();
       
        switch (type.toUpperCase()) {
            case "GRASS":
                bonuses.put("defense", 1);
                break;
            case "WATER":
                accessible = false; 
                bonuses.put("movement", -2); 
                break;
            case "MOUNTAIN":
                bonuses.put("defense", 3);
                bonuses.put("movement", -1);
                break;
        }
    }

    public String getType() {
        return type;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public Map<String, Integer> getBonuses() {
        return bonuses;
    }

    public int getBonus(String key) {
        return bonuses.getOrDefault(key, 0);
    }
}