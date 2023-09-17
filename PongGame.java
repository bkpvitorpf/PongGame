import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PongGame extends JPanel {

    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;

    /**
     * Updates and draws all the graphics on the screen
     */
    public void paintComponent(Graphics g) {

        // draw the background, set color to BLACK and fill in a rectangle
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

    }

}