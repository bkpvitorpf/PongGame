/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;
import java.awt.*;
import javax.swing.JPanel;
/**
 *
 * @author VPF
 */
public class GameObject extends JPanel {
    private static int objectsCount = 0;
    public int xPosition, yPosition, width, height;
    public Color color;
    
    public GameObject (int xPosition, int yPosition, int height, int width, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.height = height;
        this.width = width;
        this.color = color;
        
        GameObject.objectsCount ++;
    }
        
    @Override
    public void paint(Graphics g){};
    
    public void update(){
        repaint();
    };

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
    
    public int getObjectsCount(){
        return GameObject.objectsCount;
    };
}
