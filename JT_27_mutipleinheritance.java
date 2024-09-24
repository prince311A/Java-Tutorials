interface Interr1{
    int a = 25;
    void fun1();
}
interface Interr2 extends Interr1{
    int b = 50;
    void fun2();
}
class X{
    void fun3(){
        System.out.println("Fun3 of class X");
    }
}
class Y extends X implements Interr2{ // This is multiple inheritance in java
    @Override
    public void fun1(){
        System.out.println("This is fun1() of interface 1");
    }
    public void fun2(){
        System.out.println("This is fun2() of interface 2");
    }
}
public class JT_27_mutipleinheritance {
    public static void main(String[] args) {
        Y p = new Y();
        p.fun1();
        p.fun2();
        p.fun3();
    }
}
