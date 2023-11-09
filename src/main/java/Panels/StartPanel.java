/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author VPF
 */
public class StartPanel extends Panel {
    //Definindo que a classe StartScreen faz parte da superclasse Screen
    
    @Override
    public void paintComponent(Graphics g) {
        // Desenha e preenche o background da tela
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.PANEL_WIDTH, this.PANEL_HEIGHT);
        
        Font font = new Font("Verdana", Font.BOLD, 56);

        g.setFont(font);
        g.setColor(Color.WHITE);
        
        g.drawString("Pong ++;", (PANEL_WIDTH - 280)/2, (PANEL_HEIGHT-60)/2);
        
        Font textFont = new Font("Verdana", Font.BOLD, 16);

        g.setFont(textFont);
        g.setColor(Color.WHITE);
        
        g.drawString("Pressione \"Enter\" para iniciar", (PANEL_WIDTH - 245)/2, (PANEL_HEIGHT+80)/2);
    }
}
