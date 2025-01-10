package id.its.pbo.zoo;
import java.util.ArrayList;
public class KebunBinatang {
    private ArrayList<Hewan> kebunBinatang = new ArrayList<Hewan>();
    public KebunBinatang(){

    }
    public KebunBinatang(ArrayList<Hewan> c_kebunBinatang){
        this.kebunBinatang.addAll(c_kebunBinatang);
    }

    public void tambahHewan(Hewan c_Hewan ){
        this.kebunBinatang.add(c_Hewan);
    }

    public void tampilkanHewanBersuara(){
        for(Hewan r_Hewan : this.kebunBinatang){
            if (r_Hewan instanceof BisaBersuara) {
                BisaBersuara suara = (BisaBersuara) r_Hewan;
                System.out.println("Suara"+ r_Hewan.getNama()+" : "+suara);
            }
        }
    }
}
