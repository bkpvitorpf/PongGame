/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import Game.Controllers.PlayerController;
import Game.Objects.Ball;
import Game.Objects.Paddle;
import Game.Screens.Elements.Score.Score;
import System.Screens.OSWindow;
import System.Utilities.MyKeyListener;

/**
 *
 * @author VPF
 */
public class GameScreen extends JPanel {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private final Ball gameBall;
    private final Paddle gamePaddle1, gamePaddle2;
    private final PlayerController player2Controller, player1Controller;
    private final Score player1, player2;
    private OSWindow myWindow;
    private EndScreen endScreen;

    public GameScreen(MyKeyListener keyListener, OSWindow myWindow) {
        // Instancia os objetos do jogo
        this.gameBall = new Ball(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, 1, 1, 3, Color.YELLOW, 10, WINDOW_WIDTH,
                WINDOW_HEIGHT);
        this.gamePaddle1 = new Paddle(0, 50, 150, 5, Color.yellow);
        this.gamePaddle2 = new Paddle((WINDOW_WIDTH - 15), 150, 150, 5, Color.green);
        this.player1Controller = new PlayerController(KeyEvent.VK_W, KeyEvent.VK_S, gamePaddle1, keyListener,
                WINDOW_HEIGHT);
        this.player2Controller = new PlayerController(KeyEvent.VK_UP, KeyEvent.VK_DOWN, gamePaddle2, keyListener,
                WINDOW_HEIGHT);
        this.player1 = new Score(0);
        this.player2 = new Score(0);

        this.myWindow = myWindow;
    }

    /**
     * Desenha e atualiza todos os gráficos da tela.
     */
    @Override
    public void paintComponent(Graphics g) {
        // Desenha e preenche o background da tela
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        gameBall.paint(g);

        gamePaddle1.paint(g);
        gamePaddle2.paint(g);

        Font font = new Font("Verdana", Font.BOLD, 16);

        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("SCORE - PLAYER 1 [" + player1.getPlayerScore() + "]  PLAYER 2 [" + player2.getPlayerScore() + "]",
                17, 20);
    }

    /**
     * Chamado a cada frame para executar as operações do jogo.
     */
    public void gameLogic() {
        // Movimenta a bola
        gameBall.moveBall();

        // Verifica se há colisão da bola com a borda inferior ou superior e aplica a
        // lógica
        gameBall.bounceOnEdges(0, WINDOW_HEIGHT);

        // Verifica se há colisão dos paddles com a bola
        if (gamePaddle1.checkCollision(gameBall) || gamePaddle2.checkCollision(gameBall)) {
            gameBall.reverseXDirection();
        }

        // Verifica se há comandos de movimentação para os paddles
        player1Controller.checkForMoveUpCommand();
        player1Controller.checkForMoveDownCommand();
        player2Controller.checkForMoveUpCommand();
        player2Controller.checkForMoveDownCommand();

        /*
         * Verifica se a bola saiu da tela, ou seja se algum jogador pontuou,
         * e então incrementa a pontuação do jogador e redefine a posição da bola
         */
        if (gameBall.exitOfScreen()) {
            if (gameBall.getXPosition() > 10) {
                player1.newScore();

                if (player1.isPlayerWinner()) {
                    // Caso o jogador 1 possua pontuação 5
                    EndScreen endScreen = new EndScreen("Jogador 1 Ganhou!");
                    myWindow.removeAll();

                    myWindow.add(endScreen);
                    endScreen.repaint();
                }
            } else {
                player2.newScore();

                if (player2.isPlayerWinner()) {
                    // Caso o jogador 2 possua pontuação de 5
                    EndScreen endScreen = new EndScreen("Jogador 2 Ganhou!");
                    myWindow.removeAll();
                    endScreen.setVisible(true);
                    myWindow.add(endScreen);
                    endScreen.repaint();
                }
            }

            gameBall.respawn();
        }
    }
}
