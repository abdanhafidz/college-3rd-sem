package id.its.pbo.sorting;

public class SortingProgram {
    public static void main(String[] args) {
        // Membuat objek Buku dan Sepatu
        Buku buku1 = new Buku("Java Programming", 350);
        Buku buku2 = new Buku("Data Structures", 500);
        Sepatu sepatu1 = new Sepatu("Nike", 42);
        Sepatu sepatu2 = new Sepatu("Adidas", 40);

        // Array untuk pengurutan
        Sortable[] items = {buku1, buku2, sepatu1, sepatu2};

        // Mengurutkan items
        Sorter.sortItems(items);

        // Menampilkan hasil pengurutan
        System.out.println("Hasil Pengurutan:");
        for (Sortable item : items) {
            System.out.println(item);
        }
    }
}
