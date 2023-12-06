package Objects;

import java.awt.Color;

import javax.swing.JPanel;

/**
 *
 * @author VPF
 */
public class GameObject extends JPanel {
    public static int objectsCount = 0;
    public int xPosition, yPosition, width, height;
    public Color color;

    public GameObject(int xPosition, int yPosition, int height, int width, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.height = height;
        this.width = width;
        this.color = color;

        GameObject.objectsCount++;
    }

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

    public void setWidth(int width) {
        this.width = width;
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

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    public int getObjectsCount() {
        return GameObject.objectsCount;
    };

    // public abstract void update();
}
