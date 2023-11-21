package com.mycompany.ponggame;

import Panels.OSWindow;

/**
 *
 * @author VPF - Fachada
 */
public class Game {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    static OSWindow myWindow = new OSWindow("Pong++;", WINDOW_WIDTH, WINDOW_HEIGHT);

    public void start() {
        myWindow.startGame();
    }
}
