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
public class GameObject {
    
    protected int xPosition, yPosition, speed, width, height;
    protected Color color;
    
    
    public GameObject (int xPosition, int yPosition, int height, int width, int speed, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.height = height;
        this.width = width;
        this.speed = speed;
        this.color = color;
    }
    
    public void paint(Graphics g) {
  
    }
    
    public int getYPosition() {
        return this.yPosition;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getXPosition() {
        return this.xPosition;
    }
    
}
