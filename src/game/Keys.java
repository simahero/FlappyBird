package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            Driver.b.vel = 11;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}