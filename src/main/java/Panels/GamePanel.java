package Panels;

import java.awt.Color;
import java.awt.Graphics;

import Controllers.GameController;
import Utilities.GameKeylistener;

/**
 *
 * @author VPF
 */
public class GamePanel extends Panel {
    private final GameController gameController;
    public static int objectsCount = 0;

    public GamePanel(GameKeylistener keyListener) {
        // Chama o construtor da classe Panel
        super();

        // Instancia o controlador do jogo
        this.gameController = new GameController(keyListener);
        
        GamePanel.objectsCount++;
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

        //gameController.updateGame();
       
        this.repaint();
    }

    public String getGameWinner() {
        return gameController.getWinner();
    }

    public void resetGame() {
        this.gameController.resetGame();
    }
}
