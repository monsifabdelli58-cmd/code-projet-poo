package game.ui;

import game.map.Map;
import game.map.Tile;
import game.units.Unit;
import game.units.Position; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel {
    private Map gameMap;
    private List<Unit> units;
    private Unit selectedUnit;
    private int tileSize = 50; 

    public GamePanel() {
        units = new ArrayList<>(); 
        gameMap = new Map(); 

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / tileSize;
                int y = e.getY() / tileSize;
                handleClick(x, y);
                repaint();
            }
        });
    }

    public void initializeGame() {}

    private void handleClick(int x, int y) {
        
        if (selectedUnit != null) {
            selectedUnit.move(new Position(x, y)); 
            selectedUnit = null; 
        } else { 
            for (Unit unit : units) {
                if (unit.getPosition().getX() == x && unit.getPosition().getY() == y) {
                    selectedUnit = unit;
                    break;
                }
            }
        }
        System.out.println("Clic sur case: " + x + "," + y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        
        if (gameMap == null || gameMap.getGrid() == null) return;

        List<List<Tile>> grid = gameMap.getGrid();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                Tile tile = grid.get(i).get(j);
                if (tile != null) {
                    Color color = getTileColor(tile.getType());
                    g2d.setColor(color);
                    g2d.fillRect(j * tileSize, i * tileSize, tileSize, tileSize);
                    g2d.setColor(Color.BLACK);
                    g2d.drawRect(j * tileSize, i * tileSize, tileSize, tileSize);
                }
            }
        }

        
        g2d.setColor(Color.RED);
        for (Unit unit : units) {
            if (unit != null && unit.getPosition() != null) {
                int x = unit.getPosition().getX() * tileSize + tileSize / 4;
                int y = unit.getPosition().getY() * tileSize + tileSize / 4;
                g2d.fillOval(x, y, tileSize / 2, tileSize / 2);
            }
        }

        g2d.setColor(Color.BLACK);
        g2d.drawString("Or: 100 | Bois: 50", 10, 20); 
    }

    private Color getTileColor(String type) {
        if (type == null) return Color.WHITE;
        switch (type.toUpperCase()) {
            case "GRASS": return Color.GREEN;
            case "WATER": return Color.BLUE;
            case "MOUNTAIN": return Color.GRAY;
            default: return Color.WHITE;
        }
    }
}