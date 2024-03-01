
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Enum_class;
import entity.KhuyenMai;
import entity.NhaCungCap;
import entity.SanPham;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
//import java.time.LocalDate;
import java.time.*;
import java.time.format.*;
import ConnectDB.connectDB;
import entity.NhanVien;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Values;

/**
 *
 * @author Asus
 */
public class SanPham_DAO{
    
    private final String DB_NAME = "bookstore";
    
    public SanPham getSP_from_Record(org.neo4j.driver.Record record) {
        SanPham sp = new SanPham();
        
        sp.setMaSP(record.get("sp").get("SP_id").asString());
        sp.setGiaBan(record.get("sp").get("gia_ban").asDouble());
        sp.setGiaNhapHang(record.get("sp").get("gia_nhap").asDouble());
        sp.setLoaiSP(record.get("sp").get("loai").asString());
        // Kiểm tra nếu ma_khuyen_mai có tồn tại thì mới lm trong ngoặc
        if(!record.get("sp").get("ma_khuyen_mai").asString().equals("")) {
            String maKM = record.get("km").get("KM_id").asString();
            String mota = record.get("km").get("mo_ta").asString();
            Double muc_giam_gia = record.get("km").get("muc_giam_gia").asDouble();
            sp.setkM(new KhuyenMai(maKM, mota, muc_giam_gia));
        } else {
            sp.setkM(new KhuyenMai());
        }
        sp.setTenSP(record.get("sp").get("product_name").asString());
        sp.setThue(record.get("sp").get("thue").asDouble());
                
        return sp;
    }

    public String phatSinhMaTuDong() {
        org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
        Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
        Transaction trans = session.beginTransaction();
        String query = "match (n:San_Pham) return count(n) as total";
        Result result = trans.run(query);
        
        int soLuong = 0;
        if(result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            soLuong = record.get("total").asInt();
        }
        return String.format("SP0%3d", soLuong);
    }

    public SanPham getSP_TheoMa(String maSP) {
        SanPham sp = null;
        
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            
            String query = "MATCH (sp:San_Pham)\n" +
                            "where sp.SP_id = $id \n" +
                            "OPTIONAL MATCH (sp)-[:HAS_PROMOTION]->(km:Khuyen_Mai)\n" +
                            "RETURN sp, km";
            Result result = trans.run(query, Values.parameters("id", maSP));
            
            while(result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                sp = getSP_from_Record(record);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sp;
    }
    
    
    public boolean updateSP(SanPham sp_new) {
        return false;
    }
    
    public boolean themSanPham(SanPham sp){
        return false;
    }
    
    public ArrayList<SanPham> getDSSP() {
        return null;
    }
}
