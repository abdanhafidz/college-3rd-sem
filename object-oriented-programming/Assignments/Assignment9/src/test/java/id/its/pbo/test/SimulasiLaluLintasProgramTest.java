package id.its.pbo.test;

import id.its.pbo.traffic.SimulasiLaluLintasProgram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulasiLaluLintasProgramTest {

    @Test
    void mainMethodShouldExist() {
        assertDoesNotThrow(() -> SimulasiLaluLintasProgram.main(new String[]{}));
    }
}
