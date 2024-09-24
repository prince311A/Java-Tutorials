class A{
    void fun1(){
        System.out.println("This is fun1() of A class");
    }
  void swagat(){
      System.out.println("Swagat of class A");
  }
}
class B extends A{
    void fun1(){
        System.out.println("This is fun1() of B class");
    }
    void greet(){
        System.out.println("Greet of class B");
    }
}
public class JT_24_dynamicdispatch {
    public static void main(String[] args) {
//        A obj = new A();// valid
//        B obj1 = new B(); // valid
        A obj3 = new B(); // imp this is also valid
//        B obj4 = new A(); // unvalid
        obj3.fun1();// call the method of derived class
        obj3.swagat();//valid access the base class method
//       obj3.greet();// unvalid cant access the derived class method
            }
}
