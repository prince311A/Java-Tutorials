import java.awt.*;
import java.awt.event.*;

// create frame by inheritence
class Awt extends Frame implements ActionListener {
    Button b;
    TextField t;
    Awt(){
        b = new Button("Submit");
        t = new TextField(10);
        t.setBounds(30,70,100,30);
        b.setBounds(30,100,80,30);
       b.addActionListener(this);//Event handling

        add(b);
        add(t);

        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setBackground(Color.blue);

    }
public void actionPerformed(ActionEvent e){// Event handling
        t.setText("PRINCE");
    System.out.println("very Good");
}
}
public class JT_40_awt1 {
    public static void main(String[] args) {

        Awt p = new Awt();
    }
}
