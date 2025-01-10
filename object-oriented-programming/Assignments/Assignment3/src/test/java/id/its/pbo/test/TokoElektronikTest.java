package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import id.its.pbo.electronics.Produk;
import id.its.pbo.electronics.ItemBelanja;
import id.its.pbo.electronics.KeranjangBelanja;

class TokoElektronikTest {

    @Test
    @DisplayName("Dapat mengambil nilai instance variable Produk menggunakan getter")
    public void testProdukGetter() {
        Produk produk = new Produk("Laptop", 10000.0);
        assertEquals("Laptop", produk.getNama());
        assertEquals(10000.0, produk.getHarga());
    }

    @Test
    @DisplayName("Dapat menghitung total harga di ItemBelanja")
    public void testItemBelanjaTotal() {
        Produk produk = new Produk("Laptop", 10000.0);
        ItemBelanja item = new ItemBelanja(produk, 2);
        assertEquals(20000.0, item.hitungTotal());
    }

    @Test
    @DisplayName("Dapat menghitung total belanja di KeranjangBelanja")
    public void testKeranjangBelanjaTotal() {
        KeranjangBelanja keranjang = new KeranjangBelanja();
        keranjang.tambahProduk(new Produk("Laptop", 10000.0), 2);
        keranjang.tambahProduk(new Produk("Mouse", 100.0), 5);
        assertEquals(20500.0, keranjang.hitungTotalBelanja());
    }
}
