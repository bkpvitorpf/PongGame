package Panels;

import javax.swing.JPanel;

/**
 *
 * @author VPF
 */
public class Panel extends JPanel {
    final int PANEL_WIDTH = 640, PANEL_HEIGHT = 480;
    public static int objectsCount = 0;

    public Panel() {
        setSize(PANEL_WIDTH, PANEL_HEIGHT);
        
        Panel.objectsCount++;
    }
}