package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Pin extends JFrame implements ActionListener {
    String f,pin;
    JButton b1,b0;
    JTextField p1;
    JPasswordField p2,p3;
    public Pin(String f) {
        this.f = f;

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image image = icon.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel l = new JLabel(icon1);
        l.setBounds(0, 0, 900, 600);
        add(l);
//
//        JLabel l0   = new JLabel("CHANGE PIN");
//        l0.setBounds(330,50,200,50);
//        l0.setForeground(Color.BLACK);
//        l0.setFont(new Font("Times New Roman",Font.BOLD,30));
//        l.add(l0);

//        JLabel l1   = new JLabel("OLD PIN");
//        l1.setBounds(180,140,150,20);
//        l1.setForeground(Color.BLACK);
//        l1.setFont(new Font("Times New Roman",Font.BOLD,18));
//        l.add(l1);
//
//        p1 = new JTextField();
//        p1.setBounds(330,140,200,20);
//        p1.setForeground(Color.BLACK);
//        p1.setFont(new Font("Times New Roman",Font.BOLD,18));
//        l.add(p1);

        JLabel label = new JLabel("USER:"+f);
        label.setBounds(60,10,250,30);
        label.setForeground(Color.white);
        label.setFont(new Font("Times New Roman",Font.BOLD,22));
        l.add(label);


        JLabel l2 = new JLabel("ENTER NEW PIN");
        l2.setBounds(200,110,230,30);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(l2);

        p2 = new JPasswordField();
        p2.setBounds(450,110,200,30);
        p2.setForeground(Color.BLACK);
        p2.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(p2);

        JLabel l3   = new JLabel("RE-ENTER NEW PIN");
        l3.setBounds(200,155,230,30);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(l3);

        p3 = new JPasswordField();
        p3.setBounds(450,155,200,30);
        p3.setForeground(Color.BLACK);
        p3.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(p3);

        b1 = new JButton("Change PIN");
        b1.setForeground(Color.black);
        b1.setBounds(320,260,250,50);
        b1.setFont(new Font("Serif", Font.BOLD, 20));
        b1.addActionListener(this);
        l.add(b1);

        b0 = new JButton("Back");
        b0.setForeground(Color.black);
        b0.setBounds(680,450,100,30);
        b0.setFont(new Font("Serif", Font.BOLD, 12));
        b0.addActionListener(this);
        l.add(b0);


//
//        try{
//            Con conn = new Con();
//            ResultSet rs = conn.statement.executeQuery("select passwd from Login where uuName ='"+f+"'");
//            pin = rs.getString(1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//








        setLayout(null);
        setSize(900,600);
        setLocation(400,200);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        try{
//            String pin1 = p1.getText();
            String pin2 = p2.getText();
            String pin3 = p3.getText();

//            if(!pin.equals(pin1)){
//                JOptionPane.showMessageDialog(null,"Invalid Old Pin");
//            }
//            else{
                if(!pin2.equals(pin3)) {
                    JOptionPane.showMessageDialog(null, "BOTH PINS DON'T MATCH");
                    return;
                }
//            }
            if(e.getSource()==b1){
                if(p2.getText().equals("")||p3.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter all the fields");
                }else{
                Con cc = new Con();
                String q1 = "update Login set passwd = '"+pin2+"' where uuName = '"+f+"'";
                String q2 = "update signUp2 set passwd = '"+pin2+"' where uuName = '"+f+"'";

                cc.statement.executeUpdate(q1);
                cc.statement.executeUpdate(q2);

                JOptionPane.showMessageDialog(null,"PIN UPDATED");
                new Send(f);
                setVisible(false);}
            }
            else if (e.getSource()==b0){
                new Send(f);
                setVisible(false);
            }

        } catch (RuntimeException | SQLException E) {
            E.printStackTrace();
        }


    }


    public static void main(String[] args) {
        new Pin("");
    }


}

//
//




//String pin1 = p2.getText();
//String pin2 = p3.getText();
//
//            if(!pin1.equals(pin2)){
//        JOptionPane.showMessageDialog(null,"PIN NOT MATCH");
//            }
//                    if(e.getSource()==b1){
//        if(p2.getText().equals("")||p3.getText().equals("")){
//        JOptionPane.showMessageDialog(null,"PIN EMPTY");
//                }
//
//Con conn = new Con();
//String q1 = "update Login set passwd = '"+pin1+"' where uuName = '"+f+"'";
//String q2 = "update signUp2 set passwd = '"+pin1+"' where uuName = '"+f+"'";
//
//                conn.statement.executeUpdate(q1);
//        conn.statement.executeUpdate(q1);

