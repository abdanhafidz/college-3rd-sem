package id.its.pbo.course;
public class Peserta {
    private String nama;
    private int usia;
    private String tingkatPendidikan;

    public Peserta(String c_nama, int c_usia, String c_tingkatPendidikan) {
        this.nama = c_nama;
        this.usia = c_usia;
        this.tingkatPendidikan = c_tingkatPendidikan;
    }

    public void cekKelayakan() throws UsiaTidakMemenuhiSyaratException, PendidikanTidakMemenuhiSyaratException {
        if (usia < 18) {
            throw new UsiaTidakMemenuhiSyaratException();
        }
        if (!tingkatPendidikan.equals("Sarjana") && !tingkatPendidikan.equals("Magister")) {
            throw new PendidikanTidakMemenuhiSyaratException();
        }
    }

    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }

    public String getTingkatPendidikan() {
        return tingkatPendidikan;
    }
}