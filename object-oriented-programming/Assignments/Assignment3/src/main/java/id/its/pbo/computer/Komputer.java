package id.its.pbo.computer;

public class Komputer {
    private Processor Processor;
    private Memory Memory;

    public Komputer(Processor c_Processor, Memory c_Memory){
        this.Processor = c_Processor;
        this.Memory = c_Memory;
    }

    public void setProcessor(Processor c_Processor){
        this.Processor = c_Processor;

    }

    public void setMemory(Memory c_Memory){
        this.Memory = c_Memory;
    }

    public Processor getProcessor(){
        return this.Processor;
    }

    public Memory getMemory(){
        return this.Memory;
    }
    public String infoKomputer(){
        return "Processor Brand: "+this.Processor.getBrand()+", Kecepatan: "+this.Processor.getKecepatan()+" GHz, Memory Kapasitas: "+this.Memory.getKapasitas()+" GB, Tipe: "+this.Memory.getTipeMemory();
    }
}
