package id.its.pbo.art;
import java.util.ArrayList;
public class StudioSeniProgram {
    public static void main(String[] args) {
        StudioSeni studioPasarBaru = new StudioSeni();
        KaryaSeni lukisanAnjay = new Lukisan("Anjay");
        KaryaSeni patungSquidward = new Patung("Squidward");
        Lukisan lukisanMonalisa = new Lukisan("Monalisa");
        studioPasarBaru.tambahKaryaSeni(lukisanAnjay);
        studioPasarBaru.tambahKaryaSeni(patungSquidward);
        studioPasarBaru.tambahKaryaSeni(lukisanMonalisa);
        ArrayList<String> pameran = studioPasarBaru.tampilkanSemuaKarya();
        for(String tampilan_karyaSeni : pameran){
            System.out.println(tampilan_karyaSeni);
        }
    }
}
