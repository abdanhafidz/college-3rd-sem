package id.its.pbo.store;

public class Buku {
    private String isbn;
    private String judul;
    private double harga;

    public Buku(String c_isbn, String c_judul, double c_harga){
        this.isbn = c_isbn;
        this.judul = c_judul;
        this.harga = c_harga;
    }

    public void setIsbn(String c_isbn){
        if(!c_isbn.equals("")){
            this.isbn = c_isbn;
        }
        
    }

    public void setJudul(String c_judul){
        if(!c_judul.equals("")){
            this.judul = c_judul;
        }
    }

    public void setHarga(double c_harga){
        if(c_harga >= 0){
            this.harga = c_harga;
        }
    }
    
    public String getIsbn(){
        return this.isbn;
    }
    public String getJudul(){
        return this.judul;
    }

    public double getHarga(){
        return this.harga;
    }
}
