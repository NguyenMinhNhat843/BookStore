/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.jdi.connect.spi.Connection;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import java.util.ArrayList;
import ConnectDB.connectDB;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Values;
import org.neo4j.driver.types.Node;

/**
 *
 * @author Asus
 */
public class HoaDon_DAO{
    private final String DB_NAME = "bookstore";
    
    public HoaDon getHD_from_Record(org.neo4j.driver.Record record) {
        HoaDon hd = new HoaDon();
        hd.setMaHD(record.get("hd").get("HD_id").asString());
        KhachHang kh = new KhachHang();
        if(!record.get("kh").isNull()) {
            kh.setMaKH(record.get("kh").get("kh.KH_id").asString());
            kh.setFirst_name(record.get("kh").get("first_name").asString());
            kh.setLast_name(record.get("kh").get("last_name").asString());
        }
        hd.setKh(kh);
        NhanVien nv = new NhanVien();
        if(!record.get("nv").isNull()) {
            nv.setNV_id(record.get("nv").get("NV_id").asString());
            nv.setFirst_name(record.get("nv").get("first_name").asString());
            nv.setLast_name(record.get("nv").get("last_name").asString());
        }
        hd.setNv(nv);
        
        // Xu lý ngày
//        LocalDateTime birth_date = record.get("hd").get("date").asLocalDateTime();
        hd.setDate(LocalDateTime.now());
        
        hd.setSu_dung_diem(record.get("hd").get("su_dung_diem").asDouble());
        hd.setTien_nhan(record.get("hd").get("tien_nhan").asDouble());
        hd.setTien_thua(record.get("hd").get("tien_thua").asDouble());
        hd.setTien_von(record.get("hd").get("tien_von").asDouble());
        hd.setTong_km(record.get("hd").get("tong_km").asDouble());
        hd.setTong_thue(record.get("hd").get("tong_thue").asDouble());
        hd.setTong_tien(record.get("hd").get("tong_tien").asDouble());
        
        return hd;
    }
    
    public String phatSinhMaTuDong() {
        org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
        Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
        Transaction trans = session.beginTransaction();
        String query = "match (n:Hoa_Don) return count(n) as total";
        Result result = trans.run(query);
        
        int soLuong = 0;
        if(result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            soLuong = record.get("total").asInt();
        }
        return String.format("HD%03d", soLuong);
    }
    
    public ArrayList<Object[]> getAllHD() {
        ArrayList<Object[]> list_HD = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (hd:Hoa_Don)\n" +
                            "OPTIONAL match (nv:NhanVien)\n" +
                            "where hd.NV_id = nv.NV_id\n" +
                            "OPTIONAL match (kh:Khach_Hang)\n" +
                            "where hd.KH_id = kh.KH_id\n" +
                            "return hd.HD_id as maHD, hd.date as date, nv.last_name as tenNV, kh.last_name as tenKH, hd.tong_tien as tongtien";
            Result result = trans.run(query);
            
            while(result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                String maHD = record.get("maHD").asString();
                LocalDateTime ngaytaoHD = LocalDateTime.parse(record.get("date").asString().substring(0, 19), dtf);
                String tenNV = record.get("tenNV").asString();
                String tenKH = record.get("tenKH").asString();
                Double tongtien = record.get("tongtien").asDouble();
                Object[] obj_hoadon = {maHD, ngaytaoHD, tenNV, tenKH, tongtien};
                list_HD.add(obj_hoadon);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_HD;
    }
    
    public Object[] getHD_TheoMa(String maHD) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (hd:Hoa_Don)\n" +
                            "where hd.HD_id = $id\n" +
                            "OPTIONAL match (nv:NhanVien)\n" +
                            "where hd.NV_id = nv.NV_id\n" +
                            "OPTIONAL match (kh:Khach_Hang)\n" +
                            "where hd.KH_id = kh.KH_id\n" +
                            "return kh.last_name as tenKH, nv.last_name as tenNV, hd";
            Result result = trans.run(query, Values.parameters("id", maHD));
            
            while(result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                Node node = record.get("hd").asNode();
                HoaDon hd = new HoaDon();
                hd.setDate(LocalDateTime.parse(node.get("date").asString().substring(0, 19), dtf));
                hd.setTong_km(node.get("tong_km").asDouble());
                hd.setSu_dung_diem(node.get("su_dung_diem").asDouble());
                hd.setTien_thua(node.get("tien_thua").asDouble());
                hd.setMaHD(node.get("HD_id").asString());
                hd.setTong_thue(node.get("tong_thue").asDouble());
                hd.setTien_nhan(node.get("tien_nhan").asDouble());
                hd.setTong_tien(node.get("tong_tien").asDouble());
                hd.setTien_von(node.get("tien_von").asDouble());
                Object[] obj_HD = { record.get("tenKH").asString(), record.get("tenNV").asString(), hd };
                return obj_HD;
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean themHD(HoaDon hd) {
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            
            String query = "CREATE (hd:Hoa_Don {\n" +
                            "    HD_id: $HD_id,\n" +
                            "    KH_id: $Kh_id,\n" +
                            "    NV_id: $NV_id,\n" +
                            "    date: $date,\n" +
                            "    su_dung_diem: $su_dung_diem,\n" +
                            "    tien_nhan: $tien_nhan,\n" +
                            "    tien_thua: $tien_thua,\n" +
                            "    tien_von: $tien_von,\n" +
                            "    tong_km: $tong_km,\n" +
                            "    tong_thue: $tong_thue,\n" +
                            "    tong_tien: $tong_tien\n" +
                            "})";

            Result result = trans.run(query, Values.parameters(
                        "HD_id", hd.getMaHD(),
                        "Kh_id", hd.getKh() == null ? "" : hd.getKh().getMaKH(),
                        "NV_id", hd.getNv().getNV_id(),
                        "date", hd.getDate(),
                        "su_dung_diem", hd.getSu_dung_diem(),
                        "tien_nhan", hd.getTien_nhan(),
                        "tien_thua", hd.getTien_thua(),
                        "tien_von", hd.getTien_von(),
                        "tong_km", hd.getTong_km(),
                        "tong_thue", hd.getTong_thue(),
                        "tong_tien", hd.getTong_tien()
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

    public ArrayList<HoaDon> TimHoaDonTheoThoiGian(String ngayBatDau, String ngayKetThuc) {
        return null;
    }
    
    public ArrayList<HoaDon> LocTheoKH(String sdt) {
        return null;
    }
}
