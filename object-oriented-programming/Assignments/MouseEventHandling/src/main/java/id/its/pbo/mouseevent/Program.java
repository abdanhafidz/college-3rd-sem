package id.its.pbo.mouseevent;

import javax.swing.JFrame;

public class Program {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("SimpleMouseEvent");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new MousePanel(640, 480));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}