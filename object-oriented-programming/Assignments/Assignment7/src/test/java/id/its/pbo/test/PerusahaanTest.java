package id.its.pbo.test;

import id.its.pbo.perusahaan.Perusahaan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerusahaanTest {
    @Test
    public void mainMethodExists() {
        try {
            Perusahaan.class.getMethod("main", String[].class);
        } catch (NoSuchMethodException e) {
            fail("Method main is not defined");
        }
    }
}
