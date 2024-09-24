import java.util.* ;
public class JT_02_formula {
        public static void main(String k[]){
            double r,h,area;
// area = r = h = 0.0f;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the radius of the cylinder");
            r = sc.nextDouble();
            System.out.println("Enter the height of the cylinder");
            h = sc.nextDouble();
            area = 3.14*(r*r)*h;
            System.out.println("Your Percentage is = "+area);
        }
    }

