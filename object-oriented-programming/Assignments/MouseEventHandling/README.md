[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/cdQ7UbL4)
## Tutorial: Mouse Event Handling di Java

### Tujuan
Belajar menangani Mouse Event pada aplikasi berbasis GUI di Java menggunakan `MouseListener`.

### Lingkungan Pengembangan
- **Platform**: Java 11
- **IDE**: Eclipse
- **Project Type**: Maven

---

## Penjelasan terkait Mouse Event

Pada aplikasi berbasis GUI (Graphical User Interface), event adalah perubahan status pada objek, misalnya ketika tombol diklik, mouse berpindah, atau tombol keyboard ditekan. Dalam penanganan event, terdapat tiga komponen utama:
1. **Event**: Perubahan state pada objek.
2. **Event source**: Objek yang menghasilkan event.
3. **Listener**: Objek yang menangani event ketika muncul. Listener akan diberi notifikasi saat event terjadi.

Berikut adalah beberapa contoh event di Java:

| Event        | Listener Interface | Deskripsi                                                   |
|--------------|--------------------|-------------------------------------------------------------|
| **MouseEvent** | MouseListener      | Terjadi saat mouse berpindah, di-drag, diklik, ditekan, dilepas, atau keluar dari area tertentu. |
| **KeyEvent**   | KeyListener        | Terjadi saat tombol keyboard di-tap, ditekan, atau dilepas. |
| **ActionEvent**| ActionListener     | Terjadi saat ada aksi pada komponen UI seperti button.     |

Pada tutorial ini, kita akan membahas penanganan MouseEvent.

---

## Langkah-Langkah

### 1. Membuat Kelas `MousePanel`

1. Di Eclipse, buat package bernama `id.its.pbo.mouseevent`.
2. Buat kelas `MousePanel` yang meng-extend `JPanel`.
3. Tambahkan label teks untuk memberi instruksi pada pengguna.

**Kode untuk `MousePanel.java`:**

```java
package id.its.pbo.mouseevent;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MousePanel extends JPanel {

    private int areaWidth;
    private int areaHeight;
    private String text;

    public MousePanel(int width, int height) {
        this.areaWidth = width;
        this.areaHeight = height;
        this.setPreferredSize(new Dimension(areaWidth, areaHeight));
        this.text = "Lakukan sesuatu menggunakan mouse...";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(this.text, 0, this.areaHeight / 2);
    }
}
```

**Penjelasan:**
- **`MousePanel`** adalah area tampilan GUI yang akan menangani MouseEvent pada langkah berikutnya.
- **Label teks** di tengah area memberi instruksi awal kepada pengguna.

### 2. Menjalankan `MousePanel`

1. Buat kelas `Program` di package yang sama (`id.its.pbo.mouseevent`).
2. Pada kelas `Program`, buat metode `main` yang menampilkan `MousePanel` dalam `JFrame`.

**Kode untuk `Program.java`:**

```java
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
```

**Penjelasan:**
- **`Program`** adalah kelas utama yang menjalankan aplikasi dan menampilkan `MousePanel` dalam `JFrame`.
- **`invokeLater`** memastikan GUI dibuat di thread Event Dispatch.

### 3. Mengimplementasikan `MouseListener` di `MousePanel`

1. Pada kelas `MousePanel`, tambahkan `implements MouseListener` setelah `extends JPanel`.
2. Tambahkan kode untuk setiap metode `MouseListener` seperti `mouseClicked`, `mousePressed`, `mouseReleased`, `mouseEntered`, dan `mouseExited`.
3. Setiap metode memperbarui teks status dan memanggil `repaint()` agar tampilannya diperbarui.

**Perbarui kode `MousePanel.java`:**

```java
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MousePanel extends JPanel implements MouseListener {

    public MousePanel(int width, int height) {
        this.areaWidth = width;
        this.areaHeight = height;
        this.setPreferredSize(new Dimension(areaWidth, areaHeight));
        this.text = "Lakukan sesuatu menggunakan mouse...";
        
        this.addMouseListener(this);
        this.setFocusable(true);
    }

    public void mouseClicked(MouseEvent e) {
        this.text = "Tombol mouse diklik pada posisi X: " + e.getX() + " Y: " + e.getY();
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        this.text = "Tombol mouse ditekan pada posisi X: " + e.getX() + " Y: " + e.getY();
        repaint();
    }

    public void mouseReleased(MouseEvent e) {
        this.text = "Tombol mouse dilepas pada posisi X: " + e.getX() + " Y: " + e.getY();
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
        this.text = "Mouse memasuki area MousePanel";
        repaint();
    }

    public void mouseExited(MouseEvent e) {
        this.text = "Mouse meninggalkan area MousePanel";
        repaint();
    }
}
```

**Penjelasan:**
- Metode seperti `mouseClicked`, `mousePressed`, dll., menangani berbagai aksi mouse dan memperbarui teks di panel sesuai dengan event yang terjadi.

### 4. Melakukan Uji Coba MouseEvent

1. Jalankan kelas `Program`.
2. Lakukan berbagai interaksi mouse, seperti mengklik, menekan, dan melepaskan tombol mouse di area panel.
3. Perhatikan perubahan teks yang ditampilkan di panel sesuai dengan aksi yang dilakukan.