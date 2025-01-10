package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import id.its.pbo.traffic.Persimpangan;

class PersimpanganTest {

    @Test
    void lockObjectShouldExist() throws NoSuchFieldException, IllegalAccessException {
        Persimpangan persimpangan = new Persimpangan();

        // Menggunakan reflection untuk mengakses field private
        Field lockField = Persimpangan.class.getDeclaredField("lock");
        lockField.setAccessible(true);  // Mengizinkan akses ke field private

        // Mengambil nilai dari field lock
        Object lock = lockField.get(persimpangan);

        // Memeriksa apakah lock bukan null
        assertNotNull(lock);
    }
}
