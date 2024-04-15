/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.ArrayList;
import java.time.LocalDateTime;

/**
 *
 * @author Asus
 */
public class HoaDon {
    private String maHD;
    private NhanVien nv;
    private KhachHang kh;
    private LocalDateTime date;
    private double tien_nhan;
    private double tien_thua;
    private double tien_von;
    private double tong_km;
    private double tong_thue;
    private double tong_tien;
    private double su_dung_diem;

    public HoaDon(String maHD, NhanVien nv, KhachHang kh, LocalDateTime date, double tien_nhan, double tien_thua, double tien_von, double tong_km, double tong_thue, double tong_tien, double su_dung_diem) {
        this.maHD = maHD;
        this.nv = nv;
        this.kh = kh;
        this.date = date;
        this.tien_nhan = tien_nhan;
        this.tien_thua = tien_thua;
        this.tien_von = tien_von;
        this.tong_km = tong_km;
        this.tong_thue = tong_thue;
        this.tong_tien = tong_tien;
        this.su_dung_diem = su_dung_diem;
    }

    public HoaDon() {
    }

    public String getMaHD() {
        return maHD;
    }

    public NhanVien getNv() {
        return nv;
    }

    public KhachHang getKh() {
        return kh;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getTien_nhan() {
        return tien_nhan;
    }

    public double getTien_thua() {
        return tien_thua;
    }

    public double getTien_von() {
        return tien_von;
    }

    public double getTong_km() {
        return tong_km;
    }

    public double getTong_thue() {
        return tong_thue;
    }

    public double getTong_tien() {
        return tong_tien;
    }

    public double getSu_dung_diem() {
        return su_dung_diem;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setTien_nhan(double tien_nhan) {
        this.tien_nhan = tien_nhan;
    }

    public void setTien_thua(double tien_thua) {
        this.tien_thua = tien_thua;
    }

    public void setTien_von(double tien_von) {
        this.tien_von = tien_von;
    }

    public void setTong_km(double tong_km) {
        this.tong_km = tong_km;
    }

    public void setTong_thue(double tong_thue) {
        this.tong_thue = tong_thue;
    }

    public void setTong_tien(double tong_tien) {
        this.tong_tien = tong_tien;
    }

    public void setSu_dung_diem(double su_dung_diem) {
        this.su_dung_diem = su_dung_diem;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", nv=" + nv + ", kh=" + kh + ", date=" + date + ", tien_nhan=" + tien_nhan + ", tien_thua=" + tien_thua + ", tien_von=" + tien_von + ", tong_km=" + tong_km + ", tong_thue=" + tong_thue + ", tong_tien=" + tong_tien + ", su_dung_diem=" + su_dung_diem + '}';
    }
}
