/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import ConnectDB.connectDB;
import entity.KhachHang;
import java.time.LocalDate;
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
public class NhanVien_DAO{
    private final String DB_NAME = "bookstore";
    
    public NhanVien getNV_from_Record(org.neo4j.driver.Record record) {
        NhanVien nv = new NhanVien();
        
        nv.setNV_id(record.get("n").get("NV_id").asString());
        nv.setAddress(record.get("n").get("address").asString());
        
        // birth day
        String birth_date = record.get("n").get("birth_date").asString();
//        System.out.println("asdasd " +  birth_date);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//        nv.setBirth_date(LocalDate.parse(birth_date, dtf));
        nv.setBirth_date(LocalDate.now());
        
        nv.setEmail(record.get("n").get("email").asString());
        nv.setFirst_name(record.get("n").get("first_name").asString());
        nv.setLast_name(record.get("n").get("last_name").asString());
        nv.setPass_word(record.get("n").get("pass_word").asString());
        nv.setPhone(record.get("n").get("phone").asString());
        nv.setRole(record.get("n").get("role").asString());
        nv.setUser_name(record.get("n").get("user_name").asString());
        nv.setGender(record.get("n").get("gender").asString());
        return nv;
    }

    public ArrayList<NhanVien> getAllNV() {
         ArrayList<NhanVien> list_NV = new ArrayList<>();
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (n:NhanVien) return n";
            Result result = trans.run(query);
            
            while(result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                NhanVien kh = getNV_from_Record(record);
                
                list_NV.add(kh);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_NV;
    }
    
    public String phatSinhMaTuDong() {
        Driver driver = connectDB.getInstance().getDriver();
        Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
        Transaction trans = session.beginTransaction();

        String query = "MATCH (n:NhanVien) RETURN count(n) AS total";
        Result result = trans.run(query);

        int soLuong = 0;
        if(result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            soLuong = record.get("total").asInt();
        }

        return String.format("NV%03d", soLuong);
    }
    
    public NhanVien getNV_TheoMa(String maNV) {
        NhanVien nv = null;
        
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            
            String query = "match(n:NhanVien) where n.NV_id = $id return n";
            Result result = trans.run(query, Values.parameters("id", maNV));
            
            while(result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                nv = getNV_from_Record(record);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nv;
    }
    
    public ArrayList<NhanVien> getNV_TheoNgaySinh(String ngayBatDau, String ngayKT) {
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
        String query = "MATCH (n:NhanVien) WHERE n.birth_date >= $ngayBatDau AND n.birth_date < $ngayKT RETURN n";

        try  {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Result result = session.run(query, Values.parameters("ngayBatDau", ngayBatDau, "ngayKT", ngayKT));

            while (result.hasNext()) {
                org.neo4j.driver.Record record =  result.next();
                // Đọc thông tin của nhân viên từ node và thêm vào danh sách
                NhanVien nhanVien = getNV_from_Record(record);
                danhSachNhanVien.add(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return danhSachNhanVien;
    }
    
    public NhanVien GetNV_User_Name(String user_Name) {
        NhanVien nv = null;
        
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            
            String query = "match(n:NhanVien) where n.user_name = $user_name return n";
            Result result = trans.run(query, Values.parameters("user_name", user_Name));
            
            while(result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                nv = getNV_from_Record(record);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return nv;
    }

    public boolean ThemNV(NhanVien nv) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();

            String query = "CREATE (nv:NhanVien) SET nv.NV_id = $id, nv.email = $email, nv.first_name = $first_name, nv.last_name = $last_name, nv.gender = $gender, nv.phone = $phone, nv.address = $address, nv.user_name = $user_name, nv.pass_word = $pass_word, nv.role = $role, nv.birth_date = $birth_date";

            Result result = trans.run(query, Values.parameters(
                "id", phatSinhMaTuDong(),
                "email", nv.getEmail(),
                "first_name", nv.getFirst_name(),
                "last_name", nv.getLast_name(),
                "gender", nv.getGender(),
                "phone", nv.getPhone(),
                "address", nv.getAddress(),
                "user_name", nv.getUser_name(),
                "pass_word", nv.getPass_word(),
                "role", nv.getRole(),
                "birth_date", nv.getBirth_date().format(formatter)
            ));

            trans.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean xoaNV(String maNV) {
        return false;
    }

    public boolean CapNhatNV(NhanVien nv) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            
            String query = "match(nv:NhanVien) where  "
                        + "nv.NV_id = $id \n"
                        + "set nv.email = $email ,"
                        + "nv.first_name = $first_name, "
                        + "nv.last_name = $last_name, "
                        + "nv.gender = $gender, "
                        + "nv.phone = $phone, "
                        + "nv.address = $address, "
                        + "nv.user_name = $user_name, "
                        + "nv.pass_word = $pass_word, "
                        + "nv.role = $role, "
                        + "nv.birth_date = $birth_date "
                        + "return nv";

            Result result = trans.run(query, Values.parameters(
                        "id", nv.getNV_id(),
                        "email", nv.getEmail(),
                        "first_name", nv.getFirst_name(),
                        "last_name", nv.getLast_name(),
                        "gender", nv.getGender(),
                        "phone", nv.getPhone(),
                        "address", nv.getAddress(),
                        "user_name", nv.getUser_name(),
                        "pass_word", nv.getPass_word(),
                        "role", nv.getRole(),
                        "birth_date", nv.getBirth_date().format(formatter)
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
}

