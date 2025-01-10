package id.its.pbo.transaction;
public class Transaksi {
    public static int counter = 0;
    private int transaksiID = 1;
    private double jumlah;
    public Transaksi(double c_jumlah){
        this.jumlah = c_jumlah;
        this.transaksiID = counter + 1;
        counter++;
    }
    public int getTransaksiID(){
        return this.transaksiID;
    }
    public static int getTotalTransaksi(){
        return counter;
    }

    public static void resetCounter(){
        counter = 0;
    }

}
