package id.its.pbo.music;
import java.util.ArrayList;
public class StudioMusikProgram {
    public static void main(String[] args) {
        Instrumen pianoYamaha = new Piano("Yamaha");
        Instrumen gitarYamaha = new Gitar("Yamaha");
        Piano pianoRoland = new Piano("Roland");
        Gitar gitarRoland = new Gitar("Roland");
        ArrayList <Instrumen> punyaGwejh = new ArrayList<Instrumen>();
        punyaGwejh.add(pianoYamaha);
        punyaGwejh.add(gitarYamaha);

        StudioMusik studioTPura = new StudioMusik(punyaGwejh);
        studioTPura.tambahInstrumen(pianoRoland);
        studioTPura.tambahInstrumen(gitarRoland);
        System.out.println(studioTPura.mainkanInstrumen());
    }
}
