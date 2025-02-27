package bank.management.system;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pay extends JFrame implements ActionListener {
    String f;
    JButton back,sned;
    JTextField text2,text3,text4;

    public Pay(String f) {
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



        JLabel label2 = new JLabel("TO");
        label2.setBounds(200,110,230,30);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(label2);

        text2 = new JTextField();
        text2.setBounds(450,110,200,30);
        text2.setForeground(Color.BLACK);
        text2.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(text2);

        JLabel amount   = new JLabel("AMOUNT IN USD");
        amount.setBounds(200,155,230,30);
        amount.setForeground(Color.white);
        amount.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(amount);

        text3 = new JTextField();
        text3.setBounds(450,155,200,30);
        text3.setForeground(Color.BLACK);
        text3.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(text3);



        JLabel memo   = new JLabel("MEMO");
        memo.setBounds(200,200,230,30);
        memo.setForeground(Color.white);
        memo.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(memo);

        text4 = new JTextField();
        text4.setBounds(450,200,200,30);
        text4.setForeground(Color.BLACK);
        text4.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.add(text4);

        sned = new JButton("PAY");
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
            if (e.getSource() == back) {
                new Send(f);
                setVisible(false);
            }
            else {
                String amt = text3.getText();
                String memo = text4.getText();
                if (text3.getText().equals("")) {

                    JOptionPane.showMessageDialog(null, "Please enter amount");
                } else {
                    Con c = new Con();
                    ResultSet resultSet = c.statement.executeQuery("select * from Transactions where uuName = '" + f + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("mem").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amt"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amt"));
                        }
                    }
                    if (balance < Integer.parseInt(amt)) {
                        JOptionPane.showMessageDialog(null, "You don't have enough money");
                        return;
                    }
                    c.statement.executeUpdate("insert into Transactions values('"+f+"','"+amt+"','"+ memo+"')");
                    JOptionPane.showMessageDialog(null, "Transaction Successful");
                    new Send(f);
                    setVisible(false);
                }
            }
        }catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Pay("");
    }


}
