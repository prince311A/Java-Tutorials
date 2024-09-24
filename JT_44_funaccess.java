public class JT_44_funaccess {
    void fun1(){
        System.out.println("Hii i am fun()1");
    }
    public static void fun2(){
        System.out.println("Hii i am fun2()");
    }
    // now we can call the function  by two ways
    // 1) make static function
    // 2) create object of class
    public static void main(String[] args) {
        JT_44_funaccess p = new JT_44_funaccess();
        p.fun1();
        fun2();
        int []a = new int[3];
        System.out.println(a.length);
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        a[0]= 99;
//        a[3] = 50;// invalid due to length of array
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);
        System.out.println(a[0]);

    }
}
