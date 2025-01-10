package id.its.pbo.sorting;

public class Buku extends Item implements Sortable {
    private int jumlahHalaman;

    public Buku(String nama, int jumlahHalaman) {
        super(nama);
        this.jumlahHalaman = jumlahHalaman;
    }

    public int getJumlahHalaman() {
        return jumlahHalaman;
    }

    @Override
    public int compare(Sortable other) {
        if (other instanceof Buku) {
            Buku bukuLain = (Buku) other;
            return Integer.compare(this.jumlahHalaman, bukuLain.getJumlahHalaman());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Buku: " + getNama() + ", Jumlah Halaman: " + jumlahHalaman;
    }
}
