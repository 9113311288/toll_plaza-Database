package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class first extends JFrame implements ActionListener {
    public JTextField t1;
    public JPasswordField p1;
    Connect con=null;
   static first App;
    first()
    {
        super("login");
        setSize(300, 300);
        setResizable(true);
        Container c = getContentPane();
        c.setBackground(Color.black);
        c.setLayout(new GridLayout(4, 1));
        JPanel tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l = new JLabel("LOGIN");
        l.setFont(new Font("Impact", Font.BOLD, 32));
        l.setForeground(Color.black);
        l.setFont(new Font("Impact", Font.BOLD, 32));
        tp.add(l);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l1 = new JLabel("USERID");
        l1.setForeground(Color.black);
        t1 = new JTextField(20);
        tp.add(l1);
        tp.add(t1);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l2 = new JLabel("PASSWORD");
        l2.setForeground(Color.black);
        p1 = new JPasswordField(20);
        tp.add(l2);
        tp.add(p1);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JButton b1 = new JButton("SIGN IN");
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        tp.add(b1);
        add(tp);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String userid = t1.getText();
        String password = String.valueOf(p1.getPassword());
        System.out.println(userid + " " + password);
        if (userid.length() < 3 || password.length() < 3)
        {
            JOptionPane.showMessageDialog(this, "Please enter user name and password");
            return;
        }
        try {
            if(con==null)
                con = new Connect();
            ResultSet rs=con.sql.executeQuery(" select * from users where username='"+userid+"' and password='"+password+"'");
            if(rs.next())
                new second(userid);
            else
                JOptionPane.showMessageDialog(this, "invalid user");
        }
        catch (Exception ee) {
            con=null;
            System.out.println(ee);
            JOptionPane.showMessageDialog(this, "server down");
        }
    }
    public static void main(String[] args)
    {
        App=new first();
    }
}
