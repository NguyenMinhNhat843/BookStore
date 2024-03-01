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
            
            String query = "match (cthd:Chi_Tiet_Hoa_Don) \n" +
                            "where cthd.HD_id = $id\n" +
                            "optional match (cthd)-[:CTHD_HAS_PRODUCT]->(sp)\n" +
                            "return cthd, sp";
            Result result = trans.run(query, Values.parameters("id", maHD));
            
            while(result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                
                if(!record.get("sp").isNull()) {
                    Object[] obj = {
                        record.get("sp").get("SP_id").asString(),
                        record.get("sp").get("product_name").asString(),
                        record.get("sp").get("loai").asString(),
                        record.get("cthd").get("amount").asInt(),
                        record.get("sp").get("thue").asDouble(),
                        record.get("sp").get("ma_khuyen_mai").asString(),
                        record.get("sp").get("gia_ban").asDouble(),
                        record.get("cthd").get("tong_tien").asDouble()
                    };
                    row.add(obj);
                }
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
