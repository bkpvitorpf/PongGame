package Game.Objects;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
    private int xPosition, yPosition, xDirection, yDirection, speed, size;
    private Color color;

    // ball constructor assigns values to instance variables
    public Ball(int xPosition, int yPosition, int xDirection, int yDirection, int speed, Color color, int size) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xDirection = xDirection;
        this.yDirection = yDirection;
        this.speed = speed;
        this.color = color;
        this.size = size;
    }

    public void paint(Graphics g) {
        g.setColor(color); // define a cor do pincel para a cor da bola

        g.fillOval(xPosition, yPosition, size, size);// desenha a bola na posição x,y com largura e altura de size
    }

    // Faz a bola avançar uma determinada quantidade de unidades numa determinada
    // direção
    public void moveBall() {
        this.xPosition += this.xDirection;
        this.yPosition += this.yDirection;
    }

    /**
     * Faz a bola rebater nas bordas inferiores e superiores da tela
     * 
     * @param top    - Posição do topo da tela
     * @param bottom - Posição da parte inferior da tela
     */
    public void bounceOnEdges(int top, int bottom) {
        // Verifica se a coordenada y da bola passa do limite inferior da tela
        if (this.yPosition > (bottom - this.size) || this.yPosition < (top - this.size)) {
            reverseYDirection();
        }
    }

    // Inverte o sentido e muda a direção da bola
    private void reverseYDirection() {
        this.yDirection *= -1;
    }
}