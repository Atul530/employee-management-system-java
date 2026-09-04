package employee.management.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;

public class Login extends JFrame{
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(40,20,100,30);
        add(lblusername);
        
        JTextField tfusername=new JTextField();
        tfusername.setBounds(150,20,150,30);
        add(tfusername);
        
        JLabel lblpassword=new JLabel("Password");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);
        
        JTextField tfpassword=new JTextField();
        tfpassword.setBounds(150,70,150,30);
        add(tfpassword);
        
        JButton login=new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
                
        setSize(600,300);
        setLocation(700,375);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new Login();
    }
}