package id.its.pbo.bank;

public class BankProgram {
    public static void main(String[] args) {
        Bank bank = new Bank();

        AkunBank akun1 = new AkunBank("123456", 500000);
        AkunBank akun2 = new AkunBank("789101", 200000);
        AkunBank akun3 = new AkunBank("112233", 300000);

        bank.tambahAkun(akun1);
        bank.tambahAkun(akun2);
        bank.tambahAkun(akun3);

       
        try {
            if (!bank.cariAkun("123456").equals(null)) {
                System.out.println("Akun ditemukan!");
            }

            akun1.penarikan(50000);
            System.out.println("Penarikan berhasil. Saldo akun 123456: " + akun1.getSaldo());

            akun1.penarikan(150000);
        } catch (SaldoTidakCukupException | BatasPenarikanException | AkunTidakDitemukanException e) {
            e.printStackTrace();
        }

        // Contoh pencarian akun yang tidak ada
        try {
            bank.cariAkun("999999");
        } catch (AkunTidakDitemukanException e) {
            e.printStackTrace();
        }
    }
}
