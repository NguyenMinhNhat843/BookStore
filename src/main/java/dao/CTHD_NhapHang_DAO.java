/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.ChiTietHD_NCC;
import ConnectDB.connectDB;
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
public class CTHD_NhapHang_DAO {
    private final String DB_NAME = "bookstore";
    public boolean ThemVaoCSDL(ChiTietHD_NCC cthdnh) {try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "CREATE (cthd:CTHD_NCC {\n"
                    + "  HDNCC_id: $id,\n"
                    + "  soLuongNhap: $soLuongNhap,\n"  
                    + "  sp_id: $sp_id}) with cthd optional match(hd: HoaDon_NCC {HDNCC_id: $hdncc_id}) merge (cthd)-[:Thuoc_ve]->(hd) with cthd optional match (sp:San_Pham {SP_id: $sp_id1}) merge (cthd)-[:ban_sp]->(sp)";
            Result res = trans.run(query, Values.parameters(
                    "id", cthdnh.getHdNCC().getMaHDNCC(),
                    "soLuongNhap", cthdnh.getSoLuongNhap(),
                    "sp_id", cthdnh.getSanPham().getMaSP(),
                    "hdncc_id", cthdnh.getHdNCC().getMaHDNCC(),
                    "sp_id1", cthdnh.getSanPham().getMaSP()
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
    
    public ArrayList<ChiTietHD_NCC> hoaDonNCC(String maHDNCC) {
        ArrayList<ChiTietHD_NCC> list = new ArrayList<ChiTietHD_NCC>();
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.defaultConfig().forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (hd:HoaDon_NCC) optional match (cthd:CTHD_NCC) where hd.HDNCC_id = cthd.HDNCC_id optional match (sp:San_Pham) where sp.SP_id = cthd.sp_id return hd, cthd, sp";
            Result result = trans.run(query);
            
            while(result.hasNext()) {
                
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
