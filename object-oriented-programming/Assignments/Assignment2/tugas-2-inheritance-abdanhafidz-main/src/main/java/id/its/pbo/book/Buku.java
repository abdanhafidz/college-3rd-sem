package id.its.pbo.book;

public class Buku {
    private String judul;
    private String pengarang;
    public Buku(String c_judul, String c_pengarang){
        this.judul = c_judul;
        this.pengarang = c_pengarang;
    }
    public void setJudul(String c_judul){
        if(!c_judul.equals("")){
            this.judul = c_judul;
        }
    }

    public void setPengarang(String c_pengarang){
        if(!c_pengarang.equals("")){
            this.pengarang = c_pengarang;
        }
    }
    public String getJudul(){
        return this.judul;
    }

    public String getPengarang(){
        return this.pengarang;
    }
    public String toString(Buku c_buku){
        return "Judul = "+this.judul+",Pengarang = "+this.pengarang+","+c_buku.toString();
    }
}
