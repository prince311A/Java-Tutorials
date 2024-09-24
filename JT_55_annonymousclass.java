interface Annomy{
    /*
    * Anonymous class is a class  which is used to access the methods of interfaces without creating another class by
    * implementation of interface in other words there is no use of extra class to override the methods of interface
    * */
   void meth1();
    void meth2();
}
//class Demony implements Annomy{
//  public void meth1(){
//       System.out.println("I am meth1");
//   }
//  public void meth2(){
//      System.out.println("I am meth2");
//   }
//}
public class JT_55_annonymousclass {
    public static void main(String[] args) {
        Annomy p = new Annomy() { // anonymous class used here
            @Override
            public void meth1() {
                System.out.println("I am meth1");
            }

            @Override
            public void meth2() {
                System.out.println("I am meth2");

            }
        };
        p.meth1();
        p.meth2();
    }
}
