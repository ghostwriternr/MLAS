package mymlas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/mymlas";
   static final String USER = "ghost";
   static final String PASS = "naresh95";
   static String sql = null;
   static Connection conn = null;
   static Statement stmt = null;
   
   public static void create_Connection() {
   try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect.conn = DriverManager.getConnection(Connect.DB_URL, Connect.USER, Connect.PASS);
            Connect.stmt = Connect.conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException se){ 
            se.printStackTrace();
        }
        catch(Exception e){
          e.printStackTrace();
        }
   }
}

