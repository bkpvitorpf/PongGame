import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PongGame extends JPanel {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball gameBall;

    public PongGame() {
        gameBall = new Ball(300, 200, 3, 3, 3, Color.YELLOW, 10);
    }

    /**
     * Desenha e atualiza todos os gráficos da tela.
     */
    public void paintComponent(Graphics g) {
        // Desenha e preenche o background da tela
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        gameBall.paint(g);
    }

    /**
     * Chamado a cada frame para executar as operações do jogo.
     */
    public void gameLogic() {

        // Movimenta a bola
        gameBall.moveBall();

        // edge check/bounce
        gameBall.bounceOnEdges(0, WINDOW_HEIGHT);
    }
}