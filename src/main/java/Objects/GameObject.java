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
public abstract class GameObject {
    
    protected int xPosition, yPosition, width, height;
    protected Color color;
    
    
    public GameObject (int xPosition, int yPosition, int height, int width, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.height = height;
        this.width = width;
        this.color = color;
    }
    
    public abstract void move(int stepSize);
    
    public void paint(Graphics g){};

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public boolean checkCollisionWithTheBall(Ball ball) {
        // Pega a coordenada da borda direita do objeto
        int RightSideCoordinate = this.xPosition + this.width;
        // Pega a coordenada da borda inferior do objeto
        int BottomCoordinate = this.yPosition + this.height;

        // Verifica se a coordenada x da bola está sobre o objeto
        if (ball.getXPosition() > (this.xPosition - ball.getWidth()) && ball.getXPosition() < RightSideCoordinate) {
            // Verifica se a coordenada y da bola está sobre o objeto
            if (ball.getYPosition() > this.yPosition && ball.getYPosition() < BottomCoordinate) {
                // Se entrou neste if, é porque há colisão com a bola
                return true;
            }
        }

        // Caso não haja colisão, retorna falso
        return false;
    }
}
