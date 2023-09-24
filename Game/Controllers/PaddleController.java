package Game.Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PaddleController {
    private KeyListener Listener;

    public void PaddleControll(KeyListener Listener) {
        this.Listener = Listener;
    }

    public void Update(KeyEvent Key) {
        if (Key.getKeyCode() == Key.VK_ENTER) {
            System.out.println("NADA");
        }
    }
}
