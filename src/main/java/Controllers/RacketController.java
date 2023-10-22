package Controllers;

import Objects.Racket;
import Utilities.MyKeyListener;

public class RacketController {
    final private Racket racket;
    final private int keyUp,keyDown, WINDOW_HEIGHT;
    final private MyKeyListener listener;
    
    public RacketController(int keyUp,int keyDown,Racket racket,MyKeyListener listener,int WINDOW_HEIGHT){
        this.racket = racket;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.listener = listener;
        this.WINDOW_HEIGHT = WINDOW_HEIGHT;
    }

    public void checkForMoveUpCommand(){
        if(this.listener.isKeyPressed(keyUp) && this.racket.getYPosition() > 0){
            this.racket.setYPosition(this.racket.getYPosition() - this.racket.getStep());
        }
    }
    
    public void checkForMoveDownCommand(){
        if(this.listener.isKeyPressed(keyDown) && this.racket.getYPosition() + this.racket.getHeight() < WINDOW_HEIGHT){
            this.racket.setYPosition(this.racket.getYPosition() + this.racket.getStep());
        }
    }
}
