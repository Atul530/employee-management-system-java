package employee.management.system;

import java.sql.*;

public class Conn { 
    Connection c;
    Statement s;
    
    public Conn(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mariadb://localhost:3306/employeeManagementSystemJava","root","9476");
            s=c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
