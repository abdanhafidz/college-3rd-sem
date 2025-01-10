[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/vgHXmWGs)
## Tutorial: Action Event Handling di Java

### Tujuan
Belajar menangani Action Event pada aplikasi berbasis GUI di Java menggunakan `ActionListener`.

### Lingkungan Pengembangan
- **Platform**: Java 11
- **IDE**: Eclipse
- **Project Type**: Maven

---

## Langkah-Langkah

### 1. Membuat Maven Java Project

1. Di Eclipse, buat Maven Project baru dengan nama **`oop-action-event-handling`**.
2. Buat package baru di dalam project tersebut dengan nama `id.its.pbo.actionevent`.

---

### 2. Membuat Kelas `UIPanel` yang Meng-extend `JPanel`

1. Di dalam package `id.its.pbo.actionevent`, buat kelas `UIPanel` yang meng-extend `JPanel`.
2. Tambahkan properti untuk menentukan ukuran panel dan komponen GUI yang akan ditampilkan.

**Kode Awal untuk `UIPanel.java`:**

```java
package id.its.pbo.actionevent;

import java.awt.Dimension;
import javax.swing.JPanel;

public class UIPanel extends JPanel {
    
    public UIPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
    }
}
```

**Penjelasan:**
- `UIPanel` adalah kelas dasar yang mengatur ukuran panel utama tempat komponen GUI lainnya akan ditempatkan.

---

### 3. Mengimplementasikan Interface `ActionListener` di Kelas `UIPanel`

1. Tambahkan `implements ActionListener` pada kelas `UIPanel`.
2. Tambahkan `JButton` ke panel, dan daftarkan event listener untuk menangani klik tombol.
3. Implementasikan metode `actionPerformed` untuk menangani aksi klik tombol.

**Kode Lengkap untuk `UIPanel.java`:**

```java
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
```

**Penjelasan:**
- `JButton` ditambahkan ke `UIPanel` dengan teks "Click Me!".
- `addActionListener(this)` menghubungkan tombol dengan `ActionListener` yang diimplementasikan oleh `UIPanel`.
- Metode `actionPerformed` akan dipanggil ketika tombol diklik, dan menampilkan pesan dialog.

---

### 4. Membuat Kelas `Program`

Kelas `Program` akan menjadi kelas utama yang menjalankan aplikasi dan menampilkan `UIPanel` di dalam `JFrame`.

1. Buat kelas `Program` di package `id.its.pbo.actionevent`.
2. Tambahkan metode `main` untuk menampilkan `UIPanel` di dalam `JFrame`.

**Kode untuk `Program.java`:**

```java
package id.its.pbo.actionevent;

import javax.swing.JFrame;

public class Program {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Simple Action Event");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new UIPanel(640, 480));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
```

**Penjelasan:**
- `Program` menjalankan aplikasi GUI, menampilkan `UIPanel` sebagai konten utama di dalam `JFrame`.
- `invokeLater` memastikan GUI dijalankan di thread yang tepat.

---

### 5. Menjalankan Aplikasi

1. Jalankan kelas `Program`.
2. Coba klik tombol "Click Me!" pada panel.
3. Akan muncul pesan dialog yang menampilkan pesan **"Anda telah mengaktifkan action event"**.
