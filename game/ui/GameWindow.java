package game.ui;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GamePanel gamePanel;
    private JButton newGameButton, loadButton, quitButton;

    public GameWindow() {
        setTitle("Jeu Stratégique");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Menu principal
        JPanel menuPanel = new JPanel();
        newGameButton = new JButton("Nouvelle Partie");
        loadButton = new JButton("Charger");
        quitButton = new JButton("Quitter");

        menuPanel.add(newGameButton);
        menuPanel.add(loadButton);
        menuPanel.add(quitButton);
        add(menuPanel, BorderLayout.NORTH);

        
        gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);

       
        newGameButton.addActionListener(e -> startNewGame());
        quitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void startNewGame() {
       
        gamePanel.setVisible(true);
        gamePanel.repaint(); 
    }

    public static void main(String[] args) {
        new GameWindow();
    }
}