package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class SignUp extends JFrame implements ActionListener {


    JDateChooser dateChooser;

    JButton next,back;
    JRadioButton r1, r2, r3, m1,m2,m3,a1,a2;

    Random rand = new Random();
    long f4 = (rand.nextLong() % 9000L) +1000L;
    String f = " " + Math.abs(f4);

    JTextField textUname, textFname, textEmail, textAddress, textCity,textZip, textNo, psswod,aaNo, ppNo, repswod, useName;

    JComboBox comboSal;
    SignUp() {



        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/back.png"));
        Image image = icon.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(image);
        JLabel l = new JLabel(icon1);
        l.setBounds(0, 0, 900, 600);
        add(l);

        JLabel label1 = new JLabel("APPLICATION FORM NO:"+f);
        label1.setBounds(320,10,250,20);
        label1.setForeground(Color.GREEN);
        label1.setFont(new Font("Times New Roman",Font.ITALIC,15));
        l.add(label1);



        JLabel label3 = new JLabel("PERSONAL INFORMATION");
        label3.setBounds(325,35,250,18);
        label3.setForeground(Color.white);
        label3.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(label3);



        JLabel userName = new JLabel("NAME");
        userName.setBounds(50,80,250,18);
        userName.setForeground(Color.white);
        userName.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(userName);

        textUname = new JTextField();
        textUname.setBounds(200,80,220,20);
        textUname.setForeground(Color.BLACK);
        textUname.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(textUname);



        JLabel fName = new JLabel("FATHER'S NAME");
        fName.setBounds(50,110,250,18);
        fName.setForeground(Color.white);
        fName.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(fName);

        textFname = new JTextField();
        textFname.setBounds(200,110,220,20);
        textFname.setForeground(Color.BLACK);
        textFname.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(textFname);



        JLabel dOB = new JLabel("D.O.B");
        dOB.setBounds(50,140,250,18);
        dOB.setForeground(Color.white);
        dOB.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(dOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(200,140,220,20);
        dateChooser.setForeground(Color.BLACK);
        dateChooser.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(dateChooser);



        JLabel gender = new JLabel("GENDER");
        gender.setBounds(50,170,250,18);
        gender.setForeground(Color.white);
        gender.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(gender);

        r1 = new JRadioButton("Male");
        r1.setForeground(Color.white);
        r1.setBackground(new Color(0x194871));
        r1.setBounds(200,170,75,18);
        l.add(r1);

        r2 = new JRadioButton("Female");
        r2.setForeground(Color.white);
        r2.setBackground(new Color(0x194871));
        r2.setBounds(275,170,75,18);
        l.add(r2);

        r3 = new JRadioButton("Others");
        r3.setForeground(Color.white);
        r3.setBackground(new Color(0x194871));
        r3.setBounds(350,170,75,18);
        l.add(r3);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);



        JLabel eadd = new JLabel("EMAIL ADDRESS");
        eadd.setBounds(50,200,250,18);
        eadd.setForeground(Color.white);
        eadd.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(eadd);

        textEmail = new JTextField();
        textEmail.setBounds(200,200,220,20);
        textEmail.setForeground(Color.BLACK);
        textEmail.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(textEmail);



        JLabel ms = new JLabel("MARITAL STATUS");
        ms.setBounds(50,230,250,18);
        ms.setForeground(Color.white);
        ms.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(ms);

        m1 = new JRadioButton("Single");
        m1.setBackground(new Color(0x194871));
        m1.setForeground(Color.white);
        m1.setBounds(200,230,75,18);
        l.add(m1);

        m2 = new JRadioButton("Married");
        m2.setForeground(Color.white);
        m2.setBackground(new Color(0x194871));
        m2.setBounds(275,230,75,18);
        l.add(m2);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(m1);
        bg1.add(m2);
        bg1.add(m3);



        JLabel add = new JLabel("ADDRESS");
        add.setBounds(50,260,250,18);
        add.setForeground(Color.white);
        add.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(add);

        textAddress = new JTextField();
        textAddress.setBounds(200,260,220,20);
        textAddress.setForeground(Color.BLACK);
        textAddress.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(textAddress);



        JLabel city = new JLabel("CITY, STATE");
        city.setBounds(50,290,250,18);
        city.setForeground(Color.white);
        city.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(city);

        textCity = new JTextField();
        textCity.setBounds(200,290,220,20);
        textCity.setForeground(Color.BLACK);
        textCity.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(textCity);



        JLabel zip = new JLabel("ZIPCODE, COUNTRY");
        zip.setBounds(50,320,250,18);
        zip.setForeground(Color.white);
        zip.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(zip);

        textZip = new JTextField();
        textZip.setBounds(200,320,220,20);
        textZip.setForeground(Color.BLACK);
        textZip.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(textZip);



        JLabel atype = new JLabel("ACCOUNT TYPE");
        atype.setBounds(450,80,250,18);
        atype.setForeground(Color.white);
        atype.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(atype);

        a1 = new JRadioButton("Savings");
        a1.setBounds(600,80,75,18);
        a1.setBackground(new Color(0x194871));
        a1.setForeground(Color.white);
        a1.setFont(new Font("Times New Roman",Font.BOLD,14));
//        a1.addActionListener(this);
        l.add(a1);

        a2 = new JRadioButton("Current");
        a2.setBounds(675,80,75,18);
        a2.setBackground(new Color(0x194871));
        a2.setForeground(Color.white);
        a2.setFont(new Font("Times New Roman",Font.BOLD,14));
//        a2.addActionListener(this);
        l.add(a2);

        ButtonGroup bgg = new ButtonGroup();
        bgg.add(a1);
        bgg.add(a2);



        JLabel aNo = new JLabel("SOCIAL NO");
        aNo.setBounds(450,110,250,18);
        aNo.setForeground(Color.white);
        aNo.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(aNo);

        aaNo = new JTextField();
        aaNo.setBounds(600,110,220,20);
        aaNo.setForeground(Color.BLACK);
        aaNo.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(aaNo);



        JLabel paNo = new JLabel("EAD NO");
        paNo.setBounds(450,140,250,18);
        paNo.setForeground(Color.white);
        paNo.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(paNo);

        ppNo = new JTextField();
        ppNo.setBounds(600,140,220,20);
        ppNo.setForeground(Color.BLACK);
        ppNo.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(ppNo);



        JLabel inc = new JLabel("INCOME");
        inc.setBounds(450,170,250,18);
        inc.setForeground(Color.white);
        inc.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(inc);

        String[] income = {"less than 3000","3000-6000","6000-9000","more than 9000"};
        comboSal = new JComboBox(income);
        comboSal.setBounds(600,170,220,20);
        comboSal.setForeground(Color.BLACK);
        comboSal.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(comboSal);



        JLabel pNo = new JLabel("PHONE NO");
        pNo.setBounds(450,200,250,18);
        pNo.setForeground(Color.white);
        pNo.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(pNo);

        textNo = new JTextField();
        textNo.setBounds(600,200,220,20);
        textNo.setForeground(Color.BLACK);
        textNo.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(textNo);


        JLabel usName = new JLabel("USER NAME");
        usName.setBounds(450,230,250,18);
        usName.setForeground(Color.white);
        usName.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(usName);

        useName = new JTextField();
        useName.setBounds(600,230,220,20);
        useName.setForeground(Color.BLACK);
        useName.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(useName);



        JLabel psswd = new JLabel("PASSWORD");
        psswd.setBounds(450,260,250,18);
        psswd.setForeground(Color.white);
        psswd.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(psswd);

        psswod = new JTextField();
        psswod.setBounds(600,260,220,20);
        psswod.setForeground(Color.BLACK);
        psswod.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(psswod);



        JLabel repsswd = new JLabel("RE-ENTER");
        repsswd.setBounds(450,290,250,18);
        repsswd.setForeground(Color.white);
        repsswd.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(repsswd);

        repswod = new JTextField();
        repswod.setBounds(600,290,220,20);
        repswod.setForeground(Color.BLACK);
        repsswd.setFont(new Font("Times New Roman",Font.BOLD,14));
        l.add(repswod);



        next = new JButton("SUBMIT");
        next.setForeground(Color.BLACK);
        next.setBounds(280,390,250,30);
        next.addActionListener(this);
        l.add(next);

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
        if(e.getSource()==back){
            new Login(f);
            setVisible(false);
        }


        String form_no = f;
        String uname = textUname.getText();
        String fname = textFname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected()){
            gender = "Male";
        } else if (r2.isSelected()) {
            gender = "Female";
        }else if (r3.isSelected()) {
            gender = "Other";
        }
        String email = textEmail.getText();
        String mstatus = null;
        if(m1.isSelected()){
            mstatus = "Single";
        } else if (m2.isSelected()) {
            mstatus = "Married";
        }
//       } else if (m3.isSelected()) {
//            mstatus = "Others";
//        }
        String address = textAddress.getText();
        String city = textCity.getText();
        String zipcode = textZip.getText();
        String phone = textNo.getText();
        String accType = null;
        if(a1.isSelected()){
            accType = "Savings";
        } else if (a2.isSelected()) {
            accType = "Current";
        }
        String social = aaNo.getText();
        String ead = ppNo.getText();
        String income = (String) comboSal.getSelectedItem();
        String passwd = psswod.getText();
        String repasswd = repswod.getText();
        String uuName   =   useName.getText();


        try{

            if (textUname.getText().equals("") || textFname.getText().equals("") || textEmail.getText().equals("") || textAddress.getText().equals("") || textCity.getText().equals("") || textZip.getText().equals("") || textNo.getText().equals("") || textZip.getText().equals("") || dob.equals("") || gender.equals("") || zipcode.equals("") || phone.equals("") || mstatus.equals("") || accType.equals("") || aaNo.getText().equals("") || ppNo.getText().equals("") || psswod.getText().equals("") || repswod.getText().equals(""))  {
                JOptionPane.showMessageDialog(null, "Please enter all the details");
            } else if (!Objects.equals(psswod.getText(), repswod.getText())) {
                JOptionPane.showMessageDialog(null, "Password does not match");
            } else{
                Con con1 = new Con();
                String q1 = "insert into signUp values('"+form_no+"','"+uname+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+mstatus+"','"+address+"','"+city+"','"+zipcode+"')";
                String q2 = "insert into signUp2 values('"+form_no+"','"+accType+"','"+social+"','"+ead+"','"+income+"','"+phone+"','"+uuName+"','"+passwd+"')";
                String q3 = "insert into Login values('"+form_no+"','"+uuName+"','"+passwd+"')";
                con1.statement.executeUpdate(q1);
                con1.statement.executeUpdate(q2);
                con1.statement.executeUpdate(q3);
                new Page2(uname);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public static void main(String[] args) {
        new SignUp();
    }
}
