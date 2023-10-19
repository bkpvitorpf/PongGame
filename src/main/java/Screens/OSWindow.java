/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Screens;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author VPF
 */
public class OSWindow extends JFrame {
    static final int WINDOW_BOTTOM_BORDER = 34,WINDOW_RIGHT_BORDER=16;
    
    public OSWindow(String title, int windowWidth,int windowHeight){
        setTitle(title);
        setSize(windowWidth+WINDOW_RIGHT_BORDER,windowHeight + WINDOW_BOTTOM_BORDER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
