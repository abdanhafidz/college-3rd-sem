package id.its.pbo.registration;

public class PendaftaranProgram {
    public static void main(String[] args) {
        Mahasiswa m1 = new Mahasiswa("Siapa kek");
        Mahasiswa m2 = new Mahasiswa("Siapa kek lagi");
        Mahasiswa m3 = new Mahasiswa("Siapa kek lagi lagi");
        System.out.println("Registrant 1:"+"\n - RegistrantiID: "+m1.getNomorPendaftaran());
        System.out.println("Registrant 2:"+"\n - RegistrantID: "+m2.getNomorPendaftaran());
        System.out.println("Registrant 3:"+"\n - RegistrantID: "+m3.getNomorPendaftaran());
        System.out.println("Total Pendaftar =" + Mahasiswa.getTotalRegistrant());
    }
}
