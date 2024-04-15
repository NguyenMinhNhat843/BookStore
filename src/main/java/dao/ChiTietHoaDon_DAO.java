/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhuyenMai;
import entity.SanPham;
import ConnectDB.connectDB;
import entity.KhachHang;
import java.sql.*;
import java.util.ArrayList;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Values;

/**
 *
 * @author Asus
 */
public class ChiTietHoaDon_DAO{
    private final String DB_NAME = "bookstore";
    
    public ChiTietHoaDon getCTHD_from_Record(org.neo4j.driver.Record record) {
        ChiTietHoaDon cthd = new ChiTietHoaDon();
        
        cthd.setCthd_id(record.get("n").get("CTHD_id").asString());
        HoaDon hd = new HoaDon();
        hd.setMaHD(record.get("n").get("HD_id").asString());
        cthd.setHoaDon(hd);
        SanPham sp = new SanPham();
        sp.setMaSP(record.get("n").get("Sp_id").asString());
        cthd.setSanPham(sp);
        cthd.setSoLuong(record.get("n").get("amount").asInt());
        cthd.setDon_gia(record.get("n").get("don_gia").asDouble());
        cthd.setTong_tien(record.get("n").get("tong_tien").asDouble());
                
        return cthd;
    }
    
    public String phatSinhMaTuDong() {
        org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
        Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
        Transaction trans = session.beginTransaction();
        String query = "match (n:Chi_Tiet_Hoa_Don) return count(n) as total";
        Result result = trans.run(query);
        
        int soLuong = 0;
        if(result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            soLuong = record.get("total").asInt();
        }
        return String.format("CTHD%03d", soLuong);
    }

    public boolean ThemCTHDVaoCSDL(entity.ChiTietHoaDon cthd) {
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();

            String query = "CREATE (cthd:Chi_Tiet_Hoa_Don {\n" +
                            "    CTHD_id: $CTHD_id,\n" +
                            "    HD_id: $HD_id,\n" +
                            "    Sp_id: $Sp_id,\n" +
                            "    amount: $amount,\n" +
                            "    don_gia: $don_gia,\n" +
                            "    tong_tien:$tong_tien\n" +
                            "})";
            
            Result result = trans.run(query, Values.parameters(
                        "CTHD_id", phatSinhMaTuDong(),
                        "HD_id", cthd.getHoaDon().getMaHD(),
                        "Sp_id", cthd.getSanPham().getMaSP(),
                        "amount", cthd.getSoLuong(),
                        "don_gia", cthd.getDon_gia(),
                        "tong_tien", cthd.getTong_tien()
                        ));
            
            trans.commit();
            trans.close();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    public ArrayList<Object[]> getDSSP_TheoMaHD(String maHD) {
        ArrayList<Object[]> row = new ArrayList<Object[]>();
        
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (hd:Hoa_Don)\n" +
                            "where hd.HD_id = $maHD\n" +
                            "match (cthd:Chi_Tiet_Hoa_Don)\n" +
                            "where hd.HD_id = cthd.HD_id\n" +
                            "match (sp:San_Pham)\n" +
                            "where cthd.Sp_id = sp.SP_id\n" +
                            "return sp.SP_id as maSP, sp.product_name as tenSP, sp.loai as loai, cthd.amount as sl,\n" +
                            "hd.tong_thue as thue, hd.tong_km as km, sp.gia_ban as dongia, hd.tong_tien as thanhtien";
            
            Result result = trans.run(query, Values.parameters("maHD", maHD));
            while(result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                Object[] obj_cthd = {
                    record.get("maSP"), record.get("tenSP"), record.get("loai"), record.get("sl"),
                    record.get("thue"), record.get("km"), record.get("dongia"), record.get("thanhtien")
                };
                row.add(obj_cthd);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return row;
    }

    public ArrayList<ChiTietHoaDon> ThongKe_SP_BanChay() {
        return null;
    }
    
}
