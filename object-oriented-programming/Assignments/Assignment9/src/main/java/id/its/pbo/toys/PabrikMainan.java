package id.its.pbo.toys;

import java.util.ArrayList;
import java.util.List;

public class PabrikMainan {
    private List<Thread> daftarMesinThread = new ArrayList<>();
    private List<Mesin> daftarMesin = new ArrayList<>();

    public void tambahMesin(Mesin mesin) {
        daftarMesin.add(mesin);
        daftarMesinThread.add(new Thread(mesin));
    }

    public void mulaiProduksi() {
        for (Thread threadMesin : daftarMesinThread) {
            threadMesin.start();
        }
    }

    public int getJumlahTotalProduksi() {
        int totalProduksi = 0;
        for (Thread threadMesin : daftarMesinThread) {
            try {
                threadMesin.join();
            } catch (InterruptedException e) {
                System.out.println("Thread mesin terganggu saat menunggu.");
            }
        }
        for (Mesin mesin : daftarMesin) {
            totalProduksi += mesin.getJumlahProduksi();
        }
        return totalProduksi;
    }
}
