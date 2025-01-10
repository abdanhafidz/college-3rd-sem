package id.its.pbo.toys;

public class PabrikMainanProgram {
    public static void main(String[] args) {
        PabrikMainan pabrik = new PabrikMainan();

        Mesin mesin1 = new Mesin("Mesin 1", 500, 3);
        Mesin mesin2 = new Mesin("Mesin 2", 700, 2);
        Mesin mesin3 = new Mesin("Mesin 3", 1000, 1);

        pabrik.tambahMesin(mesin1);
        pabrik.tambahMesin(mesin2);
        pabrik.tambahMesin(mesin3);

        pabrik.mulaiProduksi();
        
        int totalProduksi = pabrik.getJumlahTotalProduksi();
        System.out.println("Total mainan yang diproduksi: " + totalProduksi);
    }
}
