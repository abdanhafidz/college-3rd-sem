package id.its.pbo.actionevent;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class UIPanel extends JPanel implements ActionListener {
    
    public UIPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        
        // Buat button dan tambahkan ke panel
        JButton button = new JButton("Click Me!");
        this.add(button);
        
        // Bind event action pada button
        button.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Tampilkan pesan dialog ketika tombol diklik
        JOptionPane.showMessageDialog(this, "Anda telah mengaktifkan action event");
    }
}