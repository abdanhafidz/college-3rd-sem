package id.its.pbo.shops;

public class ElectricityProvider {
    public static String supplyPower(Electrifiable c_barang){
        return c_barang.powerOn();
    }
}
