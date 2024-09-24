 interface inter1{
    int a = 50;
    void fun1();
    default void fun2(){
        System.out.println("Default method in interface"); // This is the default method of interface that can define inside of the interface
    }
}
class Inter implements inter1{
 public int a = 255;// valid because we can override final variable in implemented class
public void fun1(){
        System.out.println("a = "+a);
        System.out.println("This is interface fun1()");
    }

}
public class JT_26_interface {
    public static void main(String[] args) {
        Inter a = new Inter();
        a.fun1();
        a.fun2();// valid beacuse of default method

    }
}
