package id.its.pbo.bank;
public class SaldoTidakCukupException extends Exception{
    public SaldoTidakCukupException(){
        super("Saldo tidak mencukupi!");
    }
}