[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/yR6kCNgW)
## Tutorial: Keyboard dan Timer Event Handling

### Tujuan
Belajar menangani event keyboard pada aplikasi berbasis GUI di Java Swing. Aplikasi ini akan menampilkan kotak (`Box`) yang bisa bergerak dan berubah warna berdasarkan input keyboard (panah atas, bawah, kiri, kanan, dan spasi untuk mengubah warna).

### Lingkungan Pengembangan
- **Platform**: Java 11
- **IDE**: Eclipse
- **Project Type**: Maven

### Struktur Proyek

Proyek ini terdiri dari tiga kelas:
1. **Box**: Menangani tampilan dan logika pergerakan `Box`.
2. **MainPanel**: Panel utama yang menangani event keyboard dan mengatur `Box`.
3. **Program**: Kelas utama yang menjalankan aplikasi.

---

## Langkah-langkah

### 1. Membuat Kelas `Box`

Kelas `Box` akan mengenkapsulasi logika pergerakan dan perubahan warna. Kelas ini memiliki metode untuk menggerakkan `Box` ke atas, bawah, kiri, dan kanan, serta mengubah warna secara acak.

**Kode untuk `Box.java`:**

```java
package id.its.pbo.keyboardevent;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Box {
    private int x, y;
    private int size;
    private int moveSpeed;
    private Color color;

    public Box(int x, int y, int size, int moveSpeed, Color initialColor) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.moveSpeed = moveSpeed;
        this.color = initialColor;
    }

    public void moveUp() {
        y = Math.max(0, y - moveSpeed);
    }

    public void moveDown(int maxHeight) {
        y = Math.min(maxHeight - size, y + moveSpeed);
    }

    public void moveLeft() {
        x = Math.max(0, x - moveSpeed);
    }

    public void moveRight(int maxWidth) {
        x = Math.min(maxWidth - size, x + moveSpeed);
    }

    public void changeColor() {
        Random random = new Random();
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}
```

- **Penjelasan**:
  - `moveUp`, `moveDown`, `moveLeft`, dan `moveRight`: Menggerakkan `Box` ke arah yang ditentukan.
  - `changeColor`: Mengubah warna `Box` secara acak.
  - `draw`: Menampilkan `Box` di layar.

---

### 2. Membuat Kelas `MainPanel`

Kelas `MainPanel` adalah panel utama yang menampung objek `Box` dan menangani event keyboard. Pada langkah ini, kita akan membuat `MainPanel` dengan timer untuk memperbarui posisi `Box` secara periodik.

#### Langkah A: Membuat `MainPanel` dan Timer

1. Buat kelas `MainPanel` dan tambahkan properti untuk `Box`, ukuran panel, dan variabel `moveSpeed`.
2. Atur ukuran panel dan tambahkan timer untuk memperbarui posisi `Box`.

**Kode Awal untuk `MainPanel.java`:**

```java
package id.its.pbo.keyboardevent;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
    private Box box;
    private int moveSpeed = 10;
    private Dimension panelSize;

    public MainPanel(int width, int height) {
        this.panelSize = new Dimension(width, height);
        this.setPreferredSize(panelSize);
        this.setBackground(Color.WHITE);

        // Inisialisasi Box
        box = new Box(175, 175, 50, moveSpeed, Color.BLUE);

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
        // Logika gerakan akan ditambahkan di langkah berikutnya
    }
}
```

**Penjelasan:**
- `MainPanel` mengatur ukuran panel dan background.
- Timer memperbarui posisi `Box` secara periodik setiap 20ms dengan memanggil `updatePosition` dan `repaint`.

#### Langkah B: Mengimplementasikan `KeyListener` di `MainPanel`

1. Pada `MainPanel`, tambahkan `implements KeyListener` dan variabel boolean untuk setiap arah gerakan.
2. Implementasikan metode `keyPressed`, `keyReleased`, dan `keyTyped`.
3. Perbarui metode `updatePosition` untuk menggerakkan `Box` sesuai tombol yang ditekan.

**Perbarui kode `MainPanel.java`:**

```java
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainPanel extends JPanel implements KeyListener {
    private boolean goLeft, goRight, goUp, goDown, changeColor;

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
```

- **Penjelasan**:
  - Variabel boolean (`goLeft`, `goRight`, dll.) mengontrol arah gerakan `Box`.
  - `keyPressed` dan `keyReleased` mengatur nilai boolean untuk arah dan warna sesuai tombol yang ditekan atau dilepaskan.
  - `updatePosition`: Memanggil metode gerakan `Box` berdasarkan variabel boolean.

---

### 3. Membuat Kelas `Program`

Kelas `Program` adalah entry point untuk menjalankan aplikasi.

**Kode untuk `Program.java`:**

```java
package id.its.pbo.keyboardevent;

import javax.swing.JFrame;

public class Program {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Keyboard Event Handling");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new MainPanel(400, 400));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
```

---

### 4. Menjalankan Aplikasi

1. Jalankan kelas `Program`.
2. **Uji Program**:
   - **Tekan tombol panah atau WASD**: `Box` akan bergerak sesuai arah yang ditekan.
   - **Tekan tombol spasi**: `Box` akan berubah warna secara acak.