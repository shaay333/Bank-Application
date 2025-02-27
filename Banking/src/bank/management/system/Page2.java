package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page2 extends JFrame implements ActionListener {
    JButton button;
    String f;
   public Page2(String f) {

       this.f = f;

       ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
       Image image = icon.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
       ImageIcon icon1 = new ImageIcon(image);
       JLabel l = new JLabel(icon1);
       l.setBounds(0, 0, 900, 600);
       add(l);

       JLabel label1 = new JLabel("SIGNUP SUCCESSFUL!!");
       label1.setBounds(200,40,600,60);
       label1.setForeground(Color.BLACK);
       label1.setFont(new Font("Times New Roman",Font.ITALIC,55));
       l.add(label1);


//       JLabel label = new JLabel("APPLICATION FORM NO:"+f);
//       label.setBounds(320,10,250,20);
//       label.setForeground(Color.BLACK);
//       label.setFont(new Font("Times New Roman",Font.ITALIC,15));
//       l.add(label);

       button = new JButton("LOGIN");
       button.setBounds(380,300,200,30);
       button.setForeground(Color.BLACK);
       button.setFont(new Font("Times New Roman",Font.BOLD,25));
       button.addActionListener(this);
       l.add(button);

       setLayout(null);
       setSize(900,600);
       setLocation(400,200);
       setVisible(true);

   }

    @Override
    public void actionPerformed(ActionEvent e) {
       try{
           new Login(f);
           setVisible(false);
       } catch (Exception ex) {
           ex.printStackTrace();
       }


    }

    public static void main(String[] args) {
       new Page2("");
    }


}
