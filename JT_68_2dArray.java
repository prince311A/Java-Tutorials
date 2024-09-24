import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.SortedMap;

public class JT_68_2dArray {
//    Q1) check whether the element is present or not in given array
    static int findElement(int ar[][],int target) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (ar[i][j] == target) {
                    System.out.println("The row is " + i);
                    System.out.println("The column is " + j);
                    return 0;
                }
            }
        }
        return -1;
    }
//    Q2) Given a 2D array for n rows and m columns, reverse each row.
    static void reverseRow(int ar[][]){
        for (int i = 0; i < 3; i++) {
            int k =0;
            int l = 2;
            while(k<l){
                int temp = ar[i][k];
                ar[i][k] = ar[i][l];
                ar[i][l] = temp;
                k++;
                l--;
            }
            }
        System.out.println("The reverse of the rowArray:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void multiplication2dArray(int A[][],int r1,int c1, int B[][],int r2,int c2){
        if(r2!=c1){
            System.out.println("Multiplication Not possible ");
            return;
        }
        int result[][] = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for(int k = 0;k<r2;k++){
                    result[i][j] += (A[i][k] *B[k][j]);
                }
            }
        }
        System.out.println("The multiplication of the A and B is:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }


    }
    public static void main(String[] args) {
        int arr[][] = {{3,8,0},{6,3,2},{12,9,10}};
        int target = 12;

     //int result =   findElement(arr,target);
//     if(result==-1) {
//         System.out.println(result);
//     }
//     ***********************************************************************************
        int arr1[][] = {{1,2,3},{6,7,8},{9,10,11}};
  //   reverseRow(arr1);
//     **********************************************************************************
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the row of matric A ");
        int r1 = sc.nextInt();
        System.out.println("Enter the column of matrix A ");
        int c1 = sc.nextInt();
        System.out.println("Enter the row of matric B ");
        int r2 = sc.nextInt();
        System.out.println("Enter the column of matrix B ");
        int c2 = sc.nextInt();
        int A[][] = new int[r1][c1];
        int B[][] = new int[r2][c2];
        System.out.println("Enter the element of matrix A:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
               A[i][j] = sc.nextInt();
                }
            }
        System.out.println("Enter the element of matrix B:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                B[i][j] = sc.nextInt();
            }
        }
      //  multiplication2dArray(A,r1,c1,B,r2,c2);
    }

}
