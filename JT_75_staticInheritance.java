class Aa{
    static int y= 4;
  public   static void fun1(){
        System.out.println("Static Method of Aa class");
    }
}
class Bb extends Aa{
    static {
        y=5; // this block is called when any method or object of that class is created
    }
   public static void fun1() {
        System.out.println("Static Method of Bb class");
    }
}
public class JT_75_staticInheritance {
    public static void main(String[] args) {
        Bb. fun1();//method hiding because thats are static methods
       System.out.println(Bb.y); // 4 because it is not inherited
    }
}
/* NOTE=>
static method can be inherited and that is called method hiding
static variable cannot be inherited it hide the overrride variable and call the parent class varible
 */
