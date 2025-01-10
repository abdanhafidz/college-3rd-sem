package id.its.pbo.mouseevent;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class MousePanel extends JPanel implements MouseListener, MouseMotionListener {

    private int areaWidth;
    private int areaHeight;
    private String text;

    public MousePanel(int width, int height) {
        this.areaWidth = width;
        this.areaHeight = height;
        this.setPreferredSize(new Dimension(areaWidth, areaHeight));
        this.text = "Lakukan sesuatu menggunakan mouse...";
        
        // Tambahkan listener untuk event mouse
        this.addMouseListener(this);
        this.addMouseMotionListener(this); // Untuk menangani mouse hover
        this.setFocusable(true);
    }

    // Event saat mouse diklik
    public void mouseClicked(MouseEvent e) {
        this.text = "Tombol mouse diklik pada posisi X: " + e.getX() + " Y: " + e.getY();
        repaint();
    }

    // Event saat tombol mouse ditekan
    public void mousePressed(MouseEvent e) {
        this.text = "Tombol mouse ditekan pada posisi X: " + e.getX() + " Y: " + e.getY();
        repaint();
    }

    // Event saat tombol mouse dilepas
    public void mouseReleased(MouseEvent e) {
        this.text = "Tombol mouse dilepas pada posisi X: " + e.getX() + " Y: " + e.getY();
        repaint();
    }

    // Event saat mouse memasuki area panel
    public void mouseEntered(MouseEvent e) {
        this.text = "Mouse memasuki area MousePanel";
        repaint();
    }

    // Event saat mouse meninggalkan area panel
    public void mouseExited(MouseEvent e) {
        this.text = "Mouse meninggalkan area MousePanel";
        repaint();
    }

    // Event saat mouse digerakkan (mouse hover)
    @Override
    public void mouseMoved(MouseEvent e) {
        this.text = "Mouse hover pada posisi X: " + e.getX() + " Y: " + e.getY();
        repaint();
    }

    // Event saat mouse diseret (dragged)
    @Override
    public void mouseDragged(MouseEvent e) {
        this.text = "Mouse diseret pada posisi X: " + e.getX() + " Y: " + e.getY();
        repaint();
    }

    // Menggambar teks pada panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(this.text, 10, this.areaHeight / 2);
    }
}
