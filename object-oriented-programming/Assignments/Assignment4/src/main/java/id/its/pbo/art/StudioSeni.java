package id.its.pbo.art;
import java.util.ArrayList;
public class StudioSeni {
    private ArrayList<KaryaSeni> karyaSeni = new ArrayList<KaryaSeni>();
    
    public StudioSeni(){

    }

    public StudioSeni(ArrayList<KaryaSeni> c_karyaSeni){
        this.karyaSeni.addAll(c_karyaSeni);
    }
    public void tambahKaryaSeni(KaryaSeni c_karyaSeni){
        this.karyaSeni.add(c_karyaSeni);
    }

    public ArrayList<String> tampilkanSemuaKarya(){
        ArrayList<String> pameran = new ArrayList<String>();
        for(KaryaSeni r_karyaSeni : this.karyaSeni){
            pameran.add(r_karyaSeni.tampilkan());
        }
        return pameran;
    }

}
