/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game.Objects;
import java.awt.*;
import java.util.Random;

/**
 *
 * @author VPF
 */
public class Ball extends GameObject {
    public int xDirection, yDirection, WINDOW_WIDTH,WINDOW_HEIGHT;
    // Definindo a classe GameObject como superclasse da classe Ball
    // ball constructor assigns values to instance variables
    
    /**
     * @param xPosition - Posição da bola no eixo x
     * @param yPosition - Posição da bola no eixo y
     * @param xDirection - Direção da bola no eixo x
     * @param yDirection - Direção da bola no eixo y
     * @param speed - Velocidade da bola
     * @param color - Cor da bola
     * @param size - Tamanho do diâmetro da bola
     * @param WINDOW_WIDTH - LArgura da tela onde a bola está sendo renderizada
     * @param WINDOW_HEIGHT
     */
    public Ball(int xPosition, int yPosition,int xDirection, int yDirection, int speed, Color color, int size, int WINDOW_WIDTH,int WINDOW_HEIGHT) {
        super(xPosition, yPosition, size, size, speed, color);
        this.xDirection = xDirection;
        this.yDirection = yDirection;
        this.WINDOW_HEIGHT = WINDOW_HEIGHT;
        this.WINDOW_WIDTH = WINDOW_WIDTH;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color); // define a cor do pincel para a cor da bola

        g.fillOval(xPosition, yPosition,this.width, this.width);// desenha a bola na posição x,y com largura e altura de size
    }

    // Faz a bola avançar uma determinada quantidade de unidades numa determinada
    // direção
    public void moveBall() {
        this.xPosition += (this.speed*this.xDirection);
        this.yPosition += (this.speed*this.yDirection);
    }
    
//Isso é lógica do jogo, não da bola
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

    // Inverte o sentido e muda a direção da bola
    private void reverseYDirection() {
        this.yDirection *= -1;
    }

    public void reverseXDirection() {
        this.xDirection *= -1;
    }
    
    //Isso é logica do jogo, não da bola
     // Verifica se a bola saiu da tela, caso tenha saído, coloca ela novamente no centro da tela e aleatoriza a direção que ela vai movimentar
    public void respawnWhenExitOfScreen(){
        if(this.getXPosition() < 0 || this.getXPosition() > this.WINDOW_WIDTH){
            this.xPosition = this.WINDOW_WIDTH/2;
            this.yPosition = this.WINDOW_HEIGHT/2;
            
            //Aleatoriza  a direção que a bola seguirá
            
            // Gera uma matriz pra armazenar todas as opções possíveis de direção
            int options[][] = {{1,1},{1,-1},{-1,1},{-1,-1}};
            
            //Gera o valor true ou false aleatoreamente e armazena numa variável
            boolean randomBooleanValue = new Random().nextBoolean();
            
            this.yDirection = randomBooleanValue ? 1 : -1;
            this.xDirection = randomBooleanValue ? -1: 1;
        }
    }
}
