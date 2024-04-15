/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConnectDB.connectDB;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
public class ThongKe {
    private final String DB_NAME = "bookstore";
    
    public List<Object[]> THongKeTheoDoanhThu(String ngayBatDau, String ngayKetThuc) {
        List<Object[]> lst_obj_thongke_hd = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (hd:Hoa_Don)\n" +
                            "where hd.date <= $ngayketthuc AND hd.date >= $ngaybatdau\n" +
                            "match (cthd:Chi_Tiet_Hoa_Don)\n" +
                            "where hd.HD_id = cthd.HD_id\n" +
                            "match (sp:San_Pham)\n" +
                            "where cthd.Sp_id = sp.SP_id\n" +
                            "return hd.HD_id as maHD, hd.date as date, hd.tong_tien as tongtien, "
                            + "sum(sp.gia_nhap) as tienvon ,hd.tong_tien - sum(sp.gia_nhap) as loinhuan";
            Result result = trans.run(query, Values.parameters(
                    "ngaybatdau", ngayBatDau,
                    "ngayketthuc", ngayKetThuc
                    ));
            
            
            while(result.hasNext()) {
               org.neo4j.driver.Record record = result.next();
               
               Object[] obj_thongke_hoadon = {
                   record.get("maHD").asString(),
                   LocalDateTime.parse(record.get("date").asString().substring(0, 19), dtf),
                   record.get("tienvon").asDouble(),
                   record.get("tongtien").asDouble(),
                   record.get("loinhuan").asDouble()
               };
               lst_obj_thongke_hd.add(obj_thongke_hoadon);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst_obj_thongke_hd;
    }
}
