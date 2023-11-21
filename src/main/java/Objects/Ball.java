/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author VPF
 */
public class Ball extends GameObject {
    private int xDirection, yDirection;
    private float speed;

    /**
     * @param xPosition     - Posição da bola no eixo x
     * @param yPosition     - Posição da bola no eixo y
     * @param xDirection    - Direção da bola no eixo x
     * @param yDirection    - Direção da bola no eixo y
     * @param speed         - Velocidade da bola
     * @param color         - Cor da bola
     * @param size          - Tamanho do diâmetro da bola
     */
    public Ball(int xPosition, int yPosition, int xDirection, int yDirection, int speed, Color color, int size) {
        super(xPosition, yPosition, size, size, color);
        this.xDirection = xDirection;
        this.yDirection = yDirection;
        this.speed = speed;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color); // define a cor do pincel para a cor da bola

        g.fillOval(xPosition, yPosition, this.width, this.width);// desenha a bola na posição x,y com largura e altura
                                                                 // de size
    }

    // Faz a bola avançar uma determinada quantidade de unidades numa determinada
    // direção
    public void move() {
        this.xPosition += (this.speed * this.xDirection);
        this.yPosition += (this.speed * this.yDirection);
    }

    // Isso é lógica do jogo, não da bola
    /**
     * Faz a bola rebater nas bordas inferiores e superiores da tela
     * 
     * @param top    - Posição do topo da tela
     * @param bottom - Posição da parte inferior da tela
     */
    public void bounceOnEdges(int top, int bottom) {
        // Verifica se a coordenada y da bola passa do limite inferior da tela
        if (this.yPosition > (bottom - this.width) || this.yPosition < top) {
            reverseYDirection();
        }
    }

    public int getxDirection() {
        return xDirection;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    // Inverte o sentido e muda a direção da bola
    public void reverseYDirection() {
        this.yDirection *= -1;
    }

    public void reverseXDirection() {
        this.xDirection *= -1;
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float newSpeed) {
        this.speed = newSpeed;
    }

    @Override
    public void update() {
        repaint();
    }
}
