package id.its.pbo.bank;
public class AkunTidakDitemukanException extends Exception{
    public AkunTidakDitemukanException(){
        super("Akun tidak ditemukan!");
    }
}