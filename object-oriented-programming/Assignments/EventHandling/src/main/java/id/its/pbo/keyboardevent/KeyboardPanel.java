package id.its.pbo.keyboardevent;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class KeyboardPanel extends JPanel implements KeyListener {

    private List<Key> keys;

    public KeyboardPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.keys = new ArrayList<Key>();
        this.keys.add(new Key(10, 10, 'w'));
        this.keys.add(new Key(120, 10, 'a'));
        this.keys.add(new Key(230, 10, 's'));
        this.keys.add(new Key(340, 10, 'd'));
        this.keys.add(new Key(450, 10, 'f'));
        this.keys.add(new Key(560, 10, 'g'));

        this.keys.add(new Key(10, 210, 'z'));
        this.keys.add(new Key(120, 210, 'x'));
        this.keys.add(new Key(230, 210, 'c'));
        this.keys.add(new Key(340, 210, 'v'));
        this.keys.add(new Key(450, 210, 'b'));
        this.keys.add(new Key(560, 210, 'n'));
        this.addKeyListener(this);
        this.setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Render seluruh keys
        for (Key key : this.keys) {
            key.render(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Kosongkan metode ini
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();
        for (Key k : this.keys) {
            if (k.isSymbolMatch(key)) {
                k.setPressed();
                repaint();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key = e.getKeyChar();
        for (Key k : this.keys) {
            if (k.isSymbolMatch(key)) {
                k.setReleased();
                repaint();
            }
        }
    }
}