abstract class pen{
   abstract void write();
    abstract void refill();
}
class pen1 extends pen{
    void write(){
        System.out.println("Pen is writting");
    }
    void refill(){
        System.out.println("Pen is refilling");
    }
    void changenib(){
        System.out.println("Changing nib");
    }
}
public class JT_28_abstractpratice {
    public static void main(String[] args) {
        pen1 p = new pen1();
        p.write();
        p.refill();
        p.changenib();
    }
}
