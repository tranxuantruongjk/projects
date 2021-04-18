package library;

public class Publisher {
    private String ma_nxb;
    private String ten_nxb;
    private String dia_chi;
    private String email;
    private String website;
    public Publisher(String ma_nxb,String ten_nxb,String dia_chi,String email,String website)
    {
        this.ma_nxb = ma_nxb;
        this.ten_nxb = ten_nxb;
        this.dia_chi = dia_chi;
        this.email = email;
        this.website = website;
    }

    public String getMa_nxb() {
        return ma_nxb;
    }

    public void setMa_nxb(String ma_nxb) {
        this.ma_nxb = ma_nxb;
    }

    public String getTen_nxb() {
        return ten_nxb;
    }

    public void setTen_nxb(String ten_nxb) {
        this.ten_nxb = ten_nxb;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
