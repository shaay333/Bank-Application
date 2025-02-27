package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Totalbalance extends JFrame implements ActionListener {

    String f;
    JLabel label1;
    JButton button1;
    public Totalbalance(String f) {
        this.f = f;

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image image = icon.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel l = new JLabel(icon1);
        l.setBounds(0, 0, 900, 600);
        add(l);

        label1 = new JLabel("Your Balance is $");
        label1.setBounds(200,180,250,50);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l.add(label1);

        JLabel label2 = new JLabel("");
        label2.setBounds(450,180,250,50);
        label2.setForeground(Color.green);
        label2.setFont(new Font("Times New Roman",Font.BOLD,30));
        l.add(label2);

        button1 = new JButton("OK");
        button1.setBounds(380,270,120,40);
        button1.setForeground(Color.BLACK);
        button1.setFont(new Font("Times New Roman",Font.BOLD,25));
        button1.addActionListener(this);
        l.add(button1);

        int balance = 0;
        try{
            Con c = new Con();
            ResultSet resultSet = c.statement.executeQuery("select * from Transactions where uuName = '" + f + "'");
            while (resultSet.next()) {
                if (resultSet.getString("mem").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amt"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amt"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        label2.setText(""+balance);


        setLayout(null);
        setSize(900,600);
        setLocation(400,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Send(f);

    }

    public static void main(String[] args) {

        Totalbalance tb = new Totalbalance("");
    }


}
