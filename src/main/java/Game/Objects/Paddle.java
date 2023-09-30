/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.Objects;
import java.awt.*;
/**
 *
 * @author VPF
 */
public class Paddle extends GameObject{
    // Definindo a classe GameObject como superclasse da classe Paddle
    //declaração das variaveis
    static final int PADDLE_WIDTH = 15;

    public Paddle(int xPosition, int yPosition, int height, int speed, Color color) {
        super (xPosition, yPosition, height,PADDLE_WIDTH , speed, color);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(xPosition, yPosition, PADDLE_WIDTH, height);
    }

    public void moveOnYAxisTo(int yAxisDesiredPosition) {
        // Obtém a posição y do centro do paddle
        int yPaddleCenterPosition = this.yPosition + this.height / 2;

        // Determina se o paddle deve ir ou não para a posição informada, ele só
        // irá se a posição y do centro do paddle for diferente da posição y informada
        if (Math.abs(yPaddleCenterPosition - yAxisDesiredPosition) > this.speed) {
            // Verifica se o centro do paddle está abaixo da posição y da bola
            if (yPaddleCenterPosition < yAxisDesiredPosition) {
                this.yPosition += this.speed;
            }
            // Verifica se o centro do paddle está acima da posição y da bola
            if (yPaddleCenterPosition > yAxisDesiredPosition) {
                this.yPosition -= this.speed;
            }
        }

    }

    public boolean checkCollision(Ball ball) {
        // Pega a coordenada da borda direita do paddle
        int xRightCoordinate = this.xPosition + this.width;
        // Pega a coordenada da borda inferior do paddle
        int yBottomCoordinate = this.yPosition + this.height;

        // Verifica se a coordenada x da bola está sobre o paddle
        if (ball.getXPosition() > (this.xPosition - ball.getWidth()) && ball.getXPosition() < xRightCoordinate) {
            // Verifica se a coordenada y da bola está sobre o paddle
            if (ball.getYPosition() > this.yPosition && ball.getYPosition() < yBottomCoordinate) {
                // Se entrou neste if, é porque há colisão do paddle com a bola
                return true;
            }
        }

        // Caso não haja colisão, retorna falso
        return false;
    }

    public int getSpeed() {
        return speed;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}
