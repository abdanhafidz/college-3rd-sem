package id.its.pbo.electronics;
import java.util.ArrayList;
public class TokoElektronikProgram {
    public static void main(String[] args) {
        Produk galonAqua = new Produk("Galon Aqua", 20000);
        Produk coklatSilvQ = new Produk("Silverqueen Match", 20000);
        Produk cikiTaro = new Produk("Taro", 9000);
        ItemBelanja itemsgalonAqua = new ItemBelanja(galonAqua,10);
        ItemBelanja itemscoklatSilvQ = new ItemBelanja(coklatSilvQ,100);
        ArrayList<ItemBelanja> daftarBeli = new ArrayList<ItemBelanja>();
        daftarBeli.add(itemsgalonAqua);
        daftarBeli.add(itemscoklatSilvQ);
        KeranjangBelanja myCart = new KeranjangBelanja(daftarBeli);
        myCart.tambahProduk(cikiTaro,1);
        myCart.displayInvoice();
    }
}
