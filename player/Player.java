package player;



public class Player {

    public String name;
    public ResourceManager resources;

    public Player(String name) {
        this.name = name;
        this.resources = new ResourceManager();
    }

    public ResourceManager getResources() {
        return resources;
    }

    public boolean hasLost() {
        return resources.get("GOLD") <= 0;
    }
}
