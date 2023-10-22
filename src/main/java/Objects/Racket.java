/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;
import java.awt.*;
/**
 *
 * @author VPF
 */
public class Racket extends GameObject{
    // Definindo a classe GameObject como superclasse da classe Paddle
    //declaração das variaveis
    static final int PADDLE_WIDTH = 15;
    private int step;
    
    public Racket(int xPosition, int yPosition, int height, int step, Color color) {
        super (xPosition, yPosition, height,PADDLE_WIDTH , color);
        this.step = step;
    }
    
    public int getStep(){
        return this.step;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(xPosition, yPosition, PADDLE_WIDTH, height);
    }
    
    @Override
    public void move() {
//            // Obtém a posição y do centro do paddle
//            int yPaddleCenterPosition = this.yPosition + this.height / 2;
//
//            // Determina se o paddle deve ir ou não para a posição informada, ele só
//            // irá se a posição y do centro do paddle for diferente da posição y informada
//            if (Math.abs(yPaddleCenterPosition - yAxisDesiredPosition) > this.step) {
//                // Verifica se o centro do paddle está abaixo da posição y da bola
//                if (yPaddleCenterPosition < yAxisDesiredPosition) {
//                    this.yPosition += this.step;
//                }
//                // Verifica se o centro do paddle está acima da posição y da bola
//                if (yPaddleCenterPosition > yAxisDesiredPosition) {
//                    this.yPosition -= this.step;
//                }
//            }
    }
}
