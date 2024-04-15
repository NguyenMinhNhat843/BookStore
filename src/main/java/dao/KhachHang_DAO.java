/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.KhachHang;
import entity.Rank;
import java.util.ArrayList;
import ConnectDB.connectDB;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Value;
import org.neo4j.driver.Values;

/**
 *
 * @author Asus
 */
public class KhachHang_DAO{
    private final String DB_NAME = "bookstore";
    
    public KhachHang getKH_from_Record(org.neo4j.driver.Record record) {
        KhachHang kh = new KhachHang();
                
        kh.setMaKH(record.get("n").get("KH_id").asString());
        kh.setFirst_name(record.get("n").get("first_name").asString());
        kh.setLast_name(record.get("n").get("last_name").asString());
        kh.setGender(record.get("n.gender").asString());
        kh.setsDT(record.get("n").get("phone").asString());
        kh.setEmail(record.get("n").get("email").asString());
        kh.setTieuPhiTichLuy(record.get("n").get("tieuPhiTichLuy").asDouble());
        kh.setTichDiem(record.get("n").get("tichDiem").asDouble());
        Rank r = new Rank(record.get("n").get("rank_id").asString());
        kh.setRank(r);
        
        return kh;
    }
    
    public ArrayList<KhachHang> getAllKH() {
        ArrayList<KhachHang> list_KH = new ArrayList<KhachHang>();
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (n:Khach_Hang) return n";
            Result result = trans.run(query);
            
            while(result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                KhachHang kh = getKH_from_Record(record);
                
                list_KH.add(kh);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_KH;
    }
    
    public String phatSinhMaTuDong() {
        Driver driver = connectDB.getInstance().getDriver();
        Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
        Transaction trans = session.beginTransaction();
        String query = "match (n:NhanVien) return count(kh) as total";
        Result result = trans.run(query);
        
        int soLuong = 0;
        if(result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            soLuong = record.get("total").asInt();
        }
        return String.format("NV%3d", soLuong);
    }
    
    public KhachHang getKH_TheoMa(String maKH_searched) {
        KhachHang kh = null;
        
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            
            String query = "match(n:Khach_Hang) where n.KH_id = $id return n";
            Result result = trans.run(query, Values.parameters("id", maKH_searched));
            
            while(result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                kh = getKH_from_Record(record);
            }
            
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return kh;
    }
   
    public boolean Update_customer(KhachHang kh_new) {
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            
            String query = "match(kh:Khach_Hang {KH_id: $id}) set "
                    + "kh.email = $email "
                    + "kh.first_name = $first_name "
                    + "kh.last_name = $last_name "
                    + "kh.gender = $gender "
                    + "kh.phone = $phone "
                    + "kh.rank_id = $rank_id "
                    + "kh.tichDiem = $tichDiem "
                    + "kh.tieuPhiTichLuy = $tieuPhi "
                    + "return kh";
            
            Result result = trans.run(query, Values.parameters(
                    "id", kh_new.getMaKH(),
                    "email", kh_new.getEmail(),
                    "first_name", kh_new.getFirst_name(),
                    "last_name", kh_new.getLast_name(),
                    "gender", kh_new.getGender(),
                    "phone", kh_new.getSDT(),
                    "rank_id", kh_new.getRank().getMaRank(),
                    "tichDiem", kh_new.getTichDiem(),
                    "tieuPhi", kh_new.getTieuPhiTichLuy()
                    ));
            
            if(result.hasNext()) {
                trans.commit();
                return true;
            }
            
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    public boolean Them_KH(KhachHang kh_new) {
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();

            String query = "create(kh:Khach_Hang {"
                        + "kh.KH_id = $id"
                        + "kh.email = $email "
                        + "kh.first_name = $first_name "
                        + "kh.last_name = $last_name "
                        + "kh.gender = $gender "
                        + "kh.phone = $phone "
                        + "kh.rank_id = $rank_id "
                        + "kh.tichDiem = $tichDiem "
                        + "kh.tieuPhiTichLuy = $tieuPhi }";

            Result result = trans.run(query, Values.parameters(
                        "id", phatSinhMaTuDong(),
                        "email", kh_new.getEmail(),
                        "first_name", kh_new.getFirst_name(),
                        "last_name", kh_new.getLast_name(),
                        "gender", kh_new.getGender(),
                        "phone", kh_new.getSDT(),
                        "rank_id", kh_new.getRank().getMaRank(),
                        "tichDiem", kh_new.getTichDiem(),
                        "tieuPhi", kh_new.getTieuPhiTichLuy()
                        ));

            if(result.hasNext()) {
                    trans.commit();
                    return true;
                }

            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
        
    public ArrayList<KhachHang> getKH_TheoRank(String maRank) {
        return null;
    }
    
    public ArrayList<KhachHang> LocTheoTichDiem(double batdau, double ketthuc) {
        return null;
    }
    
    public ArrayList<KhachHang> LocTheoTieuPhi(double batdau, double ketthuc) {
        return null;
    }
}
