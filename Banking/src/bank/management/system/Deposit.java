package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Deposit extends JFrame implements ActionListener {

    String f;
    JTextField text2, text1;
    JButton back,sned;
    public Deposit(String f) {
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



        text2 = new JTextField();
        text2.setBounds(330,165,400,30);
        text2.setForeground(Color.BLACK);
        text2.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(text2);

        JLabel amount   = new JLabel("AMOUNT IN USD");
        amount.setBounds(120,165,230,30);
        amount.setForeground(Color.white);
        amount.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(amount);

        sned = new JButton("DEPOSIT");
        sned.setForeground(Color.black);
        sned.setBounds(320,260,250,50);
        sned.setFont(new Font("Serif", Font.BOLD, 20));
        sned.addActionListener(this);
        l.add(sned);






        back = new JButton("Back");
        back.setForeground(Color.black);
        back.setBounds(680,450,100,30);
        back.setFont(new Font("Serif", Font.BOLD, 12));
        back.addActionListener(this);
        l.add(back);



        setLayout(null);
        setSize(900,600);
        setLocation(400,200);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {


            String gg = f;
            String amt = text2.getText();
            String mem = "Deposit";
            if (e.getSource() == sned) {
                if (text2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter All Fields");
                } else {
                    f = gg;
                    Con c = new Con();
                    c.statement.executeUpdate("insert into Transactions values('"+f+"','" + amt + "','" + mem + "')");
                    JOptionPane.showMessageDialog(null, "Deposited Successfully");
                    setVisible(false);
                    f = gg;
                    new Send(f);
                    setVisible(false);
                }
            }
            else if (e.getSource() == back) {
                new Send(f);
                setVisible(false);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }


    public static void main(String[] args) {
        new Deposit("");
    }


}
