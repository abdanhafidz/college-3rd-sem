package id.its.pbo.medical;

public class Pemeriksaan {
    public void periksaData(Pasien c_pasien) throws Exception {
        try {
            c_pasien.validasiData();
            System.out.println("Data pasien valid: " + c_pasien.getNama());
        } catch (DataTidakLengkapException e) {
            throw new Exception("Pemeriksaan Gagal: " + e.getMessage(), e);
        } catch (DataTidakValidException e) {
            throw new Exception("Pemeriksaan Gagal: " + e.getMessage(), e);
        }
    }
}
