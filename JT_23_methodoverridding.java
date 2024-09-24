import org.w3c.dom.ls.LSOutput;

class BBase{
    void fun1(){
        System.out.println("This is method of BBase class");
    }
}
class DDerived extends BBase{
    void fun1(){
        super.fun1();
        System.out.println("This is the method of DDerived class");
    }
}
public class JT_23_methodoverridding {
    public static void main(String[] args) {
        DDerived p = new DDerived();
        p.fun1();
    }
}
