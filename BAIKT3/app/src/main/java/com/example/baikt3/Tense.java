package com.example.baikt3;
public class Tense {
    private String Ten;
    private String CongThuc;
    private String Cau;

    public Tense(String ten, String congThuc, String cau) {
        Ten = ten;
        CongThuc = congThuc;
        Cau = cau;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getCongThuc() {
        return CongThuc;
    }

    public void setCongThuc(String congThuc) {
        CongThuc = congThuc;
    }

    public String getCau() {
        return Cau;
    }

    public void setCau(String cau) {
        Cau = cau;
    }
}