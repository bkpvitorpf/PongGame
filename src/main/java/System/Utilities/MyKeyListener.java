package System.Utilities;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    // Cria um vetor de keys com todas as 128 keys da tabela ASCII
    private boolean keys[] = new boolean[128];

    /*
     * Quando uma tecla é pressionada, a posição correspondente a essa tecla
     * no array de keys tem seu valor alterado para true. Exemplo: Se 'a'
     * for a posição 0 de keys, na hora que 'a' for pressionada
     * key[0] = true.
     */
    @Override
    public void keyPressed(KeyEvent event) {
        this.keys[event.getKeyCode()] = true;
    }

    /*
     * Quando uma tecla é solta, a posição correspondente a essa tecla
     * no array de keys tem seu valor alterado para true. Exemplo: Se 'a'
     * for a posição 0 de keys, na hora que 'a' for solta
     * key[0] = false.
     */
    @Override
    public void keyReleased(KeyEvent event) {
        this.keys[event.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent event) {
    }

    /*
     * Retorna o valor armazenado na posição correspondente à tecla que foi
     * pressionada.
     */
    public boolean isKeyPressed(int keyCode) {
        return this.keys[keyCode];
    }
}
