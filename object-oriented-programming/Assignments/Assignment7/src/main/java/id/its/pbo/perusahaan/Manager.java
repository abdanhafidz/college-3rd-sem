package id.its.pbo.perusahaan;

public class Manager extends Karyawan{
    private String departemen;
    public Manager(String c_name, String c_id, String c_departemen){
        super(c_name, c_id);
        this.departemen = c_departemen;
    }

    public String getDepartemen(){
        return this.departemen;
    }
}
