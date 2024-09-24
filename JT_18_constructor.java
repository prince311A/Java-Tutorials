public class JT_18_constructor {
   private int a,b;
    JT_18_constructor(){
        System.out.println("This is default constructor");
    }
    JT_18_constructor(int a,int b){
//        a = x;
//        b = y;
        this.a=a;
        this.b=b;
    }

    void show(){
        System.out.println("a = "+a);
        System.out.println(("b = "+b));
    }
    static  public void  main(String k[]){
        JT_18_constructor Q = new JT_18_constructor();
        JT_18_constructor W = new JT_18_constructor(10,5);
        W.show();
    }
}
