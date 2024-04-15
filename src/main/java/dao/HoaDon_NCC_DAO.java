/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.HoaDonNCC;
import entity.NhaCungCap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import ConnectDB.connectDB;
import entity.HoaDon;
import java.time.LocalDate;
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
public class HoaDon_NCC_DAO {

    private final String DB_NAME = "bookstore";

    public String TuPhatSinhMa() {
        org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
        Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
        Transaction trans = session.beginTransaction();
        String query = "match (n:HoaDon_NCC) return count(n) as total";
        Result result = trans.run(query);

        int soLuong = 0;
        if (result.hasNext()) {
            org.neo4j.driver.Record record = result.next();
            soLuong = record.get("total").asInt();
        }
        return String.format("HDNCC%03d", soLuong + 1);
    }

    public ArrayList<HoaDonNCC> getAllHDNCC() {
        ArrayList<HoaDonNCC> list = new ArrayList<HoaDonNCC>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.defaultConfig().forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (hd:HoaDon_NCC) optional match (n:Nha_Cung_Cap) where hd.NCC_id = n.NCC_id return hd, n";
            Result result = trans.run(query);

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                Node node1 = record.get("hd").asNode();
                Node node2 = record.get("n").asNode();
//                Node node3 = record.get("sp").asNode();
                String id = node1.get("HDNCC_id").asString();
                String ncc_id = node1.get("NCC_id").asString();
                String ghiChu = node1.get("ghiChu").asString();
                String address = node2.get("address").asString();
                String email = node2.get("email").asString();
                String tenNCC = node2.get("ten_NCC").asString();
                String phone = node2.get("phone").asString();
                LocalDateTime ngaytaoHD = LocalDateTime.parse(node1.get("ngayNhap").asString().substring(0, 19), dtf);
                boolean isThanhToan = node1.get("isThanhToan").asBoolean();

                NhaCungCap ncc = new NhaCungCap(ncc_id, tenNCC, address, phone, email);
                HoaDonNCC hd = new HoaDonNCC(id, ncc, ngaytaoHD, ghiChu, isThanhToan);
                list.add(hd);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean ThemHDNCCVaoCSDL(HoaDonNCC hdncc) {
        try {
            org.neo4j.driver.Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String formattedString = hdncc.getNgayNhap().format(formatter);
            String query = "CREATE (hdncc:HoaDon_NCC {\n"
                    + "  HDNCC_id: $id,\n"
                    + "  ghiChu: $ghiChu,\n"
                    + "  isThanhToan: $isThanhToan,\n"
                    + "  ngayNhap: $ngayNhap,\n"
                    + "  NCC_id: $NCC_id}) with hdncc optional match(ncc: Nha_Cung_Cap {NCC_id: $ncc_id}) merge (hdncc)-[:Mua_tu]->(ncc)";
            Result res = trans.run(query, Values.parameters(
                    "id", hdncc.getMaHDNCC(),
                    "ghiChu", hdncc.getGhiChu(),
                    "isThanhToan", hdncc.isIsThanhToan(),
                    "ngayNhap", formattedString,
                    "NCC_id", hdncc.getNCC().getMaNCC(),
                    "ncc_id", hdncc.getNCC().getMaNCC()
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
}
