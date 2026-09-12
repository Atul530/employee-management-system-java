package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener{

    JTable table;
    Choice cemployeeId;
    JButton search,print,update,back;
    
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
        jsp.setBounds(0,130,900,600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20,90,80,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120,90,80,20);
        print.addActionListener(this);
        add(print);
        
        update=new JButton("Update");
        update.setBounds(220,90,80,20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(320,90,80,20);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from employee where empId = '"+cemployeeId.getSelectedItem()+"';";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource()==print){
               try{
                   table.print();
               }catch(Exception e){
                   e.printStackTrace();
               }
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee();
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new ViewEmployee();
    }
}
