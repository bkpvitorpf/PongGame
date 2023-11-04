package com.mycompany.ponggame;

import Controllers.PanelController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import Panels.GamePanel;
import Panels.OSWindow;
import Utilities.MyKeyListener;

public class PongGame {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    static OSWindow myWindow = new OSWindow("Pong++;", WINDOW_WIDTH, WINDOW_HEIGHT);

    public static void main(String[] args) {
        //myWindow.startGame();
    }
}