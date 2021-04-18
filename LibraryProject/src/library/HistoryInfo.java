package library;

public class HistoryInfo {
    private String ma_sach;
    private String mssv;
    private String ngay_muon;
    private String han_tra;
    public HistoryInfo(String ma_sach,String mssv,String ngay_muon,String han_tra){
        this.ma_sach = ma_sach;
        this.mssv = mssv;
        this.ngay_muon = ngay_muon;
        this.han_tra = han_tra;
    }

    public String getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(String ma_sach) {
        this.ma_sach = ma_sach;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getNgay_muon() {
        return ngay_muon;
    }

    public void setNgay_muon(String ngay_muon) {
        this.ngay_muon = ngay_muon;
    }


    public String getHan_tra() {
        return han_tra;
    }

    public void setHan_tra(String han_tra) {
        this.han_tra = han_tra;
    }


}

