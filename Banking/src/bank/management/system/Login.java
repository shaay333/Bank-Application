package bank.management.system;
import com.mysql.cj.protocol.Resultset;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1,label2,label3;
    JTextField text2;
    JPasswordField password3;
    JButton button1,button2,button3;
    String f;

    Login(String f){
        super("Bank Management System");
        this.f=f;

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image image = icon.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel l = new JLabel(icon1);
        l.setBounds(0, 0, 900, 600);
        add(l);

        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image image1 = icon2.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(image1);
        JLabel l7 = new JLabel(icon3);
        l7.setBounds(300, 50, 50, 50);
        l.add(l7);

//        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/bg1.png"));
//        Image i2 = i.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(0, 0, 900, 600);
//        add(image);

        label1 = new JLabel("DUMMY BANK");
        label1.setBounds(370,50,250,50);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l.add(label1);

        label2 = new JLabel("USER NAME");
        label2.setBounds(250,120,150,20);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Times New Roman",Font.BOLD,18));
        l.add(label2);

        text2 = new JTextField();
        text2.setBounds(400,120,200,20);
        text2.setForeground(Color.black );
        text2.setFont(new Font("Times New Roman",Font.BOLD,18));
        l.add(text2);

        label3 = new JLabel("PIN NUMBER");
        label3.setBounds(250,170,150,20);
        label3.setForeground(Color.white);
        label3.setFont(new Font("Times New Roman",Font.BOLD,18));
        l.add(label3);

        password3 = new JPasswordField();
        password3.setBounds(400,170,200,20);
        password3.setForeground(Color.BLACK);
        password3.setFont(new Font("Times New Roman",Font.BOLD,18));
        l.add(password3);

        button1 = new JButton("Login");
        button1.setBounds(295,230,80,15);
        button1.setForeground(Color.BLACK);
        button1.setFont(new Font("Times New Roman",Font.BOLD,13));
        button1.addActionListener(this);
        l.add(button1);

        button2 = new JButton("SignUp");
        button2.setBounds(380,230,80,15);
        button2.setForeground(Color.BLACK);
        button2.setFont(new Font("Times New Roman",Font.BOLD,13));
        button2.addActionListener(this);
        l.add(button2);

        button3 = new JButton("Clear");
        button3.setBounds(465,230,80,15);
        button3.setForeground(Color.BLACK);
        button3.setFont(new Font("Times New Roman",Font.BOLD,13));
        button3.addActionListener(this);
        l.add(button3);




        setLayout(null);
        setSize(900,600);
        setLocation(400,200);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==button1){
                Con c = new Con();
                String uuName = text2.getText();
                String pin = password3.getText();
                String q = "select * from Login where uuName='"+uuName+"' and passwd ='"+pin+"'";
                ResultSet resultset = c.statement.executeQuery(q);
                f = uuName;
                if(resultset.next()){
                    setVisible(false);
                    new Send(f);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
            }
            else if(e.getSource()==button2){
                new SignUp();
                setVisible(false);
            }
            else if(e.getSource()==button3){
                text2.setText("");
                password3.setText("");
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Login("");
    }


}
