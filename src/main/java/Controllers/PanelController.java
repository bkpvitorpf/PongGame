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
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
/**
 *
 * @author VPF
 */
public class PanelController {
    private final GamePanel gamePanel;
    private final Panel startPanel;
    private String currentPanel;
    private final CardLayout cards;
    private final JPanel mainPanel;
    private final MyKeyListener keylistener;
    private static int objectsCount = 0;

    public PanelController(CardLayout cards, JPanel mainPanel , MyKeyListener keyListener) {
        this.gamePanel = new GamePanel(keyListener);
        this.startPanel = new StartPanel();
        this.currentPanel = "Start";
        this.cards = cards;
        this.mainPanel = mainPanel;
        this.keylistener = keyListener;
        
        this.mainPanel.add(gamePanel, "Game");
        this.mainPanel.add(startPanel,"Start");
        this.cards.show(mainPanel,"Start");
        
        PanelController.objectsCount++;
    }
    
    public void switchToPanel(String destinyPanel){
        this.cards.show(this.mainPanel, destinyPanel);
       
        this.currentPanel = destinyPanel;
    };
    
    public void execute(){
        if(keylistener.isKeyPressed(KeyEvent.VK_ENTER) && ("Start".equals(this.currentPanel))){
            this.switchToPanel("Game");
        }
        
        if("Game".equals(this.currentPanel)){
            this.gamePanel.runGame();
            
            if(!this.gamePanel.getGameWinner().isEmpty()){
                this.switchToPanel("Start");
            }
        }
    }
}
