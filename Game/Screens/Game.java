/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.Screens;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import Game.Objects.Ball;
import Game.Objects.Paddle;
import System.Utilities.MyKeyListener;

/**
 *
 * @author VPF
 */
public class Game extends JPanel {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball gameBall;
    private Paddle gamePaddle1, gamePaddle2;
    private MyKeyListener keyListener;

    public Game(MyKeyListener keyListener) {
        // Instancia os objetos do jogo
        gameBall = new Ball(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, 3, 3, 3, Color.YELLOW, 10);
        gamePaddle1 = new Paddle(0, 50, 150, 5, Color.yellow);
        gamePaddle2 = new Paddle(WINDOW_WIDTH - 15, 150, 150, 5, Color.green);

        this.keyListener = keyListener;
    }

    /**
     * Desenha e atualiza todos os gráficos da tela.
     */
    public void paintComponent(Graphics g) {
        // Desenha e preenche o background da tela
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        gameBall.paint(g);

        gamePaddle1.paint(g);
        gamePaddle2.paint(g);
    }

    /**
     * Chamado a cada frame para executar as operações do jogo.
     */
    public void gameLogic() {

        // Movimenta a bola
        gameBall.moveBall();

        // Verifica se há colisão da bola e aplica a lógica
        gameBall.bounceOnEdges(0, WINDOW_HEIGHT);

        gamePaddle1.moveOnYAxisTo(600);
        gamePaddle2.moveOnYAxisTo(-600);

        if (keyListener.isKeyPressed(KeyEvent.VK_UP)) {
            System.out.println("aaa");
        }
    }
}
