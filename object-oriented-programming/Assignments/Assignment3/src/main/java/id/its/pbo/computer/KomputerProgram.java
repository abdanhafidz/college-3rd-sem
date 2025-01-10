package id.its.pbo.computer;

public class KomputerProgram {
    public static void main(String[] args) {
        Memory memoriGwejh = new Memory(99999, "SIGMA MEWING RIZZ");
        Processor processorGwejh = new Processor("Gyatt Maximum", 9.129);
        Komputer komputerGwejh = new Komputer(processorGwejh,memoriGwejh);
        System.out.println(komputerGwejh.infoKomputer());
        memoriGwejh.setTipeMemory("Gooning Loosing Aura -99999");
        processorGwejh.setKecepatan(-888.2);
        komputerGwejh.setMemory(memoriGwejh);
        komputerGwejh.setProcessor(processorGwejh);
    }
}
