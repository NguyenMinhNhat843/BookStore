/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConnectDB;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
/**
 *
 * @author Asus
 */
public class connectDB {
    private static connectDB instance = null;
    private Driver driver = null;
    
    public connectDB() {
        String uri = "neo4j://localhost:7687";
        String userName = "neo4j";
        String pass = "123456789";
        driver = GraphDatabase.driver(uri, AuthTokens.basic(userName, pass));
    }
    
    public synchronized static connectDB getInstance() {
        if(instance == null) {
            instance = new connectDB();
        } 
        
        return instance;
    }
    
    public Driver getDriver() {
        return driver;
    }
    
    public void close() {
        driver.close();
    }
}
