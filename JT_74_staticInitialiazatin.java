public class JT_74_staticInitialiazatin {
    // Static initialization block can only excess static members
    private static int a ;
    public static void check(){
        System.out.println("Lets check static block executes before it or not");
    }
    static{
        // Static block only execute one time whether object is created one or more time it executes only one time
        // it executes when object is created or when we acess any static member variable or method
        // No return,this and super keyword can be used in static block
        System.out.println("Hello I am static intialization block a = "+a);
        a = 5;
    }
    JT_74_staticInitialiazatin(){
        System.out.println("Constrictor a = "+a);
    }

    public static void main(String[] args) {
//        JT_74_staticInitialiazatin p = new JT_74_staticInitialiazatin();
        JT_74_staticInitialiazatin q  = new JT_74_staticInitialiazatin();
//        OR
        q.check();
    }
}
