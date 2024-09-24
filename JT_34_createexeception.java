import java.util.Scanner;

class MyException extends Exception{
    public String toString(){
        return "Cant divide with zero";
    }
}
public class JT_34_createexeception {
    public static void main(String[] args) {
        int a = 1000;
        int b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for the division with a");
        b = sc.nextInt();
        if (b == 0) {
            try {
                throw new MyException();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println("Program is finished");
        }

        else{
            System.out.println("The value of a divide by b is "+ (a/b));
        }
//        ----------------------------------------------------------------------------------------------
        EDemo p = new EDemo();
        try {
            p.fun1(15);
        }
        catch(Exception e){
            System.out.println(e);
        }
        System.out.println("Have a nice day");
//        -----------------------------------------------------------------------------------------------
    }
}
//------------------------------------------------------------------------------------------------
class EDemo{
    public void fun1(int age) {
        if (age < 18) {
            throw new ArithmeticException();
        }
        else{
            System.out.println("You are eligible for voting");
        }

    }
}
//---------------------------------------------------------------------------------------------------------