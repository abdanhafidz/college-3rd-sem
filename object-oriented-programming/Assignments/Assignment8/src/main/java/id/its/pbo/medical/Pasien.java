package id.its.pbo.medical;

public class Pasien {
    private String nama;
    private int umur;
    private String alamat;

    public Pasien(String c_nama, int c_umur, String c_alamat) {
        this.nama = c_nama;
        this.umur = c_umur;
        this.alamat = c_alamat;
    }

    public void validasiData() throws DataTidakLengkapException, DataTidakValidException {
        if (nama == null || nama.trim().isEmpty() || alamat == null || alamat.trim().isEmpty()) {
            throw new DataTidakLengkapException();
        }
        if (umur < 0 || umur > 120) {
            throw new DataTidakValidException();
        }
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getAlamat() {
        return alamat;
    }
}
