/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import System.Utilities.MyKeyListener;

/**
 *
 * @author VPF
 */
public class EndScreen extends JPanel {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private String message;

    public EndScreen(String message) {
        this.message = message;
    }

    /**
     * Desenha e atualiza todos os gráficos da tela.
     */
    @Override
    public void paintComponent(Graphics g) {
        // Desenha e preenche o background da tela
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        Font font = new Font("Verdana", Font.BOLD, 48);

        g.setFont(font);
        g.setColor(Color.WHITE);

        g.drawString("Fim de jogo!", 165, 75);

        Font font2 = new Font("Verdana", Font.BOLD, 16);
        g.setFont(font2);

        g.drawString(message, 185, WINDOW_HEIGHT / 2);
    }
}
