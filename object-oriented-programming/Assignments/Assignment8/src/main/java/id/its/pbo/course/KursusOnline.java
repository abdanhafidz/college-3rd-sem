package id.its.pbo.course;
import java.util.ArrayList;
public class KursusOnline {
    private ArrayList<Peserta> daftarPeserta;

    public KursusOnline() {
        this.daftarPeserta = new ArrayList<>();
    }

    public void daftarPeserta(Peserta c_peserta) throws UsiaTidakMemenuhiSyaratException, PendidikanTidakMemenuhiSyaratException{
        try {
            c_peserta.cekKelayakan();
            daftarPeserta.add(c_peserta);
        } catch (UsiaTidakMemenuhiSyaratException | PendidikanTidakMemenuhiSyaratException e) {
            throw e;
        }
    }

    public ArrayList<Peserta> getDaftarPeserta() {
        return daftarPeserta;
    }
}
