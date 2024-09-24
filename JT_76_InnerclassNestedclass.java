import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

// Inner class and outer class
// If Innerclass is a static class then to access inner class members there is no need to create object of outer class
// We cant directly access it by Outer.Inner obj = new Outer.Inner
// But for the non static class we have to create object of outer class then create object of inner class with the reference
// variable of outer class
 class Outer{
  static  class Inner{
        void fun1(){
            System.out.println("This is method of static inner class");
        }
    }
    class Inner1{
      void fun2(){
          System.out.println("This is method of non static inner1 class");
      }
    }
}
public class JT_76_InnerclassNestedclass {
    public static void main(String[] args) {
        Outer.Inner obj = new Outer.Inner();// access static class
        obj.fun1();
        Outer obj1 = new Outer();// access not static class
        Outer.Inner1 obj2 = obj1.new Inner1();
        obj2.fun2();

    }
// If inner class is non static then it can access the member of outer class
    //But static class cannot acess the non static member of outer class
    // Important ==> Inner class can be private protected public or default
    //But outer class must be default or public (only one public class in a file)

}

