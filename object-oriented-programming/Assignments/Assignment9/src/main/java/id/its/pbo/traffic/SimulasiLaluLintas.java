package id.its.pbo.traffic;

import java.util.ArrayList;
import java.util.List;

public class SimulasiLaluLintas {
    private List<Thread> daftarKendaraan = new ArrayList<>();

    public void tambahKendaraan(Kendaraan kendaraan) {
        daftarKendaraan.add(new Thread(kendaraan));
    }

    public void mulaiSimulasi() {
        for (Thread thread : daftarKendaraan) {
            thread.start();
        }
        for (Thread thread : daftarKendaraan) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Thread kendaraan terganggu saat menunggu.");
            }
        }
    }
}
