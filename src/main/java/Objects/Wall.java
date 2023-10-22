/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import static Objects.Racket.PADDLE_WIDTH;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author VPF
 */
public class Wall extends GameObject{
    private int life;
    
    public Wall(int xPosition, int yPosition, int height, int width,Color color, int life) {
        super (xPosition, yPosition, height,width, color);
        this.life = life;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(xPosition, yPosition, PADDLE_WIDTH, height);
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
    
    @Override
    public void move(){};
    
    public void destroyWall(){
        
    }
}
