package id.its.pbo.store;
import java.util.ArrayList;
public class TokoBuku {
    private ArrayList<Buku> buku = new ArrayList<Buku>();
    public TokoBuku(){
        
    }
    public TokoBuku(ArrayList<Buku> c_buku){
        this.buku.addAll(c_buku);
    }

    public void tambahBuku(Buku c_buku){
        this.buku.add(c_buku);
    }

    public Buku cariBuku(String c_isbn){
        for(Buku p_buku : this.buku){
            if (p_buku.getIsbn().equals(c_isbn)){
                return p_buku;
            }
        }
        return null;
    }

    public void hapusBuku(Buku c_buku){
        this.buku.remove(c_buku);
    }

    public ArrayList<Buku> getDaftarBuku(){
        return this.buku;
    }

}
