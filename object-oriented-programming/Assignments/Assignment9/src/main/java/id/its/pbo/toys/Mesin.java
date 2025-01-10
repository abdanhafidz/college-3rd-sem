package id.its.pbo.toys;

public class Mesin implements Runnable {
    private String namaMesin;
    private int waktuProduksi;
    private int jumlahProduksi = 0;
    private int targetProduksi;

    public Mesin(String namaMesin, int waktuProduksi, int targetProduksi) {
        this.namaMesin = namaMesin;
        this.waktuProduksi = waktuProduksi;
        this.targetProduksi = targetProduksi;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < targetProduksi; i++) {
                Thread.sleep(waktuProduksi);
                jumlahProduksi++;
                System.out.println(namaMesin + " telah memproduksi " + jumlahProduksi + " mainan.");
            }
        } catch (InterruptedException e) {
            System.out.println(namaMesin + " terganggu saat produksi.");
        }
    }

    public int getJumlahProduksi() {
        return jumlahProduksi;
    }
}
