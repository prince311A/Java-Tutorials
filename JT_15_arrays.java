import java.util.*;
public class JT_15_arrays {
    public static void main(String[] args) {
        int a[] = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the five numbers");
        for (int i = 0;i<=4;i++){
            a[i] = sc.nextInt();
        }
        for (int i = 4;i>=0;i--){
            System.out.println(a[i]);
        }
        System.out.println(a[4]);
        // or
        int b[] = {10,20,30};
        System.out.println(b[1]);
        System.out.println(a.length);// to find the length of array
    // OR by foreach loop
        for (int ele:b) {
            System.out.println(ele);
        }
        String c[] = new String[3];
        System.out.println("Enter three name");
        for(int i=0;i<3;i++){
            c[i] = sc.next();
        }
        for(int i=0;i<3;i++){
            System.out.println(c[i]);
        }
    }
}