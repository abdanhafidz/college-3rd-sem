package id.its.pbo.bank;

public class PengecekanAkunBankProgram {
    public static void main(String[] args) {
        // Membuat objek Bank
        Bank bank = new Bank();

        // Menambahkan beberapa akun ke bank
        AkunBank akun1 = new AkunBank("123456", 500000);
        AkunBank akun2 = new AkunBank("789101", 200000);

        bank.tambahAkun(akun1);
        bank.tambahAkun(akun2);

        // Skenario 1: Akun ditemukan
        try {
            AkunBank ditemukan = bank.cariAkun("123456");
            System.out.println("Akun ditemukan: " + ditemukan.getNomorAkun());
        } catch (AkunTidakDitemukanException e) {
            e.printStackTrace();
        }

        // Skenario 2: Akun tidak ditemukan
        try {
            bank.cariAkun("000000");
        } catch (AkunTidakDitemukanException e) {
            e.printStackTrace();
        }

        // Skenario 3: Penarikan berhasil
        try {
            akun1.penarikan(100000);
            System.out.println("Penarikan berhasil. Sisa saldo: " + akun1.getSaldo());
        } catch (SaldoTidakCukupException | BatasPenarikanException e) {
            e.printStackTrace();
        }

        // Skenario 4: Penarikan gagal karena saldo tidak cukup
        try {
            akun2.penarikan(300000);
        } catch (SaldoTidakCukupException | BatasPenarikanException e) {
            e.printStackTrace();
        }

        // Skenario 5: Penarikan gagal karena melebihi batas harian
        try {
            akun2.penarikan(150000);
        } catch (SaldoTidakCukupException | BatasPenarikanException e) {
            e.printStackTrace();
        }

        // Skenario 6: Menggabungkan saldo tidak cukup dan batas harian
        try {
            akun2.penarikan(250000); // Melebihi saldo, juga melebihi batas harian
        } catch (SaldoTidakCukupException | BatasPenarikanException e) {
            e.printStackTrace();
        }
    }
}
