package Game.Objects;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
    // declaração das variáveis
    private int height, xPosition, yPosition, speed;
    private Color color;
    static final int PADDLE_WIDTH = 15;

    public Paddle(int xPosition, int yPosition, int height, int speed, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.height = height;
        this.speed = speed;
        this.color = color;
        
    }

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

    public boolean checkCollison(Ball b){

        int rightX =  xPosition + PADDLE_WIDTH;
        int bottomY = yPosition + height;

        //checando se a bola ta entre os valores de x
        if(b.getXPosition() > xPosition && b.getXPosition() < rightX){
        
        if(b.getYPosition() > yPosition && b.getYPosition() < bottomY){
            //if we get here, we know the ball and the paddle have collided
            return true;
        }
    }

    //if we get here, one of the checks failed, and the ball has not collided
    return false;

    }

    public int getYPosition() {
        return this.yPosition;
    }

    public int getWidth(){
        return PADDLE_WIDTH;
    }

    public int getHeight(){
        return this.height;
    }

    public int getXPosition(){
        return this.xPosition;
    }
}
