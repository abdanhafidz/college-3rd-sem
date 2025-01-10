package id.its.pbo.electronics;

public class Produk {
    private String nama;
    private double harga;

    public Produk(String c_nama, double c_harga){
        this.nama = c_nama;
        this.harga = c_harga;
    }

    public void setNama(String c_nama){
        if(!c_nama.equals("")){
            this.nama = c_nama;
        }
    }

    public void setHarga(double c_harga){
        if(c_harga > 0){
            this.harga = c_harga;
        }
    }

    public String getNama(){
        return this.nama;
    }

    public double getHarga(){
        return this.harga;
    }
}
