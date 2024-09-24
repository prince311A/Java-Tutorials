import java.util.Scanner;
// NOTE: This is a basic  calculator program which perform the basic four arithmetic operations.
public class JT_81_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char c = 'c';
        while(c==c){
        System.out.println("Enter the first integer number:");
        double a = sc.nextDouble();
        System.out.println("Enter the second integer number:");
        double b = sc.nextDouble();
        System.out.println("For addition press '1' ");
        System.out.println("For subtraction press '2' ");
        System.out.println("For multiplication press '3' ");
        System.out.println("For division press '4' ");
        int x = sc.nextInt();
        if(x==1){
            System.out.println("The addition of given inputs is:"+(a+b));
        }
       else if(x==2){
            System.out.println("The substation of given inputs is:"+(a-b));
        }
        else if(x==3){
            System.out.println("The multiplication of given inputs is:"+(a*b));
        }
        else if (x==4) {
            System.out.println("The division of given inputs is:" + (a / b));
        }
        else{
            System.out.println("Invalid Input");
        }
            System.out.println("Press 'c' to continue,To exit press 'o':");
            char y = sc.next().charAt(0);
            if(y=='o'){
                break;
            }
        }
        System.out.println("Program is ended");

    }
}
