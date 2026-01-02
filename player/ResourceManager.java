package player;


import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

    private Map<String, Integer> resources = new HashMap<>();

    public ResourceManager() {
        resources.put("GOLD", 100);
        resources.put("FOOD", 50);
    }

    public int get(String name) {
        return resources.getOrDefault(name, 0);
    }

    public void add(String name, int amount) {
        resources.put(name, get(name) + amount);
    }
}
