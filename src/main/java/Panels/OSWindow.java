/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import Controllers.PanelController;
import Utilities.MyKeyListener;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author VPF
 */
public class OSWindow extends JFrame {
    static final int WINDOW_BOTTOM_BORDER = 34,WINDOW_RIGHT_BORDER=16;
    
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel = new JPanel(cardLayout);
    private final MyKeyListener keyListener = new MyKeyListener();
    private final PanelController panelController = new PanelController(cardLayout,  mainPanel , keyListener);
    
    public OSWindow(String title, int windowWidth, int windowHeight){
        this.setTitle(title);
        this.setSize(windowWidth+WINDOW_RIGHT_BORDER,windowHeight + WINDOW_BOTTOM_BORDER);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        this.add(this.mainPanel);
        
        setVisible(true);
    }
    
    public void startGame(){
        Timer timer = new Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Panel controller
                panelController.execute();
            }
        });

        timer.start();
    }
}
