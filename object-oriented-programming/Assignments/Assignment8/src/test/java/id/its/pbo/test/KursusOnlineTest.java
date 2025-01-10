package id.its.pbo.test;

import org.junit.jupiter.api.Test;

import id.its.pbo.course.KursusOnline;
import id.its.pbo.course.PendidikanTidakMemenuhiSyaratException;
import id.its.pbo.course.Peserta;
import id.its.pbo.course.UsiaTidakMemenuhiSyaratException;

import static org.junit.jupiter.api.Assertions.*;

public class KursusOnlineTest {

 @Test
 public void testPendaftaranDenganUsiaKurangDari18() {
     Exception exception = assertThrows(UsiaTidakMemenuhiSyaratException.class, () -> {
         Peserta peserta = new Peserta("Jane", 16, "SMA");
         KursusOnline kursusOnline = new KursusOnline();
         kursusOnline.daftarPeserta(peserta);
     });
     assertEquals("Maaf, usia Anda tidak memenuhi syarat untuk mengikuti kursus ini.", exception.getMessage());
 }

 @Test
 public void testPendaftaranDenganPendidikanTidakMemenuhiSyarat() {
     Exception exception = assertThrows(PendidikanTidakMemenuhiSyaratException.class, () -> {
         Peserta peserta = new Peserta("John", 20, "SMP");
         KursusOnline kursusOnline = new KursusOnline();
         kursusOnline.daftarPeserta(peserta);
     });
     assertEquals("Maaf, tingkat pendidikan Anda tidak memenuhi syarat untuk mengikuti kursus ini.", exception.getMessage());
 }

 @Test
 public void testKursusProgramMemilikiMethodMain() {
     try {
         Class.forName("id.its.pbo.course.KursusProgram").getDeclaredMethod("main", String[].class);
     } catch (NoSuchMethodException e) {
         fail("Method main tidak ditemukan di kelas KursusProgram.");
     } catch (ClassNotFoundException e) {
         fail("Kelas KursusProgram tidak ditemukan.");
     }
 }
}