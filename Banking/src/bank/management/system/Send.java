package bank.management.system;

import com.mysql.cj.protocol.Resultset;
import com.sun.source.tree.IfTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Send extends JFrame implements ActionListener {

    String f;
    int balance = 0;
    JButton b0,b1,b2,b3,b4,b5;
    public Send(String f) {
        this.f = f;


        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image image = icon.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel l = new JLabel(icon1);
        l.setBounds(0, 0, 900, 600);
        add(l);

        JLabel label = new JLabel("USER:"+f);
        label.setBounds(60,10,250,30);
        label.setForeground(Color.white);
        label.setFont(new Font("Times New Roman",Font.BOLD,22));
        l.add(label);



        b0 = new JButton("Logout");
        b0.setForeground(Color.black);
        b0.setBounds(680,450,100,30);
        b0.setFont(new Font("Serif", Font.BOLD, 12));
        b0.addActionListener(this);
        l.add(b0);

        b5 = new JButton("Change Pin");
        b5.setForeground(Color.black);
        b5.setBounds(140,450,100,30);
        b5.setFont(new Font("Serif", Font.BOLD, 12));
        b5.addActionListener(this);
        l.add(b5);


//        b1 = new JButton("Send");
//        b1.setForeground(Color.black);
//        b1.setBounds(240,150,120,50);
//        b1.setFont(new Font("Serif", Font.BOLD, 20));
//        b1.addActionListener(this);
//        l.add(b1);

        b2 = new JButton("Deposit");
        b2.setForeground(Color.black);
        b2.setBounds(200,150,250,50);
        b2.setFont(new Font("Serif", Font.BOLD, 20));
        b2.addActionListener(this);
        l.add(b2);

        b3 = new JButton("Pay");
        b3.setForeground(Color.black);
        b3.setBounds(460,150,250,50);
        b3.setFont(new Font("Serif", Font.BOLD, 20));
        b3.addActionListener(this);
        l.add(b3);

        b4 = new JButton("Check Balance");
        b4.setForeground(Color.black);
        b4.setBounds(320,260,250,50);
        b4.setFont(new Font("Serif", Font.BOLD, 20));
        b4.addActionListener(this);
        l.add(b4);



        setLayout(null);
        setSize(900,600);
        setLocation(400,200);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try{

//            Con c = new Con();
//            ResultSet resultSet = c.statement.executeQuery("select * from Transactions where uuName = '"+f+"'");
//
//            while (resultSet.next()) {
//                if (resultSet.getString("mem").equals("Deposit")) {
//                    balance += Integer.parseInt(resultSet.getString("amt"));
//                } else {
//                    balance -= Integer.parseInt(resultSet.getString("amt"));
//                }
//            }
//            c.statement.executeUpdate("insert into Balance values('"+f+"','"+balance+"')");


            if (e.getSource()==b0) {
                new Login(f);
                setVisible(false);

            }
//            else if(e.getSource()==b1){
//                new SendAmount(f);
//                setVisible(false);
//            }
            else if(e.getSource()==b2){
                new Deposit(f);
                setVisible(false);
            }else if(e.getSource()==b3){
                new Pay(f);
                setVisible(false);
            }else if(e.getSource()==b4){
                new Totalbalance(f);
                setVisible(false);
            } else if (e.getSource()==b5) {
                new Pin(f);
                setVisible(false);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new Send("");
    }


}
