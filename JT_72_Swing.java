import javax.swing.*;
import java.awt.*;
public class JT_72_Swing extends JFrame {
    JButton b;
    JTextField t;
    JLabel l1;
    JT_72_Swing(String s){
        super(s);
    }
    JT_72_Swing(){}
    public void setComponents(){
        b = new JButton("Summit");
        l1 = new JLabel("Hello World");
        t = new JTextField();
        l1.setBounds(30,20,150,20);
        t.setBounds(30,50,100,30);
        b.setBounds(30,80,100,30);
        setLayout(null);
        add(l1);add(t);add(b);

    }

    public static void main(String[] args) {
        JT_72_Swing s = new JT_72_Swing("Swing");
        s.setComponents();
        s.setVisible(true);
        s.setSize(400, 400);
        s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
