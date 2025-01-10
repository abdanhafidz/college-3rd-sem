package id.its.pbo.traffic;

public class SimulasiLaluLintasProgram {
    public static void main(String[] args) {
        Persimpangan persimpangan = new Persimpangan();
        SimulasiLaluLintas simulasi = new SimulasiLaluLintas();

        Kendaraan mobil = new Kendaraan("Mobil", 1000, persimpangan);
        Kendaraan motor = new Kendaraan("Motor", 500, persimpangan);
        Kendaraan bus = new Kendaraan("Bus", 1500, persimpangan);

        simulasi.tambahKendaraan(mobil);
        simulasi.tambahKendaraan(motor);
        simulasi.tambahKendaraan(bus);

        simulasi.mulaiSimulasi();
    }
}
