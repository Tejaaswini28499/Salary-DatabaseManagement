package oracleconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author suraj
 */
public class OracleConnection {
    
    public static void main(String[] args) {

        Connection conn = null;
        
        try{
            String driverName = "oracle.jdbc.driver.OracleDriver";
            //System.out.println("Connection Successful");
            Class.forName(driverName);
            
        String serverName = "Surajs-PC";
        String serverPort = "1522";
        String sid = "XE";
        
        String url = "jdbc:oracle:thin:@" + serverName + ":" + serverPort + ":" + sid;
        String userName = "root";
        
        String password = "root";
        System.out.println("Connection Successful");
        conn = DriverManager.getConnection(url, userName, password);
        
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            System.out.println("Error 2");
        }
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from TestingTable");
            while(rs.next()){
                int no=rs.getInt(1);
                String name = rs.getString(2).toString();
                System.out.println("" + no + "  " + name);
            }
            rs.close();
        
    }catch(Exception e){
        
    }
        
    }
    
}
