package id.its.pbo.sorting;

public abstract class Item {
    private String nama;

    public Item(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
}
