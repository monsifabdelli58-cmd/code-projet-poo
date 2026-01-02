package map;

public class Tile {

    private TileType type;

    public Tile(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    public boolean isAccessible() {
        return type != TileType.WATER;
    }
}
