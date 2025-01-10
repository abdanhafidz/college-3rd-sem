package id.its.pbo.book;

public class PerpustakaanProgram {
    public static void main(String[] args) {
        Buku Novel = new BukuFiksi("OMG","WKWKWKW","Love");
        BukuFiksi Cerpen = new BukuFiksi("Si Kancil","WKWKWKWKW","OIOIOIBAKA");
        BukuPelajaran IPS = new BukuPelajaran("Ilmu Pengetahuan Sigma","Kai Cenat & KSI", "Teknik Mewing");
        System.out.println(Novel.toString());
        System.out.println(Cerpen.toString());
        System.out.println(IPS.toString());
    }
    
}
