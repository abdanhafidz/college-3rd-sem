package id.its.pbo.electronics;

public class ItemBelanja {
    private Produk produk;
    private int kuantitas = 1;

    public ItemBelanja(Produk c_produk, int c_kuantitas){
        this.produk = c_produk;
        this.kuantitas = c_kuantitas;
    }
    public Produk getProduk(){
        return this.produk;
    }
    public int getKuantitas(){
        return this.kuantitas;
    }

    public void setKuantitas(int c_kuantitas){
        if(c_kuantitas > 0){
            this.kuantitas = c_kuantitas;
        }
    }

    public void buyAmounts(int c_kuantitas){
        this.kuantitas += c_kuantitas;
    }
    public double hitungTotal(){
        return (double) kuantitas * this.produk.getHarga();
    }

}
