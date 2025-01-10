[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/N0en9Skb)
## Tutorial: Keyboard Event Handling di Java

### Tujuan
Belajar menangani Keyboard Event pada aplikasi berbasis GUI di Java menggunakan `KeyListener`.

### Lingkungan Pengembangan
- **Platform**: Java 11
- **IDE**: Eclipse
- **Project Type**: Maven

---

## Langkah-Langkah

### 1. Membuat Maven Java Project

1. Di Eclipse, buat Maven Project baru dan beri nama **`oop-keyboard-event-handling`**.
2. Pada struktur proyek, buat package baru bernama `id.its.pbo.keyboardevent`.

---

### 2. Membuat Kelas `Key` untuk Tuts Keyboard

Kelas `Key` akan merepresentasikan tuts keyboard di layar, dengan properti seperti posisi, ukuran, warna, dan simbol yang akan ditampilkan.

1. Di dalam package `id.its.pbo.keyboardevent`, buat kelas `Key`.
2. Tambahkan variabel instance untuk posisi `(x, y)`, ukuran, warna default (biru), dan simbol yang diwakili oleh tuts.
3. Buat konstruktor `Key` untuk menginisialisasi variabel-variabel tersebut.

**Kode untuk `Key.java` (Langkah awal):**

```java
package id.its.pbo.keyboardevent;

import java.awt.Color;
import java.awt.Graphics;

public class Key {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private int x;
    private int y;
    private char symbol;
    private Color color;

    public Key(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.color = Color.BLUE; // Warna default biru
    }

    public void render(Graphics g) {
        // Render tuts sesuai dengan warna saat ini
        g.setColor(this.color);
        g.fillRect(this.x, this.y, WIDTH, HEIGHT);

        // Render simbol pada tuts
        int stringPosX = this.x + (WIDTH / 3);
        int stringPosY = this.y + (HEIGHT / 2);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(this.symbol), stringPosX, stringPosY);
    }
}
```

**Penjelasan:**
- `Key` memiliki posisi `(x, y)`, ukuran, simbol, dan warna awal (biru).
- Metode `render` menampilkan tuts di layar sesuai dengan warna dan simbolnya.

---

### 3. Menambahkan Metode `isSymbolMatch`, `setPressed`, dan `setReleased`

1. Pada kelas `Key`, tambahkan metode `isSymbolMatch` untuk memeriksa apakah karakter input cocok dengan simbol yang diwakili oleh tuts.
2. Tambahkan juga metode `setPressed` dan `setReleased` untuk mengubah warna tuts sesuai dengan state (merah saat ditekan dan biru saat dilepas).

**Perbarui kode `Key.java`:**

```java
public boolean isSymbolMatch(char symbol) {
    return this.symbol == symbol;
}

public void setPressed() {
    this.color = Color.RED; // Ubah warna ke merah saat ditekan
}

public void setReleased() {
    this.color = Color.BLUE; // Kembali ke warna biru saat dilepas
}
```

**Penjelasan:**
- `isSymbolMatch` memeriksa apakah simbol yang diwakili oleh `Key` sama dengan input karakter.
- `setPressed` dan `setReleased` mengubah warna tuts sesuai dengan aksi yang terjadi (tekan atau lepas).

---

### 4. Membuat Kelas `KeyboardPanel`

Kelas `KeyboardPanel` adalah `JPanel` yang akan menampilkan beberapa objek `Key` dan menangani event keyboard.

1. Buat kelas `KeyboardPanel` yang meng-extend `JPanel` dan mengimplementasikan `KeyListener`.
2. Buat list untuk menyimpan beberapa objek `Key`.
3. Implementasikan metode `keyPressed`, `keyReleased`, dan biarkan `keyTyped` kosong.

**Kode untuk `KeyboardPanel.java`:**

```java
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
        this.keys.add(new Key(10, 10, 'a'));
        this.keys.add(new Key(120, 10, 'w'));
        this.keys.add(new Key(230, 10, 's'));
        this.keys.add(new Key(340, 10, 'd'));

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
```

**Penjelasan:**
- `KeyboardPanel` berisi list `keys` yang merepresentasikan tuts keyboard di layar.
- `keyPressed` dan `keyReleased` menangani perubahan warna `Key` sesuai dengan event keyboard.
- `repaint()` memicu pemanggilan ulang `paintComponent` agar tampilan diperbarui.

---

### 5. Membuat Kelas `Program`

Kelas `Program` adalah kelas utama yang menjalankan aplikasi dengan menampilkan `KeyboardPanel` dalam `JFrame`.

1. Buat kelas `Program` di package yang sama (`id.its.pbo.keyboardevent`).
2. Tambahkan metode `main` untuk menampilkan aplikasi GUI.

**Kode untuk `Program.java`:**

```java
package id.its.pbo.keyboardevent;

import javax.swing.JFrame;

public class Program {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Simple Keyboard Event");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new KeyboardPanel(640, 480));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
```

**Penjelasan:**
- **`Program`** menjalankan aplikasi GUI, menampilkan `KeyboardPanel` sebagai konten utama di dalam `JFrame`.
- **`invokeLater`** memastikan GUI dijalankan di thread yang tepat.

---

### 6. Menjalankan Aplikasi

1. Jalankan kelas `Program`.
2. Coba tekan tombol **A**, **W**, **S**, atau **D** pada keyboard.
3. Amati bahwa tuts yang sesuai di layar berubah warna menjadi merah saat ditekan dan kembali ke biru saat dilepas.

---

### 7. Tugas Tambahan

Sebagai latihan tambahan:
- Tambahkan lebih banyak tombol pada layar, misalnya tombol huruf lainnya.
- Sesuaikan desain atau ukuran `Key` untuk tampilan yang lebih menarik.