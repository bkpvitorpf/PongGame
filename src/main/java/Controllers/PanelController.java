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
    private final Panel startPanel, gamePanel, endPanel, currentPanel;
    private JPanel panels;
    private CardLayout cards;

    public PanelController(MyKeyListener keyListener) {
        this.gamePanel = new GamePanel(keyListener);
        this.startPanel = new StartPanel();
        this.endPanel = new EndPanel();
        this.cards =  new CardLayout();
        this.currentPanel = this.startPanel;
        
        panels.setLayout(cards);
        
        panels.add(gamePanel, "Game");
        panels.add(startPanel,"Start");
    }
    
    public void switchToPanel(Panel destinyPanel){
        this.cards.show(destinyPanel, destinyPanel.getName());
    };
    
    public void showCurrentPanel(){
        this.cards.next(currentPanel);
    };
}
