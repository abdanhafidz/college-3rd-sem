package id.its.pbo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.Timer;
public class GamePanel extends JPanel implements ActionListener , KeyListener {
    private Star star;
    private Basket basket;
    private Timer gameTimer;
    private int score = 0;
    private SoundPlayer coinSound;
    public GamePanel() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        gameTimer = new Timer(20, e -> repaint());
        gameTimer.start();

        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);

        basket = new Basket(800, 600);
        add(basket.getComponent());

        star = new Star(800, 600);
        add(star.getComponent());

        gameTimer = new Timer(20, e -> repaint());
        gameTimer.start();
        addKeyListener(this);
        gameTimer = new Timer(20, this);
        gameTimer.start();
        
        coinSound = new SoundPlayer("coin.wav");
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void actionPerformed(ActionEvent e) {
        
        star.fall();
        if (star.isOutOfSky(getHeight())) {
            generateNewStar();
        }
        if (basket.isCollidedWith(star)) {
            score++;
            coinSound.play();
            generateNewStar();
        }
        repaint();
    }

    private void generateNewStar() {
        remove(star.getComponent());
        star = new Star(800, 600);
        add(star.getComponent());
    }
    @Override
     public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_LEFT) {
             basket.moveLeft();
         } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
             basket.moveRight(getWidth());
         }
     }
 @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setFont(new Font("Arial", Font.BOLD, 20));
    g.setColor(Color.BLACK);
    g.drawString("Score: " + score, 10, 20);
}

}

