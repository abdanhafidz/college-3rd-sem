package id.its.pbo.zoo;
import java.util.ArrayList;
public class KebunBinatangProgram {
    public static void main(String[] args) {
        Hewan ularKadut = new Ular("Kadut");
        Kuda jokiHorse = new Kuda("Joki");
        Singa rawrLion = new Singa("rawr");
        ArrayList<Hewan> daftarHewan = new ArrayList<Hewan>();
        daftarHewan.add(jokiHorse);
        daftarHewan.add(rawrLion);
        KebunBinatang zooSBY = new KebunBinatang(daftarHewan);
        zooSBY.tambahHewan(new Singa("Simba"));
        zooSBY.tampilkanHewanBersuara();

    }
    
}
