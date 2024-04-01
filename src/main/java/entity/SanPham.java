/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Asus
 */
public class SanPham {
    private String maSP;
    private KhuyenMai kM;
    private NhaCungCap nCC;
    private String tenSP;
    private String loaiSP;
    private double giaNhapHang;
    private double giaBan;
    private double thue;

    public SanPham(String maSP, KhuyenMai kM, NhaCungCap nCC, String tenSP, String loaiSP, double giaNhapHang, double giaBan, double thue) {
        this.maSP = maSP;
        this.kM = kM;
        this.nCC = nCC;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaNhapHang = giaNhapHang;
        this.giaBan = giaBan;
        this.thue = thue;
    }
    
    public SanPham(String maSP, KhuyenMai kM, String tenSP, String loaiSP, double giaNhapHang, double giaBan, double thue) {
        this.maSP = maSP;
        this.kM = kM;
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.giaNhapHang = giaNhapHang;
        this.giaBan = giaBan;
        this.thue = thue;
    }

    public SanPham() {
    }

    public String getMaSP() {
        return maSP;
    }

    public KhuyenMai getkM() {
        return kM;
    }

    public NhaCungCap getnCC() {
        return nCC;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public double getGiaNhapHang() {
        return giaNhapHang;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public double getThue() {
        return thue;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setkM(KhuyenMai kM) {
        this.kM = kM;
    }

    public void setnCC(NhaCungCap nCC) {
        this.nCC = nCC;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public void setGiaNhapHang(double giaNhapHang) {
        this.giaNhapHang = giaNhapHang;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", kM=" + kM + ", nCC=" + nCC + ", tenSP=" + tenSP + ", loaiSP=" + loaiSP + ", giaNhapHang=" + giaNhapHang + ", giaBan=" + giaBan + ", thue=" + thue + '}';
    }
}
