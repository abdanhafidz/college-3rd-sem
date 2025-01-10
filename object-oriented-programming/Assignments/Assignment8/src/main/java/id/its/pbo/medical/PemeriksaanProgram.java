package id.its.pbo.medical;

public class PemeriksaanProgram {
    public static void main(String[] args) {
        Pemeriksaan pemeriksaan = new Pemeriksaan();

        // Membuat beberapa objek pasien dengan berbagai kondisi
        Pasien pasien1 = new Pasien("Abdan Hafidz", 25, "Surabaya"); // Data valid
        Pasien pasien2 = new Pasien("Nadia", -5, "Jakarta"); // Umur tidak valid
        Pasien pasien3 = new Pasien("", 30, "Bandung"); // Nama kosong
        Pasien pasien4 = new Pasien("Eka", 40, ""); // Alamat kosong

        // Array pasien untuk pengujian
        Pasien[] pasienArray = {pasien1, pasien2, pasien3, pasien4};

        // Mencoba memeriksa data untuk setiap pasien
        for (Pasien c_pasien : pasienArray) {
            try {
                // Periksa kelayakan data pasien
                pemeriksaan.periksaData(c_pasien);
            } catch (DataTidakLengkapException e) {
                // Menangani DataTidakLengkapException
                System.err.println("Kesalahan: Data tidak lengkap untuk pasien " + c_pasien.getNama());
                System.err.println("Pesan kesalahan: " + e.getMessage());
            } catch (DataTidakValidException e) {
                // Menangani DataTidakValidException
                System.err.println("Kesalahan: Data tidak valid untuk pasien " + c_pasien.getNama());
                System.err.println("Pesan kesalahan: " + e.getMessage());
            } catch (Exception e) {
                // Menangani exception lain yang tidak terduga
                System.err.println("Terjadi kesalahan tak terduga untuk pasien " + c_pasien.getNama());
                System.err.println("Pesan kesalahan: " + e.getMessage());
            }
        }
    }
}
