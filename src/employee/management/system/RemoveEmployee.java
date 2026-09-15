package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class RemoveEmployee extends JFrame implements ActionListener{

    JTable table;
    Choice cemployeeId;
    JButton delete,back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Remove Employee");
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
        
        delete=new JButton("Delete");
        delete.setBounds(20,90,80,20);
        delete.addActionListener(this);
        add(delete);
        
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
        if(ae.getSource()==delete){
            String query="delete from employee where empId = '"+cemployeeId.getSelectedItem()+"';";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new RemoveEmployee();
    }
}
