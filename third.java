package Project;
import javax.swing.*;
import java .awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Random;
public class third extends JFrame implements ActionListener {
    public static JTextField t1, t2, t3,d1,ti;
    String gate;
    String userid;
    third(String gate, String userid) {
        super("REGISTRATION");
        this.gate=gate;
        this.userid=userid;
        setSize(500, 800);
        setResizable(true);
        Container c = getContentPane();
        c.setBackground(Color.WHITE);
        c.setLayout(new GridLayout(7, 2));
        JPanel tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l1 = new JLabel("CAR REGISTRATION");
        l1.setForeground(Color.black);
        l1.setFont(new Font("Impact", Font.BOLD, 32));
        tp.add(l1);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l2 = new JLabel("PLATE NUMBER");
        l2.setForeground(Color.black);
        t1 = new JTextField("", 20);
        tp.add(l2);
        tp.add(t1);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l3 = new JLabel("VEHICLE TYPE");
        l3.setForeground(Color.black);
        t2 = new JTextField("", 20);
        tp.add(l3);
        tp.add(t2);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l5 = new JLabel("TOLL ID");
        l2.setForeground(Color.black);
        t3 = new JTextField(tollGen(), 20);
        tp.add(l5);
        tp.add(t3);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l4 = new JLabel("DATE");
        l4.setForeground(Color.black);
        LocalDate dat=LocalDate.now();
        String date=dat.getYear()+"-"+dat.getMonthValue()+"-"+dat.getDayOfMonth();
        d1 = new JTextField(date, 20);
        tp.add(l4);
        tp.add(d1);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l6 = new JLabel("TIME");
        l6.setForeground(Color.black);
        LocalTime tim=LocalTime.now();
        String time=tim.getHour()+":"+tim.getMinute()+":"+tim.getSecond();
        ti = new JTextField(time, 20);
        tp.add(l6);
        tp.add(ti);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JButton b1 = new JButton("ADD");
        b1.addActionListener(this);
        tp.add(b1);
        add(tp);
        setVisible(true);
    }
    public String tollGen() {
        Random r = new Random();
        String x = "";
        for (int i = 0; i <= 3; i++)
        {
            int k = r.nextInt(26) + 65;
            x += (char) k;

        }
        x += (r.nextInt(9) + 1);

        x += (r.nextInt(9) + 1);
        for (int i = 0; i < 2; i++) {

            int k = r.nextInt(26) + 65;
            x += (char) k;
        }
        return x;
    }
    public static void main(String[] args) {
        new third("9","xyx");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String plat=t1.getText();
        String type=t2.getText();
        String tollid=t3.getText();
        String date=d1.getText();
        String time=ti.getText();
        String sql="INSERT INTO VEHICLE VALUES(?,?,?,?,?) ";
        PreparedStatement stm=null;
        try {
            stm=  first.App.con.con.prepareStatement(sql);
            stm.setString(1,tollid);
            stm.setString(2,plat);
            stm.setString(3,type);
            stm.setString(4,date);
            stm.setString(5,time);
           if( stm.executeUpdate()==0)
           {
               JOptionPane.showMessageDialog(this,"");
               return;
           }
            JOptionPane.showMessageDialog(this,"inserted");
            sql="INSERT INTO GATE VALUES(?,?,?) ";
            stm=null;
            stm=  first.App.con.con.prepareStatement(sql);
            stm.setString(2,tollid);
            stm.setString(1,gate);
            stm.setString(3,userid);
            stm.executeUpdate();
               this.dispose();
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(this,"Please try again");
        }
    }
}


