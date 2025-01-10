package id.its.pbo.bank;
import java.util.ArrayList;
public class Bank {
    private ArrayList<AkunBank> daftarAkunBanks = new ArrayList<AkunBank>();
    public Bank(){

    }
    public Bank(ArrayList<AkunBank> c_daftarAkunBanks){
        this.daftarAkunBanks.addAll(c_daftarAkunBanks);
    }
    public void tambahAkun(AkunBank c_AkunBank){
        this.daftarAkunBanks.add(c_AkunBank);
    }

    public AkunBank cariAkun(String c_nomorAkun) throws AkunTidakDitemukanException{
        for(AkunBank r_AkunBank : this.daftarAkunBanks){
            if(r_AkunBank.getNomorAkun().equals(c_nomorAkun)){
                return r_AkunBank;
            }
        }
        throw new AkunTidakDitemukanException();
    }
}
