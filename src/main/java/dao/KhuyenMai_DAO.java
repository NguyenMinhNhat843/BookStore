/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConnectDB.connectDB;
import java.util.List;
import entity.KhuyenMai;
import entity.SanPham;
import java.util.ArrayList;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.types.Node;

/**
 *
 * @author ngoct
 */
public class KhuyenMai_DAO {

    private final String DB_NAME = "bookstore";
    public KhuyenMai_DAO() {
        super();
    }
    public List<KhuyenMai> getDSKM() {
        List<KhuyenMai> dsSP = new ArrayList<KhuyenMai>();
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "match (km:Khuyen_Mai) RETURN km";
            Result result = trans.run(query);

            while (result.hasNext()) {
                org.neo4j.driver.Record record = result.next();
                Node node = record.get("km").asNode();
                KhuyenMai km = new KhuyenMai(node.get("KM_id").asString(), node.get("mo_ta").asString(), node.get("muc_giam_gia").asDouble());
                dsSP.add(km);
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsSP;
    }
}
