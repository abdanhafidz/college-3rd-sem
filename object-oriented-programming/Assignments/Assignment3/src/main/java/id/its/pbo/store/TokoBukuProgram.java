package id.its.pbo.store;

public class TokoBukuProgram {
    public static void main(String[] args) {
        TokoBuku tokoSigma = new TokoBuku();
        Buku cintakuK = new Buku("K4yl4","Cintaku K", 1000000);
        tokoSigma.tambahBuku(cintakuK);
        Buku kisahKdanAbdan = new Buku("kkkkkkaaaaa","K dan Abdan Vol.1",1000000);
        tokoSigma.tambahBuku(kisahKdanAbdan);
        boolean status = cintakuK.equals(tokoSigma.cariBuku("K4yl4"));
        if(status){
            System.out.println("yeay Ketemu <3");
        }else{
            System.out.println("Yah stoknya habis / bukunya gaada");
        }
        


    }
}
