class Base{
    private  int a,b;
    Base(){
        System.out.println("This is base class default constructor");
    }
    Base(int x,int y){
        a = x;
        b = y;
        System.out.println("This is paramertrised constructor of base "+a+" AND b = "+b);
    }
}
class derived extends Base{
    private int c,d;
//    derived(){
////        super();
//      super(2,5);
//        System.out.println("This is derived class default constructor");
//    }
    derived(int x,int y){
//        super(2,8);
//        super();
        c = x;
        d = y;
        System.out.println("This is paramertrised constructor of derived c = "+c+" AND d = "+d);
    }
}
public class JT_22_const_insuperclass {
    public static void main(String[] args) {
//        Base s = new Base(2,5);
        // if there no constructor in base class then jvm add a constructor with no statement
        // And super keyword use to call the constructor of base class
       // error through error when sub class call the constructor which is not available in base class
        derived p = new derived(2,5);
    }

}
