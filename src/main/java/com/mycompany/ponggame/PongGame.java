package com.mycompany.ponggame;

import Panels.GameWindow;

public class PongGame {
    static GameWindow game = new GameWindow();

    public static void main(String[] args) {
        game.startGame();
        game.getStatistics("Perspectiva estática - Antes do jogo começar");
    }
}