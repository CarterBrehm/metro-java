package seeproducts;

import java.sql.*;

public class SeeProducts {

    public static void main(String[] args) {
        Connection con = null;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String myDb = "jdbc:derby://localhost:1527/Bookstore";
            con = DriverManager.getConnection(myDb, "nbuser", "nbuser");
            
            StringBuilder sb = new StringBuilder();
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM PRODUCTS");
            
            while(result.next()){
                sb.append(result.getString("Description"));
                sb.append("\n");                
            }
            System.out.println(sb.toString());  
        }
        catch(ClassNotFoundException | SQLException exc){ System.err.println(exc); }
        finally{
            try{
                if(con != null) con.close();
            }
            catch(SQLException sqle){System.err.println(sqle);}
        }
    } 
}
