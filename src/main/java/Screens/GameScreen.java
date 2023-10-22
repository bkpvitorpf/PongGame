/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Screens;

import Controllers.GameController;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import Utilities.MyKeyListener;

/**
 *
 * @author VPF
 */
public class GameScreen extends JPanel {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private final GameController gameController;

    public GameScreen(MyKeyListener keyListener) {
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
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        this.gameController.showObjectsOnScreen(g);

        Font font = new Font("Verdana", Font.BOLD, 16);

        g.setFont(font);
        g.setColor(Color.WHITE);
        //g.drawString("SCORE - PLAYER 1 [" + player1.getPlayerScore() + "]  PLAYER 2 [" + player2.getPlayerScore() + "]",17, 20);
    }

    /**
     * Chamado a cada frame para executar as operações do jogo.
     */
    public void runGame() {
        this.gameController.runGameLogic();
//        // Movimenta a bola
//        ball.move(ball.getSpeed());
//
//        // Verifica se há colisão da bola com a borda inferior ou superior e aplica a
//        // lógica
//        ball.bounceOnEdges(0, WINDOW_HEIGHT);
//
//        // Verifica se há colisão dos paddles com a bola
//        if (gameController.(ball) || racket2.checkCollisionWithTheBall(ball)) {
//            ball.reverseXDirection();
//        }
//
//        // Verifica se há comandos de movimentação para os paddles
//        racket1Controller.checkForMoveUpCommand();
//        racket1Controller.checkForMoveDownCommand();
//        racket2Controller.checkForMoveUpCommand();
//        racket2Controller.checkForMoveDownCommand();
//
//        /*
//         * Verifica se a bola saiu da tela, ou seja se algum jogador pontuou,
//         * e então incrementa a pontuação do jogador e redefine a posição da bola
//         */
//        if (ball.exitOfScreen()) {
//            if (ball.getXPosition() > 10) {
//                player1.newScore();
//
//                if (player1.isPlayerWinner()) {
//                    // Caso o jogador 1 possua pontuação 5
//                    EndScreen endScreen = new EndScreen("Jogador 1 Ganhou!");
//                    myWindow.removeAll();
//
//                    myWindow.add(endScreen);
//                    endScreen.repaint();
//                }
//            } else {
//                player2.newScore();
//
//                if (player2.isPlayerWinner()) {
//                    // Caso o jogador 2 possua pontuação de 5
//                    EndScreen endScreen = new EndScreen("Jogador 2 Ganhou!");
//                    myWindow.removeAll();
//                    endScreen.setVisible(true);
//                    myWindow.add(endScreen);
//                    endScreen.repaint();
//                }
//            }
//
//            ball.respawnWhenExitOfScreen();
//        }
    }
}
