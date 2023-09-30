/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.Screens;

import Game.Controllers.PlayerController;
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
public class GameScreen extends JPanel {
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private final Ball gameBall;
    private final Paddle gamePaddle1, gamePaddle2;
    private final PlayerController player2Controller, player1Controller;

    public GameScreen(MyKeyListener keyListener) {
        // Instancia os objetos do jogo
        this.gameBall = new Ball(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2, 1, 1, 3, Color.YELLOW, 10,WINDOW_WIDTH,WINDOW_HEIGHT);
        this.gamePaddle1 = new Paddle(0, 50, 150, 5, Color.yellow);
        this.gamePaddle2 = new Paddle((WINDOW_WIDTH - 15), 150, 150, 5, Color.green);
        this.player1Controller = new PlayerController(KeyEvent.VK_W,KeyEvent.VK_S,gamePaddle1,keyListener,WINDOW_HEIGHT);
        this.player2Controller = new PlayerController(KeyEvent.VK_UP,KeyEvent.VK_DOWN,gamePaddle2,keyListener,WINDOW_HEIGHT);
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
    }

    /**
     * Chamado a cada frame para executar as operações do jogo.
     */
    public void gameLogic() {
        // Movimenta a bola
        gameBall.moveBall();
        
        //Verifica se a bola saiu da tela e faz ela aparecer novamente
        gameBall.respawnWhenExitOfScreen();

        // Verifica se há colisão da bola com a borda inferior ou superior e aplica a
        // lógica
        gameBall.bounceOnEdges(0, WINDOW_HEIGHT);

        // Verifica se há colisão dos paddles com a bola
        if (gamePaddle1.checkCollision(gameBall) || gamePaddle2.checkCollision(gameBall)) {
            gameBall.reverseXDirection();
        }

        //Verifica se há comandos de movimentação para os paddles
        player1Controller.checkForMoveUpCommand();
        player1Controller.checkForMoveDownCommand();
        player2Controller.checkForMoveUpCommand();
        player2Controller.checkForMoveDownCommand();
    }
}
