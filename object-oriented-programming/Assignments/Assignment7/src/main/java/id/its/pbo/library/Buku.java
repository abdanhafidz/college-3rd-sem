package id.its.pbo.library;
import java.util.ArrayList;
public class Buku {
    private String judul, pengarang;
    private int tahunTerbit;
    private ArrayList<Anggota> daftarPeminjam = new ArrayList<Anggota>();

    public Buku(String c_judul, String c_pengarang, int c_tahunTerbit){
        this.judul = c_judul;
        this.pengarang = c_pengarang;
        this.tahunTerbit = c_tahunTerbit;
    }

    public Buku(String c_judul, String c_pengarang, int c_tahunTerbit, ArrayList<Anggota> c_daftarPeminjam){
        this.judul = c_judul;
        this.pengarang = c_pengarang;
        this.tahunTerbit = c_tahunTerbit;
        this.daftarPeminjam.addAll(c_daftarPeminjam);
    }
    public String getJudul(){
        return this.judul;
    }
    public void tambahPeminjam(Anggota c_peminjam){
        this.daftarPeminjam.add(c_peminjam);
    }

    public ArrayList<Anggota> getDaftarPeminjam(){
        return this.daftarPeminjam;
    }

    public String getInfoBuku(){
        return this.judul+", "+this.pengarang+", "+this.tahunTerbit;
    }
}
