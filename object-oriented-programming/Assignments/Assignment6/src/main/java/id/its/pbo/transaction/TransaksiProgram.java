package id.its.pbo.transaction;

public class TransaksiProgram {
    public static void main(String[] args) {
        Transaksi transaksiT1 = new Transaksi(1000);
        Transaksi transaksiT2 = new Transaksi(2000);
        Transaksi transaksiT3 = new Transaksi(1500);
        Transaksi transaksiT4 = new Transaksi(2200);
        System.out.println("Transaksi 1:"+"\n - TransaksiID: "+transaksiT1.getTransaksiID());
        System.out.println("Transaksi 2:"+"\n - TransaksiID: "+transaksiT2.getTransaksiID());
        System.out.println("Transaksi 3:"+"\n - TransaksiID: "+transaksiT3.getTransaksiID());
        System.out.println("Transaksi 4:"+"\n - TransaksiID: "+transaksiT4.getTransaksiID());
        System.out.println("Total transaksi =" + Transaksi.getTotalTransaksi());
    }
}
