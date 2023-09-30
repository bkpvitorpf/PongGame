package Game.Controllers;

import Game.Objects.Paddle;
import System.Utilities.MyKeyListener;

public class PlayerController {
    final private Paddle paddle;
    final private int keyUp,keyDown, WINDOW_HEIGHT;
    final private MyKeyListener listener;
    
    public PlayerController(int keyUp,int keyDown,Paddle paddle,MyKeyListener listener,int WINDOW_HEIGHT){
        this.paddle=paddle;
        this.keyUp = keyUp;
        this.keyDown = keyDown;
        this.listener = listener;
        this.WINDOW_HEIGHT = WINDOW_HEIGHT;
    }

    public void checkForMoveUpCommand(){
        if(this.listener.isKeyPressed(keyUp) && this.paddle.getYPosition() > 0){
            this.paddle.setYPosition(this.paddle.getYPosition() - this.paddle.getSpeed());
        }
    }
    
    public void checkForMoveDownCommand(){
        if(this.listener.isKeyPressed(keyDown) && this.paddle.getYPosition() + this.paddle.getHeight() < WINDOW_HEIGHT){
            this.paddle.setYPosition(this.paddle.getYPosition() + this.paddle.getSpeed());
        }
    }
}
