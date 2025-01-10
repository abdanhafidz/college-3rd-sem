package id.its.pbo.keyboardevent;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainPanel extends JPanel implements KeyListener {
    private boolean goLeft, goRight, goUp, goDown, changeColor;
    private Box box;
    private int moveSpeed = 10;
    private Dimension panelSize;

    public MainPanel(int width, int height) {
        this.panelSize = new Dimension(width, height);
        this.setPreferredSize(panelSize);
        this.setBackground(Color.WHITE);

        // Inisialisasi Box
        box = new Box(175, 175, 50, moveSpeed, Color.BLUE);

        // Tambahkan KeyListener ke panel
        this.addKeyListener(this);
        this.setFocusable(true);

        // Timer untuk memperbarui posisi kotak
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePosition();
                repaint();
            }
        });
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        box.draw(g);
    }
    
    private void updatePosition() {
        if (goLeft) box.moveLeft();
        if (goRight) box.moveRight(panelSize.width);
        if (goUp) box.moveUp();
        if (goDown) box.moveDown(panelSize.height);
        if (changeColor) box.changeColor();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                goLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                goRight = true;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                goUp = true;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                goDown = true;
                break;
            case KeyEvent.VK_SPACE:
                changeColor = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                goLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                goRight = false;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                goUp = false;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                goDown = false;
                break;
            case KeyEvent.VK_SPACE:
                changeColor = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Tidak digunakan
    }
}