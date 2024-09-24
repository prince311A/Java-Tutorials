import java.util.*;
public class JT_17_static {
        int a;
     static int bc;
        void fun1(){
            a = 10;
            bc= 20;
        }
        static void fun2(){
            bc = 100;
//a = 50; though error cant access
        }
        void showdata(){
            System.out.println(a);
            System.out.println(bc);

        }
        public static void main(String k[]){
            JT_17_static a = new JT_17_static();
            a.fun1();
            a.showdata();
            JT_17_static b = new JT_17_static();
            b.fun2();
            b.showdata();
//            ****************************************SOME KEY POINTS***********************************
//        To acess any static method in java under main function we can direct call the method like :
            fun2();
//            To acess any static variable in java under main function we can direct access the variable  like :
            bc=5;
//            No need to access the static member by the object of class either can do or not
        }
    }

