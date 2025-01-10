package id.its.pbo.gadget;
import id.its.pbo.electronics.Smartphone;
public class GadgetProgram {
    public static void main(String[] args) {
        Smartphone Ipong = new Smartphone("Apple", 2024, "IOS");
        String infoIpong= Ipong.infoSmartphone();
        System.out.println(infoIpong);
    }
    
}
