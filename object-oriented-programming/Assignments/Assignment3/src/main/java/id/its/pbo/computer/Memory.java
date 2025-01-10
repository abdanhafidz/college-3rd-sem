package id.its.pbo.computer;

public class Memory {
    private int kapasitas;
    private String tipeMemory;

    public Memory(int c_kapasitas, String c_tipeMemory){
        this.kapasitas = c_kapasitas;
        this.tipeMemory = c_tipeMemory;
    }

    public void setKapasitas(int c_kapasitas){
        this.kapasitas = c_kapasitas;
    }

    public void setTipeMemory(String c_tipeMemory){
        if(!c_tipeMemory.equals("")){
            this.tipeMemory = c_tipeMemory;
        }
    }

    public int getKapasitas(){
        return this.kapasitas;
    }

    public String getTipeMemory(){
        return this.tipeMemory;
    }
}
