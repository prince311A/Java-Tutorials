import java.util.*;
public class JT_03_formula {
    public static void main(String k[]) {
        int a, b, c, d, e, sum, avg;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks of the students of five subjects");
         a = sc.nextInt();
         b = sc.nextInt();
         c = sc.nextInt();
         d = sc.nextInt();
         e = sc.nextInt();
         sum = a+b+c+d+e;
         avg = (sum*100)/500;
        System.out.println("The percentage of student is "+avg);
    }

}
