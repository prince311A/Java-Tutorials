import java.util.*;
public class JT_14_array2d {
    public static void main(String[] args) {
  /*      int a[][] = new int[2][2];
        System.out.println("Enter the numbers for the matrics");
        Scanner sc = new Scanner(System.in);
        for (int r = 0;r<2;r++){
            for (int c=0;c<2;c++)
            a[r][c] = sc.nextInt();
        }
        for (int r = 0;r<2;r++){
            for (int c=0;c<2;c++) {
                System.out.print(a[r][c]);

            System.out.println();
        }*/
        // Another way
       int[][]x = {{1,2},{3,4}}; // two dimensional array
        System.out.println(x[1][0]);
        System.out.println(x[1][1]);

        int d[][] = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        // How to find the length of the row and column ?
        System.out.println(d.length); // how many rows are present in matrix or 2d array
        System.out.println(d[0].length); // how many elements present in row i,e column


    }
}
