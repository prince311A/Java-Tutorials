import java.awt.*;
import java.awt.event.*;

class Awt2 implements ActionListener {
    TextField t;
    Button b;
    Awt2(){
        Frame p = new Frame("AWT");
        Button b = new Button("submit");
        TextField t = new TextField(15);
        b.setBounds(20,100,50,20);
        t.setBounds(20,50,150,50);
       b.addActionListener(this);
        p.add(b);
        p.add(t);
        p.setSize(500,500);
        p.setLayout(null);
        p.setVisible(true);
        p.setBackground(Color.blue);
    }
    public void actionPerformed(ActionEvent e){
        t.setText("hello");
    }
}
public class JT_40_awt2 {
    public static void main(String[] args) {
        Awt2 s = new Awt2();
//        s.actionPerformed(ActionEvent e);
        // not handling event by creating object of frame class
    }
}
