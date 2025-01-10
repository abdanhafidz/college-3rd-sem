package id.its.pbo.course;

public class KursusProgram {
    public static void main(String[] args) {
        KursusOnline kursus = new KursusOnline();

        // Membuat berbagai peserta dengan semua kemungkinan skenario
        Peserta peserta1 = new Peserta("Abdan Hafidz", 20, "Sarjana"); // Valid
        Peserta peserta2 = new Peserta("Nadia", 17, "Diploma");        // Usia kurang
        Peserta peserta3 = new Peserta("Lina", 25, "Magister");        // Valid
        Peserta peserta4 = new Peserta("Dimas", 30, "SMP");            // Pendidikan tidak memenuhi
        Peserta peserta5 = new Peserta("Rina", 19, "Sarjana");         // Valid
        Peserta peserta6 = new Peserta("Budi", 16, "SMP");             // Usia dan pendidikan tidak memenuhi
        Peserta peserta7 = new Peserta("Andi", 18, "Diploma");         // Pendidikan tidak memenuhi
        Peserta peserta8 = new Peserta("Eka", 25, "");                 // Pendidikan kosong (tidak memenuhi)

        // Mendaftarkan peserta
        Peserta[] pesertaArray = {peserta1, peserta2, peserta3, peserta4, peserta5, peserta6, peserta7, peserta8};

        for (Peserta c_peserta : pesertaArray) {
            try {
                kursus.daftarPeserta(c_peserta);
            } catch (Exception e) {
                e.printStackTrace(); // Debugging dengan mencetak stack trace untuk setiap exception
            } finally {
                System.out.println("Proses pendaftaran selesai.\n");
            }
        }

        // Menampilkan daftar peserta yang berhasil terdaftar
        System.out.println("Daftar Peserta yang Berhasil Terdaftar:");
        for (Peserta peserta : kursus.getDaftarPeserta()) {
            System.out.println("Nama: " + peserta.getNama() + ", Usia: " + peserta.getUsia() + ", Pendidikan: " + peserta.getTingkatPendidikan());
        }
    }
}
