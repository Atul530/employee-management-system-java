package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    
    JTextField tfeducation,tffathername,tfdesignation,tfaddress,tfphone,tfsalary,tfaadhar,tfemail;
    JLabel lblempId;
    JButton add, back;
    String empId;
    
    
    UpdateEmployee(String empId){
        this.empId=empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelName=new JLabel("Name");
        labelName.setBounds(50,150,150,30);
        labelName.setFont(new Font("serif",Font.PLAIN,20));
        add(labelName);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);
        
        JLabel labelfName=new JLabel("Father's Name");
        labelfName.setBounds(400,150,150,30);
        labelfName.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfName);
        
        JLabel lblfathername=new JLabel();
        lblfathername.setBounds(600,150,150,30);
        add(lblfathername);
        
        JLabel labelDOB=new JLabel("Date of Birth");
        labelDOB.setBounds(50,200,150,30);
        labelDOB.setFont(new Font("serif",Font.PLAIN,20));
        add(labelDOB);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);
        
        JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        JLabel labeleducation=new JLabel("Higher Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleducation);
        
        tfeducation=new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);
        
        JLabel labelaadhar=new JLabel("Aadhar No");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);
        
        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        JLabel labelempId=new JLabel("Employee ID");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId=new JLabel();
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empId= '"+empId+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                 lblname.setText(rs.getString("name"));
                 lblfathername.setText(rs.getString("fname"));
                 lbldob.setText(rs.getString("dob"));
                 tfaddress.setText(rs.getString("address"));
                 tfphone.setText(rs.getString("phone"));
                 tfsalary.setText(rs.getString("salary"));
                 tfemail.setText(rs.getString("email"));
                 tfeducation.setText(rs.getString("education"));
                 tfdesignation.setText(rs.getString("designation"));
                 lblempId.setText(rs.getString("empId"));
                 lblaadhar.setText(rs.getString("aadhar"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }     
        
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Go Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String fname=tffathername.getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=tfeducation.getText();
            String designation=tfdesignation.getText();
            
            try{
                Conn conn=new Conn();
                String query="update employee set salary = ,'"+salary+"', address= '"+address+"', phone = '"+phone+"', email = '"+email+"',education = '"+education+"', designation = '"+designation+"', where empId ="+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated successfully");
                setVisible(false);
                new Home();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String args[]){
        new UpdateEmployee("");
    }
}
