/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Panels.EndPanel;
import Panels.GamePanel;
import Panels.Panel;
import Panels.StartPanel;
import Utilities.MyKeyListener;
import java.awt.CardLayout;
import javax.swing.JPanel;
/**
 *
 * @author VPF
 */
public class PanelController {
    private GamePanel gamePanel;
    private final Panel startPanel, endPanel, currentPanel;
    private CardLayout cards;
    private JPanel mainPanel;

    public PanelController(CardLayout cards, JPanel mainPanel , MyKeyListener keyListener) {
        this.gamePanel = new GamePanel(keyListener);
        this.startPanel = new StartPanel();
        this.endPanel = new EndPanel();
        this.currentPanel = this.startPanel;
        this.cards = cards;
        this.mainPanel = mainPanel;
        
        this.mainPanel.add(gamePanel, "Game");
        this.mainPanel.add(startPanel,"Start");
        this.cards.show(mainPanel,"Start");
    }
    
    public void switchToPanel(String destinyPanel){
        this.cards.show(this.mainPanel, destinyPanel);
        
        if("Game".equals(destinyPanel)){
            this.gamePanel.runGame();
        }
    };
}
