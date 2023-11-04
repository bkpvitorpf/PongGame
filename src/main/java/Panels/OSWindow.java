/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import Controllers.PanelController;
import Utilities.MyKeyListener;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author VPF
 */
public class OSWindow extends JFrame {
    static final int WINDOW_BOTTOM_BORDER = 34,WINDOW_RIGHT_BORDER=16;
    private PanelController panelController;
    keyListener
    
    public OSWindow(String title, int windowWidth, int windowHeight, ){
        setTitle(title);
        setSize(windowWidth+WINDOW_RIGHT_BORDER,windowHeight + WINDOW_BOTTOM_BORDER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(keyListener);
                
     this.panelController = new PanelController(keyListener);

        
        this.panelController.showCurrentPanel();
    }
    
}
