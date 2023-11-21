package Objects;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author VPF
 */
public class Wall extends GameObject {
    static final int WALL_WIDTH = 15;
    private int life;

    public Wall(int xPosition, int yPosition, int height, int width, Color color, int life) {
        super(xPosition, yPosition, height, width, color);
        this.life = life;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(xPosition, yPosition, WALL_WIDTH, height);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public void update() {
        repaint();
    }
}
