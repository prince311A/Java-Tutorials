@FunctionalInterface
interface Lambda{
    // Functional Interface --> is the interface which has only one abstract class
    // To access or override that abstract method we use lambda expression
    // Here also like anonymous class there is no need to write extra class to override abstract method of interface
    // Because of lamda expression we can say that java is functional programming language
    // lamda expression is only use with functional interface
    // lamda expression is a function, benefit is that we can pass this function as a argument of another function
    // If body of lamda expression contains only one line than curly braces are optional
    // there is no need to mention datatype in argument of expression java compiler is smart enough
    // No name, No modifer, No Return type in lamda expression
    // It is anonymous function
    void method1(int x,int y);
}
public class JT_56_lambdaexpression {
    public static void main(String[] args) {
        Lambda p = (c,d)-> {
            System.out.println("I am method 1 of lambda interface: "+c*d);
        };// this is lambda expression
        p.method1(4,2);
    }
}
// We can create object of class that implement interface.
// Ex-> Interface obj = new ImplementClassOfInterface,this can only access all the overridden methods of interface
// This is called dynamic dispatch (IMP)