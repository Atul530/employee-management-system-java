package employee.management.system;

import java.awt.*;
import javax.swing.*;
//import com.toedter.calender.JDateChooser;

public class AddEmployee extends JFrame{
    
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelName=new JLabel("Name");
        labelName.setBounds(50,150,150,30);
        labelName.setFont(new Font("serif",Font.PLAIN,20));
        add(labelName);
        
        JTextField tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel labelfName=new JLabel("Father's Name");
        labelfName.setBounds(400,150,150,30);
        labelfName.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfName);
        
        JTextField tffathername=new JTextField();
        tffathername.setBounds(600,150,150,30);
        add(tffathername);
        
        JLabel labelDOB=new JLabel("Date of Birth");
        labelDOB.setBounds(50,200,150,30);
        labelDOB.setFont(new Font("serif",Font.PLAIN,20));
        add(labelDOB);
        
//        JTextField tfname=new JTextField();
//        tfname.setBounds(200,150,150,30);
//        add(tfname);
        
        setSize(900,700);
        setLocation(300,50);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new AddEmployee();
    }
}
