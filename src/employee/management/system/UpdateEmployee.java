package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    Random ran=new Random();
    int number=ran.nextInt(999999);
    
    JComboBox cdeducation;
    JDateChooser dcdob;
    JTextField tfname,tffathername,tfdesignation,tfaddress,tfphone,tfsalary,tfaadhar,tfemail;
    JLabel lblempId;
    JButton add, back;
    
    UpdateEmployee(){
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
        
        tffathername=new JTextField();
        tffathername.setBounds(600,150,150,30);
        add(tffathername);
        
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
        
        String courses[]={"BBA","BCA","BA","B.COM","BTech","B.Sc","MBA","MCA","MA","M.COM","MTech","M.Sc","PHD"};
        cdeducation=new JComboBox(courses);
        cdeducation.setBackground(Color.WHITE);
        cdeducation.setBounds(600,300,150,30);
        add(cdeducation);
        
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
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        JLabel labelempId=new JLabel("Employee ID");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempId);
        
        lblempId=new JLabel(""+number);
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("serif",Font.PLAIN,20));
        add(lblempId);
        
        add = new JButton("Add Details");
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
            String name=tfname.getText();
            String fname=tffathername.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String education=(String) cdeducation.getSelectedItem();
            String designation=tfdesignation.getText();
            String aadhar=tfaadhar.getText();
            String empId=lblempId.getText();
            
            try{
                Conn conn=new Conn();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+aadhar+"','"+empId+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details added successfully");
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
        new UpdateEmployee();
    }
}
