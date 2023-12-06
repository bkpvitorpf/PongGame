package Panels;

import Controllers.GameController;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import Controllers.PanelController;
import Controllers.RacketController;
import Objects.Ball;
import Objects.GameObject;
import Objects.Racket;
import Objects.Score;
import Objects.Wall;
import Utilities.GameKeylistener;

/**
 *
 * @author VPF
 */
public class GameWindow extends JFrame {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    static final int WINDOW_BOTTOM_BORDER = 34, WINDOW_RIGHT_BORDER = 16;

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);
    private final GameKeylistener keyListener = new GameKeylistener();
    private final PanelController panelController = new PanelController(cardLayout, mainPanel, keyListener);

    public static int objectsCount = 0;
    
    public GameWindow() {
        this.setTitle("Pong++;");
        this.setSize(WINDOW_WIDTH + WINDOW_RIGHT_BORDER, WINDOW_HEIGHT + WINDOW_BOTTOM_BORDER);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        this.add(this.mainPanel);

        setVisible(true);
        
        GameWindow.objectsCount++;
    }

    public void startGame() {
        Timer timer = new Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Panel controller
                panelController.execute();
            }
        });

        timer.start();
    }
    
    static public void getStatistics(String text){
        System.out.println(text + "\n\n");
        System.out.println("Nº de GameControllers: " + GameController.objectsCount + "\n");
        System.out.println("Nº de PanelControllers: " + PanelController.objectsCount + "\n");
        System.out.println("Nº de RacketControllers: " + RacketController.objectsCount + "\n");
        System.out.println("Nº de Ball: " + Ball.objectsCount + "\n");
        System.out.println("Nº de GameObjects: " + GameObject.objectsCount + "\n");
        System.out.println("Nº de Racket: " + Racket.objectsCount + "\n");
        System.out.println("Nº de Score: " + Score.objectsCount + "\n");
        System.out.println("Nº de Wall: " + Wall.objectsCount + "\n");
        System.out.println("Nº de EndPanel: " + EndPanel.objectsCount + "\n");
        System.out.println("Nº de GamePanel: " + GamePanel.objectsCount + "\n");
        System.out.println("Nº de GameWindow: " + GameWindow.objectsCount + "\n");
        System.out.println("Nº de Panel: " + Panel.objectsCount + "\n");
        System.out.println("Nº de StartPanel: " + StartPanel.objectsCount + "\n");
        System.out.println("Nº de MyKeyListener: " + GameKeylistener.objectsCount + "\n\n");
    }
}
