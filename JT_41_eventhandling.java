import java.awt.event.*;
import java.awt.*;

class MyEveent extends Frame implements ActionListener {
    Button b1, b2;
    TextField t1, t2, t3;
    Label l1, l2, l3;

  public MyEveent() {
         b1 = new Button("+");
       Button  b2 = new Button("-");
         t1 = new TextField(10);
        t2 = new TextField(10);
        t3 = new TextField(10);
        l1 = new Label("Enter first number");
        l2 = new Label("Enter another number");
        l3 = new Label("Result is ");
        setLayout(new FlowLayout());
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);
        add(l3);
        add(t3);
        setVisible(true);
        setSize(800, 600);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int n1 = Integer.parseInt(t1.getText());
//            System.out.println(t1.getText());
            int n2 = Integer.parseInt(t2.getText());
            int r = 0;
            if(e.getSource() == b1) {
                r = n1 + n2;
            } else {
                r = n1 - n2;
            }
//           String s= String.valueOf(r); also valid
            String s = Integer.toString(r);
            t3.setText(s);
        } catch (Exception g) {
            System.out.println(g);
        }
    }
}
public class JT_41_eventhandling {
    public static void main(String[] args) {
        MyEveent p = new MyEveent();
//        p.setSize(800,600);// not use we can define it in constructor
//        p.show();// similar to setvisible(true);

    }
}

