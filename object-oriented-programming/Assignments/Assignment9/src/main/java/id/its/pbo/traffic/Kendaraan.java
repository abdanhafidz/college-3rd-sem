package id.its.pbo.traffic;

public class Kendaraan implements Runnable {
    private String nama;
    private int waktuMelintas;
    private Persimpangan persimpangan;

    public Kendaraan(String nama, int waktuMelintas, Persimpangan persimpangan) {
        this.nama = nama;
        this.waktuMelintas = waktuMelintas;
        this.persimpangan = persimpangan;
    }

    @Override
    public void run() {
        persimpangan.melintasiPersimpangan(this);
    }

    public String getNama() {
        return nama;
    }

    public int getWaktuMelintas() {
        return waktuMelintas;
    }
}
