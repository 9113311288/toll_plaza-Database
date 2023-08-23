package Project;
import javax.swing.*;
import java .awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class fourth extends JFrame implements ActionListener {
    JLabel l1;
    JTextField t1;
    JButton b1;
    fourth()
    {
        super("SEARCH");
        setSize(300, 300);
        setResizable(true);
        Container c = getContentPane();
        c.setBackground(Color.black);
        c.setLayout(new GridLayout(3, 1));
        JPanel tp = new JPanel();
        l1 = new JLabel("SEARCH");
        l1.setFont(new Font("Impact", Font.BOLD, 32));
        tp.add(l1);
        add(tp);
        tp = new JPanel();
        l1= new JLabel("PLATE NUMBER");
        t1 = new JTextField("", 20);
        tp.add(l1);
        tp.add(t1);
        add(tp);
        tp = new JPanel();
        JButton b1 = new JButton("FIND");
        b1.addActionListener(this);
        tp.add(b1);
        add(tp);
        setVisible(true);
    }
    @Override
    public void actionPerformed (ActionEvent e)
    {
      Connect con=null;
      PreparedStatement p=null;
      ResultSet rs=null;
        String sql="select * from vehicle where platenumber='"+(t1.getText())+"'";
        try
        {
           rs=  first.App.con.sql.executeQuery(sql);
            if(rs.next())
            {
                new fifth(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
            else
            {
                JOptionPane.showMessageDialog(this,"No result found");
            }
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }
    public static void main(String[] args)
    {
        new fourth();
    }
}


