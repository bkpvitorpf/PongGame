/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Panels;

import Controllers.GameController;
import java.awt.Color;
import java.awt.Graphics;
import Utilities.MyKeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author VPF
 */
public class GamePanel extends Panel {
    private final GameController gameController;

    public GamePanel(MyKeyListener keyListener) {
        // Chama o construtor da classe Panel
        super();
        
        // Instancia o controlador do jogo        
        this.gameController = new GameController(keyListener);
    }

    /**
     * Desenha e atualiza todos os gráficos da tela.
     */
    @Override
    public void paintComponent(Graphics g) {
        // Desenha e preenche o background da tela
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.PANEL_WIDTH, this.PANEL_HEIGHT);

        // Desenha os objetos do jogo
        this.gameController.showObjectsOnScreen(g);
    }

    /**
     * Executar as operações do jogo. Deve ser chamado continuamente
     */
    public void runGame() {
        // game logic
        gameController.runGameLogic();
                
        // repaint the screen
        repaint();
    }
    
    public String getGameWinner(){
        return gameController.getWinner();
    }
}
