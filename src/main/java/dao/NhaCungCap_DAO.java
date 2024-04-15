/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhaCungCap;
import java.util.ArrayList;
import ConnectDB.connectDB;
import org.neo4j.driver.Driver;
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
public class NhaCungCap_DAO{
    private String DB_NAME = "bookstore";
    public NhaCungCap getNCC_from_Record(org.neo4j.driver.Record record) {
        Node node = record.get("n").asNode();
        String id = node.get("NCC_id").asString();
        String email = node.get("email").asString();
        String tenNCC = node.get("ten_NCC").asString();
        String phone = node.get("phone").asString();
        String address = node.get("address").asString();
        
        NhaCungCap n = new NhaCungCap(id, tenNCC, address, phone, email);
        return n;
    }
    public ArrayList<NhaCungCap> getAllNCC() {
         ArrayList<NhaCungCap> list_SP = new ArrayList<NhaCungCap>();
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.defaultConfig().forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (n:Nha_Cung_Cap) RETURN n order by n.NCC_id";
            Result result = trans.run(query);

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                NhaCungCap n = getNCC_from_Record(record);
                list_SP.add(n);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_SP;
    }
    
     public String phatSinhMaTuDong() {
        org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
        Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
        Transaction trans = session.beginTransaction();
        String query = "match (n:Nha_Cung_Cap) return count(n) as total";
        Result result = trans.run(query);

        int soLuong = 0;
        if (result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            soLuong = record.get("total").asInt();
        }
        return String.format("NCC%03d", soLuong + 1);
    }

    public NhaCungCap getNCC_TheoMa(String maNCC) {
        return null;
    }

    public boolean ThemNCC(NhaCungCap ncc) {
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "CREATE (ncc:Nha_Cung_Cap {\n"
                    + "  NCC_id: $id,\n"
                    + "  address: $address,\n"
                    + "  email: $email,\n"
                    + "  phone: $phone,\n"
                    + "  ten_NCC: $ten})";
            Result res = trans.run(query, Values.parameters(
                    "id", ncc.getMaNCC(),
                    "address", ncc.getDiaChi(),
                    "email", ncc.getEmail(),
                    "phone", ncc.getSDT(),
                    "ten", ncc.getTenNCC()
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

    public boolean CapNhatNCC(NhaCungCap ncc) {
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (n: Nha_Cung_Cap) where n.NCC_id = $id set n.address = $address, n.email = $email, n.phone = $phone, n.ten_NCC = $ten";
            Result res = trans.run(query, Values.parameters(
                    "id", ncc.getMaNCC(),
                    "address", ncc.getDiaChi(),
                    "email", ncc.getEmail(),
                    "phone", ncc.getSDT(),
                    "ten", ncc.getTenNCC()
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

    public String tuPhatSinhMa() {
        return "";
    }
    
}
