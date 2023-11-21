package Objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author VPF
 */
public class Score extends GameObject {
    private int value;
    private final String text;

    public Score(String text, int xPosition, int yPosition, int value, Color color) {
        super(xPosition, yPosition, 0, 0, color);
        this.value = value;
        this.text = text;
    }
    
    public int getValue(){
        return this.value;
    };
    
    public void setScore(int newValue){
        this.value = newValue;
    };
    
    @Override
    public void paint(Graphics g){
        Font font = new Font("Verdana", Font.BOLD, 16);

        g.setFont(font);
        g.setColor(this.color);
        
        g.drawString(this.text + " [ " +this.value+" ]", this.xPosition, this.yPosition);
    };

    @Override
    public void update() {
        repaint();
    }
}
