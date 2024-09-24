import java.util.Arrays;

public class JT_189_SetZeros {
    // LEETCODE. 73 set Zeros
    // Approach 1.--> most complex.... storing the coordinate or zero than one by one call the fun() that make r and c =0
    static void putZero(int[][] matrix, int row, int col) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
//                    System.out.println(i+" "+j);
                if (i == row && j == col) {
//                         change rows to rows
                    for (int k = j - 1; k >= 0; k--) {
                        matrix[i][k] = 0;
                    }
//                    change column to 0
                    for (int l = i - 1; l >= 0; l--) {
                        matrix[l][j] = 0;
                    }


                    for (int l = j + 1; l < matrix[0].length; l++) {
                        matrix[i][l] = 0;
                    }
//
                    for (int k = i + 1; k <= matrix.length - 1; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
    static void setZeros(int [][] matrix){
        // count zeros
        System.out.println("**********************");
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    count++;
                }
            }
        }
        // make an array we store co-ordinate of all zeros
        int idx = 0;
        int[][] ans = new int[count][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    ans[idx][0] = i;
                    ans[idx][1] = j;
                    idx++;
                }
            }
        }
        // make them zeros
        for(int i=0;i<ans.length;i++) {
            putZero(matrix,ans[i][0],ans[i][1]);
        }
        // printing final matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
//    **************************************************************************************************
    // Approach 2 --> Good Approach ..... make all the row and column which have zero to Int.MinVal than retraverse
    // covert them to zero
static void putMinValue(int[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
//                    System.out.println(i+" "+j);
            if (matrix[i][j] ==0) {
//                         change rows to rows
                for (int k = j - 1; k >= 0; k--) {
                    if(matrix[i][k]!=0){
                        matrix[i][k] = Integer.MIN_VALUE;
                    }

                }
//                    change column to 0
                for (int l = i - 1; l >= 0; l--) {
                    if(matrix[l][j]!=0){
                        matrix[l][j] = Integer.MIN_VALUE;
                    }

                }


                for (int l = j + 1; l < matrix[0].length; l++) {
                    if(matrix[i][l]!=0){
                        matrix[i][l] = Integer.MIN_VALUE;
                    }

                }
//
                for (int k = i + 1; k <= matrix.length - 1; k++) {
                    if(matrix[k][j]!=0){
                        matrix[k][j] = Integer.MIN_VALUE;
                    }

                }
            }
        }
    }
}
    static void setZeroQuiteGood(int [][]matrix){
        putMinValue(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == Integer.MIN_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println("*****************");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
//    Approach 3--> Using two arrays marking the row and col which have 0
    static void setZeroBetterApproach(int[][]matrix){
        int row[] = new int[matrix.length];
        int col[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("**************************************");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(col[j]==1 || row[i]==1){
                    matrix[i][j]=0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    // Approach 4--> without making extra array use the 0th col and 0th row
    static void setZeroMostOptimized(int[][] matrix){
        // for col = matrix[0][j]
        // for row = matrix[i][0]
        int col0 = 1;
        // marking row and col in matrix only
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix.length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    if(j!=0){
                        matrix[0][j] = 0;
                    }else{
                        col0 = 0;
                    }
                }
            }
        }
        // changing values to 0 without 0 row and 0 col
        for(int i =1;i<matrix.length;i++){
            for(int j =1;j<matrix.length;j++){
                if(matrix[0][j] ==0 || matrix[i][0] ==0){
                    matrix[i][j] = 0;
                }
            }
        }
        // now change Oth row
        if(matrix[0][0]==0){
            for(int i =0;i<matrix[0].length;i++){
                matrix[0][i] =0;
            }
        }
        // now change Oth col
        if(col0==0){
            for(int i =0;i<matrix.length;i++){
                matrix[i][0] =0;
            }
        }
        // print matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
//        int [][] matrix ={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//        int[][] matrix = {{0, 0, 0, 5}, {4, 3, 1, 4}, {0, 1, 1, 4}, {1, 2, 1, 3}, {0, 0, 1, 1}};

        // print given matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

//        setZeros(matrix);
        setZeroQuiteGood(matrix);
        setZeroBetterApproach(matrix);
        setZeroMostOptimized(matrix);



    }
}
