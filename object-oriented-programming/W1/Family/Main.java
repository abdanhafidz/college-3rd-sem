
import Models.Orang;
public class Main {
  public static void main(String[] args) {
    Orang Orang1 = new Orang("Farhan",19);
    Orang Anak1 = new Orang("Wew", 20);
    Orang1.AddChild(Anak1);
    Orang1.GetChild();
  }
}