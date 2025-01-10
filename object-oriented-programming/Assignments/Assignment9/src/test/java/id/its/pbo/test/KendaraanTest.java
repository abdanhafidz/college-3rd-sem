package id.its.pbo.test;

import id.its.pbo.traffic.Kendaraan;
import id.its.pbo.traffic.Persimpangan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KendaraanTest {

    @Test
    void kendaraanShouldBeAbleToCross() {
        Persimpangan persimpangan = new Persimpangan();
        Kendaraan mobil = new Kendaraan("Mobil", 1000, persimpangan);
        Thread threadMobil = new Thread(mobil);

        assertDoesNotThrow(threadMobil::start);
    }
}
