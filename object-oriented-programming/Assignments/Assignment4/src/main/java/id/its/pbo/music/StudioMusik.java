package id.its.pbo.music;
import java.util.ArrayList;
public class StudioMusik {
    private ArrayList<Instrumen> alatInstrumen = new ArrayList<Instrumen>();
    
    public StudioMusik(){

    }

    public StudioMusik(ArrayList<Instrumen> c_instrumen){
        this.alatInstrumen.addAll(c_instrumen);
    }
    public void tambahInstrumen(Instrumen c_instrumen){
        this.alatInstrumen.add(c_instrumen);
    }

    public String mainkanInstrumen(){
        String suara = "";
        for(Instrumen r_instrumen : alatInstrumen){
            suara += r_instrumen.suara() + " ";
        }
        suara = suara.substring(0, suara.length()-1);
        return suara;
    }

}
