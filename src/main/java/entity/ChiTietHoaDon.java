/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Asus
 */
public class ChiTietHoaDon {
    private String cthd_id;
    private HoaDon hoaDon;
    private SanPham sanPham;
    private int soLuong;
    private double don_gia;
    private double tong_tien;

    public ChiTietHoaDon(String cthd_id, HoaDon hoaDon, SanPham sanPham, int soLuong, double don_gia, double tong_tien) {
        this.cthd_id = cthd_id;
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.don_gia = don_gia;
        this.tong_tien = tong_tien;
    }
    
    public ChiTietHoaDon(HoaDon hoaDon, SanPham sanPham, int soLuong, double don_gia, double tong_tien) {
        this.hoaDon = hoaDon;
        this.sanPham = sanPham;
        this.soLuong = soLuong;
        this.don_gia = don_gia;
        this.tong_tien = tong_tien;
    }

    public ChiTietHoaDon() {
    }

    public String getCthd_id() {
        return cthd_id;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDon_gia() {
        return don_gia;
    }

    public double getTong_tien() {
        return tong_tien;
    }

    public void setCthd_id(String cthd_id) {
        this.cthd_id = cthd_id;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDon_gia(double don_gia) {
        this.don_gia = don_gia;
    }

    public void setTong_tien(double tong_tien) {
        this.tong_tien = tong_tien;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "cthd_id=" + cthd_id + ", hoaDon=" + hoaDon + ", sanPham=" + sanPham + ", soLuong=" + soLuong + ", don_gia=" + don_gia + ", tong_tien=" + tong_tien + '}';
    }
}
