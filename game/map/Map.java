package game.map;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<List<Tile>> grid;
    private int width = 10; 
    private int height = 10; 
    public Map() {
        generateStaticMap(); 
    }

    
    private void generateStaticMap() {
        grid = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<Tile> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                String type;
                if (i < 3) type = "GRASS";
                else if (i < 6) type = "WATER";
                else type = "MOUNTAIN";
                row.add(new Tile(type, !type.equals("WATER"))); 
            }
            grid.add(row);
        }
    }

    public List<List<Tile>> getGrid() {
        return grid;
    }

    public Tile getTile(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return grid.get(y).get(x);
        }
        return null;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}