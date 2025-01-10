package id.its.pbo.test;

import id.its.pbo.traffic.Kendaraan;
import id.its.pbo.traffic.Persimpangan;
import id.its.pbo.traffic.SimulasiLaluLintas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulasiLaluLintasTest {

    @Test
    void simulasiShouldBeAbleToStart() {
        Persimpangan persimpangan = new Persimpangan();
        SimulasiLaluLintas simulasi = new SimulasiLaluLintas();

        simulasi.tambahKendaraan(new Kendaraan("Mobil", 1000, persimpangan));
        simulasi.tambahKendaraan(new Kendaraan("Motor", 500, persimpangan));
        simulasi.tambahKendaraan(new Kendaraan("Bus", 1500, persimpangan));

        assertDoesNotThrow(simulasi::mulaiSimulasi);
    }
}
