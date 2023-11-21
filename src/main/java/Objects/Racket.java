package Objects;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author VPF
 */
public class Racket extends GameObject {
    static final int RACKET_WIDTH = 15;
    private int step;

    public Racket(int xPosition, int yPosition, int height, int step, Color color) {
        super(xPosition, yPosition, height, RACKET_WIDTH, color);
        this.step = step;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(xPosition, yPosition, RACKET_WIDTH, height);
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void moveUp() {
        this.setYPosition(this.getYPosition() - this.getStep());
    };

    public void moveDown() {
        this.setYPosition(this.getYPosition() + this.getStep());
    };

    @Override
    public void update() {
        repaint();
    }
}
