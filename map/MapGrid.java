package map;


public class MapGrid {

    private Tile[][] grid;

    public MapGrid(int rows, int cols) {
        grid = new Tile[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Tile(TileType.GRASS);
            }
        }
    }

    public Tile getTile(int x, int y) {
        return grid[x][y];
    }
}
