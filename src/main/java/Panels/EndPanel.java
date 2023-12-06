package Panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author VPF
 */
public class EndPanel extends Panel {
    private final String gameWinner;
    public static int objectsCount = 0;
    
    public EndPanel(String gameWinner) {
        super();
        
        this.gameWinner = gameWinner;
        
        EndPanel.objectsCount++;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        // Desenha e preenche o background da tela
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.PANEL_WIDTH, this.PANEL_HEIGHT);
        
        Font font = new Font("Verdana", Font.BOLD, 48);

        g.setFont(font);
        g.setColor(Color.WHITE);
        
        g.drawString("Parabéns " + gameWinner, (PANEL_WIDTH - 400)/2, (PANEL_HEIGHT-60)/2);
        
        Font subtitleFont = new Font("Verdana", Font.BOLD, 32);
        
        g.setFont(subtitleFont);
        g.drawString("Você ganhou!", (PANEL_WIDTH - 240)/2, (PANEL_HEIGHT+25)/2);

        
        Font textFont = new Font("Verdana", Font.BOLD, 16);

        g.setFont(textFont);
        g.setColor(Color.WHITE);
        
        g.drawString("Pressione \"h\" para voltar a tela inicial", (PANEL_WIDTH - 245)/2, (PANEL_HEIGHT+150)/2);
    }
}
