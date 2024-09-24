import java.util.*;
public class JT_13_aarayproblem {
    public static void main(String[] args) {
        int a[]= new int[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ten numbers");
        for (int i = 0;i<10;i++){
            a[i] = sc.nextInt();
        }
        int b;
        System.out.println("Enter the number to check it is present or not");
        b = sc.nextInt();
        int c = 0;
        for(int i =0;i<10;i++) {
            if (b == a[i]) {
                c = 1;
                break;
            }
        }
            if(c==1) {
                System.out.println("Number found");
            }
            else {
                System.out.println("Number not found");
            }

        }
        }


