package id.its.pbo.bank;

public class AkunBank {
    private String nomorAkun;
    private double saldo;
    public static double batasPenarikanHarian = 100000;
    public AkunBank(String c_nomorAkun, double c_saldo){
        this.nomorAkun = c_nomorAkun;
        this.saldo = c_saldo;
    }

    public void penarikan(double jumlah) throws SaldoTidakCukupException, BatasPenarikanException{
        if(jumlah <= this.saldo ){
            this.saldo -= jumlah;
        }else{
            throw new SaldoTidakCukupException();
        }

        if(jumlah > batasPenarikanHarian){
            throw new BatasPenarikanException();
        }
    }
    public void tarik(double jumlah) throws SaldoTidakCukupException, BatasPenarikanException{
        if(jumlah <= this.saldo ){
            this.saldo -= jumlah;
        }else{
            throw new SaldoTidakCukupException();
        }

        if(jumlah > batasPenarikanHarian){
            throw new BatasPenarikanException();
        }
    }
    public double getSaldo(){
        return this.saldo;
    }
    public String getNomorAkun(){
        return this.nomorAkun;
    }
}
