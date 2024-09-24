import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class JT_71_2dArray {
    //    Q1) Sum of rectangle formed by the coordinates of 2d matrix
    public static void rectangleSum(int ar[][], int r, int c, int l1, int r1, int l2, int r2) {
        if (l1 < l2 && r1 < r2 && l1 < r && l2 < r && r1 < c && r2 < c) {
            int sum = 0;
            for (int i = l1; i <= l2; i++) {
                for (int j = r1; j <= r2; j++) {
                    sum = sum + ar[i][j];
                }
            }
            System.out.println("The total sum under the coordinates are " + sum);
        } else {
            System.out.println("Invalid input");
            return;
        }
    }
    // Lets try in optimised approch without traversing every time find prefix sum
    public  static void prefixRectabgleSum(int ar[][],int r ,int c ,int l1, int r1, int l2, int r2) {
        int row = 0;
        while (row < r){
            for (int j = 1; j < c; j++) {
                ar[row][j] = ar[row][j] + ar[row][j -1];

            }
        row++;
    }
        System.out.println("Here is the Prefix Rowwise Matrix");
        for (int i = 0; i <r;  i++) {
            for (int j = 0; j <c; j++) {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
        //Lets calculate
        int add = 0;
        for(int i=l1;i<=l2;i++) {
            if (r1 > 0) {
                add = add + (ar[i][r2] - ar[i][r1 - 1]);
            } else {
                add = add+ar[i][r2];
            }
        }
        System.out.println("The sum of the rectangle is "+add);
    }
    // Best approch without traversing every time
    /*step 1) create new array and find prefix row wise
            step 2) then find prefix column wise of that matxic
            then calculate the sum easily*/
    public static void prefixRowColMatrixRectangle(int ar[][],int r,int c, int l1, int r1, int l2, int r2){
        int ans[][] = new int[r][c];
        // make prefix matrix rowise
        for(int i =0;i<r;i++){
            ans[i][0] =ar[i][0];
            for (int j=1;j<c;j++){
                ans[i][j] = ar[i][j]+ans[i][j-1];
            }
        }
        System.out.println("Here Is The Prefix matrix Rowwise");
        for (int i = 0; i <r;  i++) {
            for (int j = 0; j <c; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        // Now change this new matrix to prefix sum columnwise
        for(int i =1;i<r;i++){
            for (int j=0;j<c;j++){
                ans[i][j] = ans[i][j]+ans[i-1][j];
            }
        }
        System.out.println("Here Is The Prefix matrix Columnwise");
        for (int i = 0; i <r;  i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        //Now caluate the rectangle sum formed by coordinates in matrix without any traversing (loop)
        int sum = ans[l2][r2]-ans[l1-1][r2]-ans[l2][r1-1]+ans[l1-1][r1-1];
        System.out.println("The calculated sum of the rectangle formed by matrix coordinates is "+sum);
    }
    public static void main(String[] args) {
    int arr[][]={
            {1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25},
    };
     System.out.println("Enter the coordiantes of rectangle l1,r1 and l2,r2");
        Scanner sc= new Scanner(System.in);
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();
        // rectangleSum(arr,5,5,l1,r1,l2,r2);
        // prefixRectabgleSum(arr,5,5,l1,r1,l2,r2);
        prefixRowColMatrixRectangle(arr,5,5,l1,r1,l2,r2);
    }
}
