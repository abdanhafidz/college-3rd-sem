package id.its.pbo.sorting;

public class Sepatu extends Item implements Sortable {
    private int ukuran;

    public Sepatu(String nama, int ukuran) {
        super(nama);
        this.ukuran = ukuran;
    }

    public int getUkuran() {
        return ukuran;
    }

    @Override
    public int compare(Sortable other) {
        if (other instanceof Sepatu) {
            Sepatu sepatuLain = (Sepatu) other;
            return Integer.compare(this.ukuran, sepatuLain.getUkuran());
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Sepatu: " + getNama() + ", Ukuran: " + ukuran;
    }
}
