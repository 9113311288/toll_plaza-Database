package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class second extends JFrame implements ActionListener {
    private JButton b1,b2,b3,b4,b5;
    String userid;
    second( String userid)
    {
        super("gates");
        this.userid=userid;
        setSize(400, 400);
        setResizable(false);
        Container c = getContentPane();
        c.setBackground(Color.black);
        c.setLayout(new GridLayout(4,1));
        JPanel tp=new JPanel();
        tp.setBackground(Color.white);
        JLabel ll= new JLabel("gates");
        ll.setForeground(Color.black);
        ll.setFont(new Font("Impact",Font.BOLD,32));
        tp.add(ll);
        add(tp);
        tp=new JPanel();
        tp.setBackground(Color.white);
        b1=new JButton("gate1");
        b1.addActionListener( this);
        b2=new JButton("gate2");
        b2.addActionListener(this);
        tp.add(b1);
        tp.add(b2);
        add(tp);
        tp=new JPanel();
        tp.setBackground(Color.white);
        b3=new JButton("gate3");
        b3.addActionListener(this);
        b4=new JButton("gate4");
        b4.addActionListener(this);
        tp.add(b3);
        tp.add(b4);
        add(tp);
        tp=new JPanel();
        tp.setBackground(Color.white);
        b5=new JButton("search");
        b5.addActionListener(this);
        tp.add(b5);
        add(tp);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        //new second();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1)
       {
            new third("1",userid);
       }
       if(e.getSource()==b2)
        {
            new third("2",userid);
        }
       if(e.getSource()==b3)
        {
            new third("3",userid);
        }
        if(e.getSource()==b4)
        {
            new third("4",userid);
        }
        if(e.getSource()==b5)
        {
            new fourth();
        }
    }
}
