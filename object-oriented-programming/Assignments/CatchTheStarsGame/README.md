[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/telXt_vR)
### **Tutorial: Membuat Game "Catch the Stars" Menggunakan Java**

---

## **Tujuan**
Tutorial ini akan memandu Anda membuat game **"Catch the Stars"** menggunakan Java. Dalam game ini, pemain mengontrol sebuah keranjang untuk menangkap bintang yang jatuh. Fitur game:
- **Bintang jatuh terus-menerus**.
- **Keranjang bergerak ke kiri/kanan** menggunakan tombol panah.
- **Skor bertambah** setiap kali bintang ditangkap.
- **Suara efek** dimainkan saat bintang ditangkap.
- Bintang akan **diganti dengan yang baru** jika tertangkap atau keluar dari layar.

---

## **Lingkungan Pengembangan**
- **Platform**: Java 11
- **IDE**: Eclipse
- **Project Type**: Maven

---

## **Struktur Folder**
```
src/
  main/
    java/
      id/its/pbo/
        Main.java
        GamePanel.java
        Basket.java
        Star.java
        SoundPlayer.java
    resources/
      basket.png
      star.png
      coin.wav
```

---

## **Langkah-Langkah**

### **1. Menambahkan Aset ke Aplikasi Game Menggunakan Resources Folder**

1. Buat folder `resources` di dalam `src/main`.
2. Tambahkan file berikut ke folder `resources`:
   - **basket.png**: Gambar keranjang.
   - **star.png**: Gambar bintang.
   - **coin.wav**: Suara efek untuk bintang yang ditangkap.

**Coba Jalankan Aplikasi**
- Pastikan file resource sudah ditambahkan. Kita akan memanfaatkannya dalam langkah berikutnya.

---

### **2. Membuat Kelas GamePanel**

**Langkah:**
1. Buat file `GamePanel.java` di `src/main/java/id/its/pbo`.
2. Tambahkan kode berikut:

```java
package id.its.pbo;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
    }
}
```

**Coba Jalankan Aplikasi**
1. Tambahkan kode berikut di `Main.java` untuk menampilkan `GamePanel`:

```java
package id.its.pbo;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Catch the Stars");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.add(new GamePanel());
            frame.setVisible(true);
        });
    }
}
```

2. Jalankan aplikasi untuk melihat jendela abu-abu kosong.

---

### **3. Membuat Kelas Basket**

**Langkah:**
1. Buat file `Basket.java` di `src/main/java/id/its/pbo`.
2. Tambahkan kode berikut:

```java
package id.its.pbo;

import javax.swing.*;
import java.awt.*;

public class Basket {
    private JLabel basketLabel;

    public Basket(int screenWidth, int screenHeight) {
        basketLabel = new JLabel();
        basketLabel.setBounds(screenWidth / 2 - 60, screenHeight - 80, 120, 40);
        basketLabel.setIcon(loadIcon("basket.png", basketLabel.getWidth(), basketLabel.getHeight()));
    }

    public JLabel getComponent() {
        return basketLabel;
    }

    public void moveLeft() {
        basketLabel.setLocation(basketLabel.getX() - 15, basketLabel.getY());
    }

    public void moveRight(int screenWidth) {
        basketLabel.setLocation(basketLabel.getX() + 15, basketLabel.getY());
    }

    private ImageIcon loadIcon(String fileName, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/" + fileName));
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
```

**Coba Jalankan Aplikasi**
1. Tambahkan keranjang ke `GamePanel`:

```java
private Basket basket;

public GamePanel() {
    setFocusable(true);
    setBackground(Color.LIGHT_GRAY);
    setLayout(null);

    basket = new Basket(800, 600);
    add(basket.getComponent());
}
```

2. Jalankan aplikasi untuk melihat keranjang di layar.

---

### **4. Membuat Kelas Star**

**Langkah:**
1. Buat file `Star.java`.
2. Tambahkan kode berikut:

```java
package id.its.pbo;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Star {
    private JLabel starLabel;

    public Star(int screenWidth, int screenHeight) {
        starLabel = new JLabel();
        starLabel.setBounds(new Random().nextInt(screenWidth - 40), 0, 40, 40);
        starLabel.setIcon(loadIcon("star.png", starLabel.getWidth(), starLabel.getHeight()));
    }

    public JLabel getComponent() {
        return starLabel;
    }

    public void fall() {
        starLabel.setLocation(starLabel.getX(), starLabel.getY() + 5);
    }

    public boolean isOutOfSky(int screenHeight) {
        return starLabel.getY() > screenHeight;
    }

    private ImageIcon loadIcon(String fileName, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource("/" + fileName));
        Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}
```

