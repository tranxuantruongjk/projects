package library;

public class Student {
    private String mssv;
    private String ho_ten;
    private String khoa;
    private String lop;
    private String email_sis;
    private String mat_khau;
    public Student(String mssv, String ho_ten, String khoa, String lop, String email_sis, String mat_khau){
        this.mssv = mssv;
        this.ho_ten = ho_ten;
        this.khoa = khoa;
        this.lop = lop;
        this.email_sis = email_sis;
        this.mat_khau = mat_khau;
    }
    public String getMssv(){
        return mssv;
    }
    public void setMssv(String mssv){
        this.mssv = mssv;
    }
    public String getHo_ten(){
        return ho_ten;
    }
    public void setHo_ten(String ho_ten){
        this.ho_ten = ho_ten;
    }
    public String getKhoa(){
        return khoa;
    }
    public void setKhoa(String khoa){
        this.khoa = khoa;
    }
    public String getLop(){
        return lop;
    }
    public void setLop(String lop){
        this.lop = lop;
    }
    public String getEmail_sis(){
        return email_sis;
    }
    public void setEmail_sis(String email_sis){
        this.email_sis = email_sis;
    }
    public String getMat_khau(){
        return mat_khau;
    }
    public void setMat_khau(String mat_khau){
        this.mat_khau = mat_khau;
    }

}
