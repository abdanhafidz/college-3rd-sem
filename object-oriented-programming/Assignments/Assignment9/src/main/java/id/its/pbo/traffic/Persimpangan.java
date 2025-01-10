package id.its.pbo.traffic;

public class Persimpangan {
    private final Object lock = new Object();

    public void melintasiPersimpangan(Kendaraan kendaraan) {
        synchronized (lock) {
            System.out.println(kendaraan.getNama() + " melintas persimpangan...");
            try {
                Thread.sleep(kendaraan.getWaktuMelintas());
            } catch (InterruptedException e) {
                System.out.println(kendaraan.getNama() + " terganggu saat melintas.");
            }
            System.out.println(kendaraan.getNama() + " telah melintas.");
        }
    }
}
