public class JT_70_2dArray {
//    Q1) Return all the element of 2d matrix in spriral order clockwise
    static void spiral2d(int ar[][]){
        int r = 3;int c = 4;
        int ans[] = new int[12];
        int dst =0;
        int toprow =0;
        int botmrow = r-1;
        int leftcol =0;
        int rightcol = c-1;
        while(dst<12){
            for(int j= leftcol;j<=rightcol && dst<12;j++){// leftcol to rightcol
                ans[dst++] = ar[toprow][j];
            }
            toprow++;

            for(int i= toprow;i<=botmrow ;i++) {
                ans[dst++] = ar[i][rightcol];// toprow to bottom row}
            }
            rightcol--;
            for(int j= rightcol;j>=leftcol && dst<12;j--) {
                ans[dst++] = ar[botmrow][j];//rightcol to leftcol }
            }
            botmrow--;
            for(int i= botmrow;i>=toprow && dst<12;i--) {
                ans[dst++] = ar[i][leftcol];//bottom row to toprow}
            }
            leftcol++;

        }
        System.out.println("Spiral order traversal in clockwiswe");
        for(int i =0;i<dst;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }
//    Q2) Given an positive integer n, generates mxn matrix filled with the number in spiral order
    static void fillSpiralMatrix(int n){
        int ans[][] = new int[n][n];
        int r = n;int c = n;
        int dst =1;
        int toprow =0;
        int botmrow = r-1;
        int leftcol =0;
        int rightcol = c-1;
        while(dst<=n*n){
            for(int j= leftcol;j<=rightcol && dst<=n*n;j++){// leftcol to rightcol
                ans[toprow][j] = dst;
                dst++;
            }
            toprow++;

            for(int i= toprow;i<=botmrow && dst<=n*n ;i++) {
                ans[i][rightcol] = dst;
                dst++;// toprow to bottom row}
            }
            rightcol--;
            for(int j= rightcol;j>=leftcol && dst<=n*n;j--) {
                ans[botmrow][j] = dst;//rightcol to leftcol }
            dst++;
            }
            botmrow--;
            for(int i= botmrow;i>=toprow && dst<=n*n;i--) {
                ans[i][leftcol] = dst;//bottom row to toprow}
            dst++;
            }
            leftcol++;

        }
        System.out.println("Generated matrix in spiral order");
        for (int i = 0; i <c;  i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    //    Q3)Return all the element of 2d matrix in spriral order anticlockwise
    public static void antiSpiral(int ar[][]){
        int ans[] = new int[12];
        int r=3;
        int c=4;
        int dst = 0;
        int toprow = 0;
        int leftcol=0;
        int rightcol=c-1;
        int bottomrow=r-1;
        while(dst<12){
            for(int i=toprow;i<=bottomrow&& dst<12;i++){
                ans[dst] = ar[i][leftcol];
                        dst++;
            }
            leftcol++;
            for(int j=leftcol;j<=rightcol&& dst<12;j++){
                ans[dst] = ar[bottomrow][j];
                dst++;
            }
            bottomrow--;
            for(int i=bottomrow;i>=toprow&& dst<12;i--){
                ans[dst] = ar[i][rightcol];
                dst++;
            }
            rightcol--;
            for(int j=rightcol;j>=leftcol&& dst<12;j--){
                ans[dst] = ar[toprow][j];
                dst++;
            }toprow++;

        }
        System.out.println("Spiral order traversal in anticlockwiswe");
        for(int i =0;i<dst;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4},{6,7,8,9},{11,12,13,14}};
      // spiral2d(arr);
      //  fillSpiralMatrix(5);
      //  antiSpiral(arr);
        System.out.println(arr.length);
    }
}
