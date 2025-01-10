package id.its.pbo.perusahaan;

public class Perusahaan {
    public static void main(String[] args) {
        Direktur dirut = new Direktur("Alice","A1","Sales",100000);
        System.out.println("Name : "+dirut.getNama());
        System.out.println("Id : "+dirut.getId());
        System.out.println("Departemen : "+dirut.getDepartemen());
        System.out.println("Gaji : "+dirut.getGaji());
    }
}
