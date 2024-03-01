/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.time.LocalDateTime;
import java.util.Objects;
import java.lang.Exception;

/**
 *
 * @author Asus
 */
public class KhuyenMai {
    private String maKM;
    private String mo_ta;
    private double muc_giam_gia;

    public KhuyenMai(String maKM, String mo_ta, double muc_giam_gia) {
        this.maKM = maKM;
        this.mo_ta = mo_ta;
        this.muc_giam_gia = muc_giam_gia;
    }
    
    public KhuyenMai(String maKM) {
        this.maKM = maKM;
    }

    public KhuyenMai() {
    }

    public String getMaKM() {
        return maKM;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public double getMuc_giam_gia() {
        return muc_giam_gia;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public void setMuc_giam_gia(double muc_giam_gia) {
        this.muc_giam_gia = muc_giam_gia;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "maKM=" + maKM + ", mo_ta=" + mo_ta + ", muc_giam_gia=" + muc_giam_gia + '}';
    }
}
