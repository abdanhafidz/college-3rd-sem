package id.its.pbo.vehicle;

import id.its.pbo.transport.Mobil;

public class KendaraanProgram {
    public static void main(String[] args) {
        Mobil Kendaraan1 = new Mobil("Nissan",2001,"GTR Skyline");
        Mobil myLove = new Mobil("Porsche",2001,"GT3 RS");
        String infoMobil1 = Kendaraan1.infoMobil();
        String infoMobil2 = myLove.infoMobil();
        System.out.println(infoMobil1);
        System.out.println(infoMobil2);
    }


}
