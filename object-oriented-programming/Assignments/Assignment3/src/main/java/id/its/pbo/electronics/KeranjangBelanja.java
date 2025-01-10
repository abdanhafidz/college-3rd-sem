package id.its.pbo.electronics;
import java.util.ArrayList;

public class KeranjangBelanja {
    private ArrayList<ItemBelanja> ItemBelanja = new ArrayList<ItemBelanja>();
    public KeranjangBelanja(){

    }
    public KeranjangBelanja(ArrayList<ItemBelanja> c_ItemBelanja){
        for(ItemBelanja p_ItemBelanja : c_ItemBelanja){
            int idx = this.ItemBelanja.indexOf(p_ItemBelanja);
            if( idx == -1){
                this.ItemBelanja.add(p_ItemBelanja);
            }else{
                this.ItemBelanja.get(idx).setKuantitas(p_ItemBelanja.getKuantitas());
            }
        }

        
    }
    public ItemBelanja cariItemByProduk(Produk c_Produk){
        for(ItemBelanja p_ItemBelanja : this.ItemBelanja){
            if( p_ItemBelanja.getProduk().equals(c_Produk) ){
                return p_ItemBelanja;
            }
        }
        return null;
    }

    public void tambahProduk(Produk c_Produk, int c_kuantitas){
        if(c_kuantitas > 0){
            ItemBelanja c_ItemBelanja = cariItemByProduk(c_Produk);
            if(c_ItemBelanja != null ){
                c_ItemBelanja.buyAmounts(c_kuantitas);
            }else{
                c_ItemBelanja = new ItemBelanja(c_Produk, c_kuantitas);
                this.ItemBelanja.add(c_ItemBelanja);
            }
        }else{
            System.out.println("Kuantitas tidak boleh 0");
        }
    }


    public double hitungTotalBelanja(){
        double total = 0;
        for(ItemBelanja p_ItemBelanja : this.ItemBelanja){
            total += p_ItemBelanja.hitungTotal();
        }
        return total;
    }

    public void displayInvoice(){
        System.out.println("************** NOTA BELANJA TOKO JAYA ABADI **************");
        for(ItemBelanja p_ItemBelanja : this.ItemBelanja){
            Produk r_produk = p_ItemBelanja.getProduk();
            System.out.println(r_produk.getNama()+"    "+r_produk.getHarga()+" x"+p_ItemBelanja.getKuantitas());
        }
        System.out.println("SUBTOTAL ="+hitungTotalBelanja());

    }
}
