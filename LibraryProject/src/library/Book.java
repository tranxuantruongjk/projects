package library;

public class Book {
    private String ma_sach;
    private String ten_sach;
    private String ma_the_loai;
    private String ma_nxb;
    private String tac_gia;
    private String nam_xb;
    private int gia_dat;
    private int so_luong;
    public Book(String ma_sach,String ten_sach,String ma_the_loai,String ma_nxb,String tac_gia,String nam_xb, int gia_dat,int so_luong){
        this.ma_sach = ma_sach;
        this.ten_sach = ten_sach;
        this.ma_the_loai = ma_the_loai;
        this.ma_nxb = ma_nxb;
        this.tac_gia = tac_gia;
        this.nam_xb = nam_xb;
        this.gia_dat = gia_dat;
        this.so_luong = so_luong;
    }

    public String getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(String ma_sach) {
        this.ma_sach = ma_sach;
    }

    public String getTen_sach() {
        return ten_sach;
    }

    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }

    public String getMa_the_loai() {
        return ma_the_loai;
    }

    public void setMa_the_loai(String ma_the_loai) {
        this.ma_the_loai = ma_the_loai;
    }

    public String getMa_nxb() {
        return ma_nxb;
    }

    public void setMa_nxb(String ma_nxb) {
        this.ma_nxb = ma_nxb;
    }

    public String getTac_gia() {
        return tac_gia;
    }

    public void setTac_gia(String tac_gia) {
        this.tac_gia = tac_gia;
    }

    public String getNam_xb() {
        return nam_xb;
    }

    public void setNam_xb(String nam_xb) {
        this.nam_xb = nam_xb;
    }

    public int getGia_dat() {
        return gia_dat;
    }

    public void setGia_dat(int gia_dat) {
        this.gia_dat = gia_dat;
    }

    public int getSo_luong() {
        return so_luong;
    }

    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }
}
