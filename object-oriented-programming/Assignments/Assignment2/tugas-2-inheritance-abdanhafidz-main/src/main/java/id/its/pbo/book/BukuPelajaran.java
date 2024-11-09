package id.its.pbo.book;

public class BukuPelajaran extends Buku{
    private String subjek;
    public BukuPelajaran(String c_judul, String c_pengarang, String c_subjek){
        super(c_judul, c_pengarang);
        this.subjek = c_subjek;
    }

    public void setSubjek(String c_subjek){
        if(!c_subjek.equals("")){
            this.subjek  = c_subjek;
        }
    }
    public String getSubjek(){
        return this.subjek;
    }

    @Override
    public String toString(){
        return "Subjek :"+this.subjek;
    }
}
