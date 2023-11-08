/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ponggame;

import Panels.OSWindow;

/**
 *
 * @author VPF - Fachada
 */
public class Game {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    static OSWindow myWindow = new OSWindow("Pong++;", WINDOW_WIDTH, WINDOW_HEIGHT);
    
    public void start(){
        myWindow.startGame();
    }
}