**Coba Jalankan Aplikasi**
1. Tambahkan bintang ke `GamePanel`:

```java
private Star star;

public GamePanel() {
    setFocusable(true);
    setBackground(Color.LIGHT_GRAY);
    setLayout(null);

    basket = new Basket(800, 600);
    add(basket.getComponent());

    star = new Star(800, 600);
    add(star.getComponent());
}
```

2. Jalankan aplikasi untuk melihat keranjang dan bintang.

---

### **5. Mengimplementasi GameTimer**

1. Tambahkan atribut `Timer` di `GamePanel`:
   ```java
   private Timer gameTimer;
   ```
2. Inisialisasi `Timer` di konstruktor:
   ```java
   gameTimer = new Timer(20, e -> repaint());
   gameTimer.start();
   ```

**Coba Jalankan Aplikasi**
1. Jalankan aplikasi untuk memastikan timer berjalan tanpa error.

---

### **6. Membuat Gerakan Star Jatuh**

1. Implementasikan interface `ActionListener` di `GamePanel`. Kemudian buat metode handler `actionPerformed` dan sambungkan dengan `gameTimer`. Metode `generateNewStar` dipanggil ketika `star` sudah melewati area window.

    ```java
    public class GamePanel extends JPanel implements ActionListener {
        public GamePanel() {
        
            // kode sebelumnya...

            gameTimer = new Timer(20, this);
            gameTimer.start();

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            star.fall();
            if (star.isOutOfSky(getHeight())) {
                generateNewStar();
            }

            repaint();
        }

        private void generateNewStar() {
            remove(star.getComponent());
            star = new Star(800, 600);
            add(star.getComponent());
        }
    }
    ```

**Coba Jalankan Aplikasi**
1. Jalankan aplikasi untuk melihat bintang jatuh.

---

### **7. Membuat Gerakan Kanan Kiri Basket**

1. Implementasikan interface `KeyListener` di `GamePanel`

   ```java
   public class GamePanel extends JPanel implements ActionListener, KeyListener {

        //kode sebelumnya...

        public GamePanel() {
            
            //kode sebelumnya...

            addKeyListener(this);
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
        public void keyReleased(KeyEvent e) {}

        @Override
        public void keyTyped(KeyEvent e) {}

   }
   ```

**Coba Jalankan Aplikasi**
1. Jalankan aplikasi dan gerakkan keranjang dengan tombol panah.

---

### **8. Mendeteksi Tabrakan dan Mengupdate Skor**

1. Tambahkan atribut skor di kelas `GamePanel`:
   ```java
   private int score = 0;
   ```
2. Tambahkan metode `isCollidedWith` di kelas `Basket`:
   ```java
   public boolean isCollidedWith(Star star) {
       return basketLabel.getBounds().intersects(star.getComponent().getBounds());
   }
   ```
3. Tambahkan mekanisme increment skor di method `actionPerformed` di kelas `GamePanel`:
   ```java
   @Override
    public void actionPerformed(ActionEvent e) {
        star.fall();
        if (star.isOutOfSky(getHeight())) {
            generateNewStar();
        }

        if (basket.isCollidedWith(star)) {
            score++;
            generateNewStar();
        }

        repaint();
    }
   ```

4. Tampilkan skor di metode `paintComponent`:
   ```java
   @Override
   protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       g.setFont(new Font("Arial", Font.BOLD, 20));
       g.setColor(Color.BLACK);
       g.drawString("Score: " + score, 10, 20);
   }
   ```

---

### **9. Membunyikan Suara Ketika Tabrakan**

1. Buat file `SoundPlayer.java` dan tambahkan kode berikut:

```java
package id.its.pbo;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class SoundPlayer {
    private Clip clip;

    public SoundPlayer(String soundFileName) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        URL soundFile = getClass().getResource("/" + soundFileName);
        if (soundFile == null) {
            throw new IOException("Sound file not found: " + soundFileName);
        }
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
        clip = AudioSystem.getClip();
        clip.open(audioStream);
    }

    public void play() {
        if (clip != null) {
            clip.stop();
            clip.setFramePosition(0);
            clip.start();
        }
    }
}
```

2. Tambahkan atribut `coinSound` di kelas `GamePanel`.

```java
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    
    // kode sebelumnya...

    private SoundPlayer coinSound;

    public GamePanel() {
        // kode sebelumnya...

        coinSound = new SoundPlayer("coin.wav");
    }

}
```

3. Mainkan suara ketika terjadi tabrakan di kelas `GamePanel`:
   ```java
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
   ```

---

### **10. Menjalankan Aplikasi**

Jalankan `Main.java` untuk mencoba game lengkap dengan **gambar**, **gerakan**, dan **suara**. 🎮