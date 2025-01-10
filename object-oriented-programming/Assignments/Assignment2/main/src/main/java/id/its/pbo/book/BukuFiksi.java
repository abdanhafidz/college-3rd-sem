package id.its.pbo.book;

public class BukuFiksi extends Buku{
    private String genre;
    public BukuFiksi(String c_judul, String c_pengarang, String c_genre){
        super(c_judul, c_pengarang);
        this.genre = c_genre;
    }
    public void setGenre(String c_genre){
        if(!c_genre.equals("")){
            this.genre = c_genre;
        }
    }

    public String getGenre(){
        return this.genre;
    }
    @Override
    public String toString(){
        return "Genre :"+this.genre;
    }
}
