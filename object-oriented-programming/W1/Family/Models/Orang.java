package Models;

public class Orang{
  private String nama;
  private int usia;
  private Orang anak[];
  private int count_anak;

  public Orang(String nama, int usia){
    this.nama = nama;
    this.usia = usia;
    this.count_anak = 0;
  }
  public void AddChild(Orang anak){
    this.count_anak+=1;
    this.anak[this.count_anak - 1] = anak;
  }
  public void GetChild(){
    System.out.println(this.nama + "'s Children are : ");
    for(int i = 0; i<this.anak.length; i++){
      System.out.println(this.anak[i]);
    }
  }
}