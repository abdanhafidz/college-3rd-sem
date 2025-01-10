package id.its.pbo.perusahaan;
public class Karyawan {
    private String name;
    private String id;
    public Karyawan(String c_name, String c_id){
        this.name = c_name;
        this.id = c_id;
    }

    public String getNama(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }
}
