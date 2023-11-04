/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import Controllers.PanelController;
import Utilities.MyKeyListener;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author VPF
 */
public class OSWindow extends JFrame {
    static final int WINDOW_BOTTOM_BORDER = 34,WINDOW_RIGHT_BORDER=16;
    
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private MyKeyListener keyListener = new MyKeyListener();
    private PanelController panelController = new PanelController(cardLayout,  mainPanel , keyListener);
    
    public OSWindow(String title, int windowWidth, int windowHeight){
        this.setTitle(title);
        this.setSize(windowWidth+WINDOW_RIGHT_BORDER,windowHeight + WINDOW_BOTTOM_BORDER);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        this.add(this.mainPanel);
        
        setVisible(true);
    }
    
    public void startGame(){
        this.panelController.switchToPanel("Game");
    }
}
