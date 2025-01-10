package id.its.pbo.keyboardevent;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

public class Key {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private static final int ARC_RADIUS = 20; // Radius untuk border melengkung
    private static final Font FONT = new Font("SansSerif", Font.BOLD, 36);
    private static final int MAX_SHAKE_OFFSET = 5; // Offset untuk efek getaran
    private static final int MAX_LOAD = 100;

    private int x;
    private int y;
    private char symbol;
    private Color color;
    private int shakeOffsetX;
    private int shakeOffsetY;
    private int loadProgress;
    private boolean isPressed;

    public Key(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.color = new Color(0, 153, 76); // Warna default hijau
        this.shakeOffsetX = 0;
        this.shakeOffsetY = 0;
        this.loadProgress = 0;
        this.isPressed = false;
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Menghitung posisi dengan efek getaran
        int renderX = this.x + shakeOffsetX;
        int renderY = this.y + shakeOffsetY;

        // Menggunakan gradien warna untuk latar belakang tuts
        GradientPaint gradient = new GradientPaint(
            renderX, renderY, this.color.brighter(),
            renderX + WIDTH, renderY + HEIGHT, this.color.darker()
        );
        g2d.setPaint(gradient);

        // Membuat tuts dengan sudut melengkung (border radius)
        RoundRectangle2D roundedRect = new RoundRectangle2D.Double(
            renderX, renderY, WIDTH, HEIGHT, ARC_RADIUS, ARC_RADIUS
        );
        g2d.fill(roundedRect);

        // Menambahkan border hitam pada tuts
        g2d.setColor(Color.BLACK);
        g2d.draw(roundedRect);

        // Render simbol pada tuts dengan font yang lebih besar
        g2d.setFont(FONT);
        FontMetrics fm = g2d.getFontMetrics();
        int stringPosX = renderX + (WIDTH - fm.stringWidth(String.valueOf(this.symbol))) / 2;
        int stringPosY = renderY + (HEIGHT - fm.getHeight()) / 2 + fm.getAscent();
        g2d.setColor(Color.WHITE);
        g2d.drawString(String.valueOf(this.symbol), stringPosX, stringPosY);

        // Render progress bar (load bar) di bagian bawah tuts
        g2d.setColor(Color.ORANGE);
        int loadBarWidth = (int) ((WIDTH - 10) * ((double) loadProgress / MAX_LOAD));
        g2d.fillRect(renderX + 5, renderY + HEIGHT - 15, loadBarWidth, 10);
    }

    public boolean isSymbolMatch(char symbol) {
        return this.symbol == symbol;
    }
    
    public void setPressed() {
        this.color = new Color(0, 102, 51); // Warna hijau lebih gelap saat ditekan
        this.isPressed = true;
        startShaking();
        increaseLoad();
    }
    
    public void setReleased() {
        this.color = new Color(0, 153, 76); // Kembali ke warna hijau default saat dilepas
        this.isPressed = false;
        stopShaking();
        resetLoad();
    }

    // Metode untuk memulai efek getaran
    private void startShaking() {
        Random random = new Random();
        this.shakeOffsetX = random.nextInt(MAX_SHAKE_OFFSET * 2) - MAX_SHAKE_OFFSET;
        this.shakeOffsetY = random.nextInt(MAX_SHAKE_OFFSET * 2) - MAX_SHAKE_OFFSET;
    }

    // Metode untuk menghentikan efek getaran
    private void stopShaking() {
        this.shakeOffsetX = 0;
        this.shakeOffsetY = 0;
    }

    // Metode untuk menambah progress load bar
    private void increaseLoad() {
        if (loadProgress < MAX_LOAD) {
            loadProgress += 20; // Bisa disesuaikan untuk kecepatan pengisian
        }
    }

    // Metode untuk mereset progress load bar
    private void resetLoad() {
        loadProgress = 0;
    }
}
