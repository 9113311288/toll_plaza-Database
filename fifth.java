package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class fifth extends  JFrame implements ActionListener
{
    JTextField t1, t2, t3,t4,t5;
    String tollId;
    fifth(String tollid,String platenum,String type,String date,String time)
    {
        super("SEARCH DETAILS");
        tollId=tollid;
        setSize(400, 600);
        setResizable(false);
        Container c = getContentPane();
        setLayout(new GridLayout(7, 2));
        setBackground(Color.BLACK);
        JPanel tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l = new JLabel("SEARCH DETAILS");
        l.setFont(new Font("Impact", Font.BOLD, 32));
        l.setForeground(Color.black);
        tp.add(l);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l1 = new JLabel("TOLL ID");
        l1.setForeground(Color.black);
        t1 = new JTextField(tollid, 20);
        t1.setEditable(false);
        tp.add(l1);
        tp.add(t1);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l2 = new JLabel("CAR ");
        l1.setForeground(Color.black);
        t2 = new JTextField(platenum, 20);
        tp.add(l2);
        tp.add(t2);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l3 = new JLabel("MODEL");
        l3.setForeground(Color.black);
        t3 = new JTextField(type, 20);
        tp.add(l3);
        tp.add(t3);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l4 = new JLabel("DATE");
        l4.setForeground(Color.black);
        t4 = new JTextField(date, 20);
        t4.setEditable(false);
        tp.add(l4);
        tp.add(t4);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JLabel l5 = new JLabel("TIME");
        l5.setForeground(Color.black);
        t5 = new JTextField(time, 20);
        tp.add(l5);
        tp.add(t5);
        add(tp);
        tp = new JPanel();
        tp.setBackground(Color.white);
        JButton b3 = new JButton("DELETE");
        JButton b1 = new JButton("MODIFY");
        b1.setName("modify");
        b3.setName("delete");
        b1.addActionListener(this);
        b3.addActionListener(this);
        tp.add(b1);
        tp.add(b3);
        add(tp);
        setVisible(true);
    }

    public static void main(String[] args)
    {
       // new fifth();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn =(JButton) e.getSource();
        if(btn.getName().equals("modify"))
        {
            PreparedStatement stm=null;
            System.out.println("hello");
            String sql ="update vehicle set platenumber= ?,vehicletype=? ,time=? where tollid=?";
            try
            {
                stm = first.App.con.con.prepareStatement(sql);
                stm.setString(1, t2.getText());
                stm.setString(2, t3.getText());
                stm.setString(3, t5.getText());
                stm.setString(4, tollId);
                if(stm.executeUpdate()==0)
                {
                    JOptionPane.showMessageDialog(this,"Please try again");
                    return;
                }
                JOptionPane.showMessageDialog(this,"Details updated");
                this.dispose();
            }
            catch (Exception ee)
            {
                System.out.println(ee);
            }

            return;
        }
        try
        {

            if(first.App.con.sql.executeUpdate("delete from vehicle where tollid='"+tollId+"'")>0)
            {
                first.App.con.sql.executeUpdate("delete from gate where tollid='"+tollId+"'");
                JOptionPane.showMessageDialog(this,"Deleted");
                this.dispose();
                return;
            }
            JOptionPane.showMessageDialog(this,"please try again");

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}

