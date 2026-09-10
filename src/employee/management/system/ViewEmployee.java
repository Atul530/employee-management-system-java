package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame{

    JTable table;
    Choice cemployeeId;
    
    ViewEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Employee Details");
        heading.setBounds(320,10,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel searchlbl=new JLabel("Search by Employee Id:");
        searchlbl.setBounds(20,60,150,20);
        add(searchlbl);
        
        cemployeeId=new Choice();
        cemployeeId.setBounds(180,60,150,20);
        add(cemployeeId);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee;");    
            while(rs.next()){
                cemployeeId.add(rs.getString("empId"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table=new JTable();
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee;");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        setSize(900,700);
        setLocation(300,50);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String args[]){
        new ViewEmployee();
    }
}
