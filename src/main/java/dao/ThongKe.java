/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import ConnectDB.connectDB;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.Transaction;

/**
 *
 * @author Asus
 */
public class ThongKe {
    private final String DB_NAME = "bookstore";
    
    public void THongKeTheoDoanhThu() {
        try {
            Driver driver = connectDB.getInstance().getDriver();
            Session session = driver.session(SessionConfig.forDatabase(DB_NAME));
            Transaction trans = session.beginTransaction();
            String query = "";
            Result result = trans.run(query);
            
            while(result.hasNext()) {
               
            }
            trans.close();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
