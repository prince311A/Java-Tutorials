import java.lang.reflect.Constructor;

public class JT_73_initializationblock{
    // Also called instance initializer
    // Initialization block are of two type 1) without static 2) static initialization block
    private int a;
    {
        // This is a initialisation block,it is like a function without any name and returntype
        // it is called every time when wev create any object of class,this block is added to the first line of the constructor
        // so that it executes before the constructor statements,it can be called every time when diff object is created
        // return keyword cannot be used ,but this or super can be used to initialisation block
        System.out.println("Hello I am initialisation block a = " + a);
        a = 69;
    }

    JT_73_initializationblock() {
        System.out.println("Constructor a = " + a);
    }

    public static void main(String[] args) {
        JT_73_initializationblock ib = new JT_73_initializationblock();
        JT_73_initializationblock ib1 = new JT_73_initializationblock();
    }
}