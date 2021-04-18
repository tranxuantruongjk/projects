package library;

public class Category {
    private String ma_the_loai;
    private String ten_the_loai;
    public Category(String ma_the_loai, String ten_the_loai)
    {
        this.ma_the_loai = ma_the_loai;
        this.ten_the_loai = ten_the_loai;
    }

    public String getMa_the_loai() {
        return ma_the_loai;
    }

    public void setMa_the_loai(String ma_the_loai) {
        this.ma_the_loai = ma_the_loai;
    }

    public String getTen_the_loai() {
        return ten_the_loai;
    }

    public void setTen_the_loai(String ten_the_loai) {
        this.ten_the_loai = ten_the_loai;
    }

}
