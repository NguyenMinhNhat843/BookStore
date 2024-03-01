/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import entity.Rank;
import java.util.Objects;

/**
 *
 * @author Asus
 */
public class KhachHang {
    private String maKH;
    private String first_name;
    private String last_name;
    private String gender;
    private String sDT;
    private String email;
    private double tieuPhiTichLuy;
    private Rank rank;
    private double tichDiem;

    public KhachHang(String maKH, String fist_name, String last_name, String gender, String sDT, String email, double tieuPhiTichLuy, Rank rank, double tichDiem) {
        this.maKH = maKH;
        this.first_name = fist_name;
        this.last_name = last_name;
        this.gender = gender;
        this.sDT = sDT;
        this.email = email;
        this.tieuPhiTichLuy = tieuPhiTichLuy;
        this.rank = rank;
        this.tichDiem = tichDiem;
    }
    
    public KhachHang(String maKH) {
        this.maKH = maKH;
    }

    public KhachHang() {
    }

    public String getMaKH() {
        return maKH;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public String getSDT() {
        return sDT;
    }

    public String getEmail() {
        return email;
    }
    
    public double getTieuPhiTichLuy() {
        return tieuPhiTichLuy;
    }

    public Rank getRank() {
        return rank;
    }

    public double getTichDiem() {
        return tichDiem;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTieuPhiTichLuy(double tieuPhiTichLuy) {
        this.tieuPhiTichLuy = tieuPhiTichLuy;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setTichDiem(double tichDiem) {
        this.tichDiem = tichDiem;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.maKH);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.maKH, other.maKH);
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", first_name=" + first_name + ", last_name=" + last_name + ", gender=" + gender + ", sDT=" + sDT + ", email=" + email + ", tieuPhiTichLuy=" + tieuPhiTichLuy + ", rank=" + rank + ", tichDiem=" + tichDiem + '}';
    }
}
