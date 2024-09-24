abstract class absrt{
    abstract void fun1();
    void fun2(){
        System.out.println("hello");
    }

}
class absrt1 extends absrt{
    void fun1(){
        System.out.println("This is the method of abstract class");
    }
    void fun3(){
        System.out.println("hii");
    }

}
public class JT_25_abstactclass {
    public static void main(String[] args) {
        absrt1 p = new absrt1();
//        p.fun1();
 //   absrt p = new absrt1();
    p.fun1();
    p.fun2();
    p.fun3();
//    p.fun3();//invalid because only access base class methods
    }
}
//NOTE ==> Abstract class can be made without abstract method but if a class have abstract method than the class should be abstract