package id.its.pbo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import id.its.pbo.shops.ElectricityProvider;
import id.its.pbo.shops.Electrifiable;
import id.its.pbo.shops.KipasAngin;
import id.its.pbo.shops.MobilListrik;
import id.its.pbo.shops.Televisi;

public class TokoBarangTest {

    @Test
    public void testTelevisiPowerOn() {
        Televisi tv = new Televisi("Samsung");
        assertEquals("Televisi dinyalakan", tv.powerOn());
    }

    @Test
    public void testKipasAnginPowerOn() {
        KipasAngin kipas = new KipasAngin("Maspion");
        assertEquals("Kipas Angin dinyalakan", kipas.powerOn());
    }

    @Test
    public void testMobilListrikPowerOn() {
        MobilListrik mobil = new MobilListrik("Tesla");
        assertEquals("Mobil Listrik siap berjalan", mobil.powerOn());
    }

    @Test
    public void testElectricityProviderSupplyPower() {
        Televisi tv = new Televisi("Samsung");
        assertEquals("Televisi dinyalakan", ElectricityProvider.supplyPower(tv));
    }

    @Test
    public void testTokoBarangProgramMainMethodExistence() {
        try {
            Class<?> clazz = Class.forName("id.its.pbo.shops.TokoBarangProgram");
            clazz.getDeclaredMethod("main", String[].class);
            assertTrue(true); // Method main() ada
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            assertTrue(false); // Method main() tidak ada atau class tidak ditemukan
        }
    }
    
    @Test
    public void testKipasAnginImplementsElectrifiable() {
        assertTrue(KipasAngin.class.getInterfaces()[0].equals(Electrifiable.class));
    }

    @Test
    public void testTelevisiImplementsElectrifiable() {
        assertTrue(Televisi.class.getInterfaces()[0].equals(Electrifiable.class));
    }

    @Test
    public void testMobilListrikImplementsElectrifiable() {
        assertTrue(MobilListrik.class.getInterfaces()[0].equals(Electrifiable.class));
    }
    
    @Test
    public void testSupplyPowerToKipasAngin() {
        KipasAngin kipas = new KipasAngin("Panasonic");
        String response = ElectricityProvider.supplyPower(kipas);
        assertEquals("Kipas Angin dinyalakan", response);
    }

    @Test
    public void testSupplyPowerToTelevisi() {
        Televisi tv = new Televisi("Samsung");
        String response = ElectricityProvider.supplyPower(tv);
        assertEquals("Televisi dinyalakan", response);
    }

    @Test
    public void testSupplyPowerToMobilListrik() {
        MobilListrik mobil = new MobilListrik("Tesla");
        String response = ElectricityProvider.supplyPower(mobil);
        assertEquals("Mobil Listrik siap berjalan", response);
    }

}
