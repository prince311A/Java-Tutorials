import java.util.ArrayList;
import java.util.List;

public class JT_69_2dArray {
//    Q1) Write to program to obtain the transpose of the given matrix
    static void transposeMatrix(int ar[][],int r,int c){
        int ans[][] = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                ans[i][j] = ar[j][i];
            }
        }
        for (int i = 0; i <c;  i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    // Lets try it in same array to make it transpose (optimised approch)
    static void transposeMatrixInArray(int ar[][],int r,int c){
        for (int i = 0; i < c; i++) {
            for (int j = i; j < r; j++) {
              int temp =  ar[i][j];
              ar[i][j]= ar[j][i];
              ar[j][i] = temp;
            }
        }
        System.out.println("Transpose of Matrix");
        for (int i = 0; i <c;  i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
    }
//    Q2) Rotate a matrix 90degree cloclwise (matrix should be square matrix)
    static void rotateMatrixClock(int ar[][],int r,int c){
        int ans[][] = new int[c][r];
        for(int i =0;i<c;i++){
            for(int j=0;j<r;j++){
                ans[i][j] = ar[j][i];
            }
        }
        System.out.println("Transpose of Matrix");
        for (int i = 0; i <c;  i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        for(int i =0;i<r;i++){
            int k =0;
            int l = c-1;
            while(k<l){
                int temp = ans[i][k];
                ans[i][k] = ans[i][l];
                ans[i][l] = temp;
                k++;
                l--;
            }
        }
        System.out.println("Matrix after rotation 90degree of Matrix");
        for (int i = 0; i <c;  i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
//    Q3) Return the n rows of pascal triangle
    static void pascalTriangle(int n){
        int ans[][] = new int[n][];
        for(int i =0;i<n;i++){
            ans[i] = new int[i+1];
            ans[i][0]= ans[i][i] = 1;
            for(int j = 1;j<i;j++){
                ans[i][j] = ans[i-1][j] + ans[i-1][j-1];
            }
        }
        for (int i = 0; i <n;  i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    // my approach in return as list (LEETCODE 118)
        public static List<List<Integer>> generate(int numRows) {
            int ans[][] = new int[numRows][];
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                ans[i] = new int[i + 1];
                ans[i][0] = ans[i][i] = 1;
                for (int j = 1; j < i; j++) {
                    ans[i][j] = ans[i - 1][j] + ans[i - 1][j - 1];
                }
            }
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j <= i; j++) {
                    temp.add(ans[i][j]);
                }
                list.add(temp);
                temp = new ArrayList<>();
            }
            return list;
        }
        // more optimized
        public static List<List<Integer>> generateOptimized(int numRows) {
            int ans[][] = new int[numRows][];
            List<List<Integer>> list = new ArrayList<>();
            for(int i =0;i<numRows;i++){
                ans[i] = new int[i+1];
                ans[i][0] = ans[i][i] =1;
                List<Integer>temp = new ArrayList<>();
                temp.add(1);
                int x =0;
                for(int j = 1;j<i;j++){
                    ans[i][j] = ans[i-1][j]+ ans[i-1][j-1];
                    temp.add(ans[i][j]);
                    x=1;
                }
                if(i==1){
                    temp.add(1);
                }
                if(x==1){
                    temp.add(1);
                }

                list.add(temp);
            }
            return list;
        }
    //    Q2) Rotate a matrix 90degree Anticloclwise (matrix should be square matrix)
    static void rotateMatrixAntiClock(int ar[][],int r,int c){
        int ans[][] = new int[c][r];

        for(int i =0;i<r;i++){
            int k =0;
            int l = c-1;
            while(k<l){
                int temp = ar[i][k];
                ar[i][k] = ar[i][l];
                ar[i][l] = temp;
                k++;
                l--;
            }
        }
        System.out.println("First reverse the matrix row wise");
        for (int i = 0; i <c;  i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
        for(int i =0;i<c;i++){
            for(int j=0;j<r;j++){
                ans[i][j] = ar[j][i];
            }
        }
        System.out.println("Matrix after rotation 90degree of Matrix ");
        for (int i = 0; i <c;  i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{11,22,33},{4,5,6}};
        int r =3;int c = 3;
     //  transposeMatrix(arr,r,c);
     //   transposeMatrixInArray(arr,r,c);
        int arr1[][] = {{1,2,3},{11,22,33},{4,5,6}};
//     rotateMatrixClock(arr1,r,c);
        int n = 5;
       pascalTriangle(n);
        int arr2[][]={{1,2,3},{4,5,6},{7,8,9}};
     //   rotateMatrixAntiClock(arr2,r,c);

    }
}
/*
* Jagged Array ==> Jagged Array is a two dimensional array where rows is specified but column is not
* like int [][]arr = new int [3][];
* */