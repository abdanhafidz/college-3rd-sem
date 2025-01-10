package id.its.pbo.zoo;

public class KebunBinatangProgram {
    public static void main(String[] args) {
        Hewan Jhontol = new Kucing("Jhontol");
        Hewan Blackie = new Anjing("Blackie");
        Kucing Tupis = new Kucing("Tupis");
        Anjing Wiwi = new Anjing("Wiwi");
        System.out.println("Jontol Berkata : "+Jhontol.buatSuara());
        System.out.println("Blackie Berkata : "+Blackie.buatSuara());
        System.out.println("Tupis Berkata : "+Tupis.buatSuara());
        System.out.println("Wiwi Berkata : "+Wiwi.buatSuara());
    }
}
