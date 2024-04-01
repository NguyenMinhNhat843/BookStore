
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
import java.util.HashMap;
import java.util.Map;

import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.Values;

/**
 *
 * @author Asus
 */
public class SanPham_DAO {

    private final String DB_NAME = "bookstore";

    public SanPham getSP_from_Record(org.neo4j.driver.Record record) {
        SanPham sp = new SanPham();

        sp.setMaSP(record.get("sp").get("SP_id").asString());
        sp.setGiaBan(record.get("sp").get("gia_ban").asDouble());
        sp.setGiaNhapHang(record.get("sp").get("gia_nhap").asDouble());
        sp.setLoaiSP(record.get("sp").get("loai").asString());
        // Kiểm tra nếu ma_khuyen_mai có tồn tại thì mới lm trong ngoặc
        if (!record.get("sp").get("ma_khuyen_mai").asString().equals("") && !record.get("km").isNull()) {
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
        if (result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            soLuong = record.get("total").asInt();
        }
        return String.format("SP%03d", soLuong + 1);
    }

    public SanPham getSP_TheoMa(String maSP) {
        SanPham sp = null;

        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();

            String query = "MATCH (sp:San_Pham)\n"
                    + "where sp.SP_id = $id \n"
                    + "OPTIONAL MATCH (sp)-[:HAS_PROMOTION]->(km:Khuyen_Mai)\n"
                    + "RETURN sp, km";
            Result result = trans.run(query, Values.parameters("id", maSP));

            while (result.hasNext()) {
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

    public boolean updateSP(SanPham sp) {
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();

            String query = "match (p:San_Pham) where (p.SP_id = $id) optional match (p)-[r:HAS_PROMOTION]-() delete r set"
                    + "  p.product_name = $product_name,"
                    + "  p.gia_nhap = $gia_nhap,"
                    + "  p.gia_ban = $gia_ban,"
                    + "  p.loai = $loai,"
                    + "  p.thue = $thue,"
                    + "  p.ma_khuyen_mai = $ma_khuyen_mai"
                    + " with p optional match(km: Khuyen_Mai {KM_id: $km_id}) merge (p)-[:HAS_PROMOTION]->(km)";
            String maKM = sp.getkM() != null ? sp.getkM().getMaKM() : "";
            Result res = trans.run(query, Values.parameters(
                    "id", sp.getMaSP(),
                    "product_name", sp.getTenSP(),
                    "gia_nhap", sp.getGiaNhapHang(),
                    "gia_ban", sp.getGiaBan(),
                    "loai", sp.getLoaiSP(),
                    "thue", sp.getThue(),
                    "ma_khuyen_mai", maKM,
                    "km_id", maKM
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

    public boolean themSanPham(SanPham sp) {
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "CREATE (p:San_Pham {\n"
                    + "  SP_id: $SP_id,\n"
                    + "  product_name: $product_name,\n"
                    + "  gia_nhap: $gia_nhap,\n"
                    + "  gia_ban: $gia_ban,\n"
                    + "  loai: $loai,\n"
                    + "  thue: $thue,\n"
                    + "  ma_khuyen_mai: $ma_khuyen_mai\n"
                    + "}) with p optional match(km: Khuyen_Mai {KM_id: $km_id}) merge (p)-[:HAS_PROMOTION]->(km)";
            Result res = trans.run(query, Values.parameters(
                    "SP_id", sp.getMaSP(),
                    "product_name", sp.getTenSP(),
                    "gia_nhap", sp.getGiaNhapHang(),
                    "gia_ban", sp.getGiaBan(),
                    "loai", sp.getLoaiSP(),
                    "thue", sp.getThue(),
                    "ma_khuyen_mai", sp.getkM().getMaKM(),
                    "km_id", sp.getkM().getMaKM()
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

    public ArrayList<SanPham> getDSSP() {
        ArrayList<SanPham> list_SP = new ArrayList<SanPham>();
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (sp:San_Pham) OPTIONAL MATCH (sp)-[:HAS_PROMOTION]->(km:Khuyen_Mai) RETURN sp, km order by sp.SP_id";
            Result result = trans.run(query);

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                SanPham sp = getSP_from_Record(record);
                list_SP.add(sp);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_SP;
    }

    public ArrayList<SanPham> timSPTheoMa(String maSP) {
        ArrayList<SanPham> list_SP = new ArrayList<SanPham>();
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (sp:San_Pham) where (sp.SP_id = $id) return sp";
            Result result = trans.run(query, Values.parameters("id", maSP));

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                SanPham sp = getSP_from_Record(record);
                list_SP.add(sp);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_SP;
    }
}
