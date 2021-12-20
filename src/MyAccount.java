package farmers_friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.paint.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyAccount {

    String sname, semail, smob, scity;
    JLabel l0 = new JLabel("");
    JLabel name = new JLabel("NAME");
    JLabel email = new JLabel("EMAIL");
    JLabel mob = new JLabel("MOBILE NUMBER");
    JLabel city = new JLabel("CITY");
    JLabel name1 = new JLabel();
    JLabel email1 = new JLabel();
    JLabel mob1 = new JLabel();
    JLabel city1 = new JLabel();
    JLabel colon1 = new JLabel(":");
    JLabel colon2 = new JLabel(":");
    JLabel colon3 = new JLabel(":");
    JLabel colon4 = new JLabel(":");

    void MyAccount1() {
        Sidebar s = new Sidebar();
        ImagePanel panel = new ImagePanel(new ImageIcon("D:\\Tech\\Downloads\\g2.jpg").getImage());

        l0.setBounds(550, 100, 600, 30);

        name.setBounds(500, 200, 200, 30);
        email.setBounds(500, 280, 200, 30);
        mob.setBounds(500, 360, 200, 30);
        city.setBounds(500, 440, 200, 30);

        colon1.setBounds(720, 200, 10, 30);
        colon2.setBounds(720, 280, 10, 30);
        colon3.setBounds(720, 360, 10, 30);
        colon4.setBounds(720, 440, 10, 30);

        name1.setBounds(800, 200, 300, 30);
        email1.setBounds(800, 280, 300, 30);
        mob1.setBounds(800, 360, 300, 30);
        city1.setBounds(800, 440, 300, 30);

        name.setFont(s.font3);
        email.setFont(s.font3);
        mob.setFont(s.font3);
        city.setFont(s.font3);
        
//        name.setForeground(Color.white);
//        email.setForeground(Color.white);
//        mob.setForeground(Color.white);
//        city.setForeground(Color.white);

        s.f.add(name);
        s.f.add(email);
        s.f.add(mob);
        s.f.add(city);

        s.f.add(colon1);
        s.f.add(colon2);
        s.f.add(colon3);
        s.f.add(colon4);
        UserLogin obj=new UserLogin();
        String str = obj.str1;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/farmEasy", "root", "suba");
            PreparedStatement ps = con.prepareStatement("select * from register where email='"+str+"'");
            //ps.setString(1, str);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sname = rs.getString("name");
                semail = rs.getString("email");
                smob = rs.getString("mobile");
                scity = rs.getString("city");
            } else {

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        l0.setText("Welcome " + sname + "!!");
        name1.setText(sname);
        email1.setText(semail);
        mob1.setText(smob);
        city1.setText(scity);

        l0.setFont(s.font2);
        name1.setFont(s.font0);
        email1.setFont(s.font0);
        mob1.setFont(s.font0);
        city1.setFont(s.font0);
        l0.setForeground(java.awt.Color.CYAN);

//        name1.setForeground(Color.white);
//        email1.setForeground(Color.white);
//        mob1.setForeground(Color.white);
//        city1.setForeground(Color.white);

        s.f.add(l0);
        s.f.add(name1);
        s.f.add(email1);
        s.f.add(mob1);
        s.f.add(city1);

        s.f.getContentPane().add(panel);
        s.frame3();
        s.Sidebar1();
    }

    public static void main(String[] args) {
        MyAccount m = new MyAccount();
        m.MyAccount1();
    }

}
