package id.its.pbo.library;
import java.util.ArrayList;
import java.lang.Exception;
public class Perpustakaan {
    private ArrayList<Buku> daftarBuku = new ArrayList<Buku>();
    private ArrayList<Anggota> daftarAnggota = new ArrayList<Anggota>();
    public void tambahBuku(Buku c_Buku){
        this.daftarBuku.add(c_Buku);
    }
    public void tambahAnggota(Anggota c_Anggota){
        this.daftarAnggota.add(c_Anggota);
    }

    public void pinjamBuku(Anggota c_Anggota, Buku c_Buku){
    try{
        if(this.daftarBuku.contains(c_Buku)){
            if(c_Buku.getDaftarPeminjam().contains(c_Anggota)){
                throw new Exception("Anggota sudah pernah meminjam");
            }else if(this.daftarAnggota.contains(c_Anggota)){
                c_Buku.tambahPeminjam(c_Anggota);
            }else{
                throw new Exception("Anggota tidak terdaftar di dalam perpustakaan");
            }
        }else{
            throw new Exception("Buku tidak ada di dalam perpustakaan");
        }
    }catch(Exception err){
        System.out.println(err);
    }
    }

    public ArrayList<Buku> getDaftarBuku(){
        return this.daftarBuku;
    }

    public ArrayList<Anggota> getDaftarAnggota(){
        return this.daftarAnggota;
    }


}
