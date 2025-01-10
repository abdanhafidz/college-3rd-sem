package id.its.pbo.sorting;

public class Makanan extends Item {
    public Makanan(String nama) {
        super(nama);
    }

    @Override
    public String toString() {
        return "Makanan: " + getNama();
    }
}
