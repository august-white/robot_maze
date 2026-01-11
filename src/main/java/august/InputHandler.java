package august;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    public boolean forward, backward, left, right;

    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case (KeyEvent.VK_W) -> forward = true;
            case (KeyEvent.VK_A) -> left = true;
            case (KeyEvent.VK_S) -> backward = true;
            case (KeyEvent.VK_D) -> right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        switch (e.getKeyCode()){
            case (KeyEvent.VK_W) -> forward = false;
            case (KeyEvent.VK_A) -> left = false;
            case (KeyEvent.VK_S) -> backward = false;
            case (KeyEvent.VK_D) -> right = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
