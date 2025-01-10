package id.its.pbo.shops;

public class TokoBarangProgram {
    public static void main(String[] args) {
        Barang tvSharp = new Televisi("Sharp");
        Televisi tvSamsung = new Televisi("Samsung");
        KipasAngin fanAquos = new KipasAngin("Aquos");
        MobilListrik carTesla = new MobilListrik("Tesla");

        System.out.println(ElectricityProvider.supplyPower( (Electrifiable) tvSharp));
        System.out.println(ElectricityProvider.supplyPower(tvSamsung));
        System.out.println(ElectricityProvider.supplyPower(fanAquos));
        System.out.println(ElectricityProvider.supplyPower(fanAquos));
    }
}
