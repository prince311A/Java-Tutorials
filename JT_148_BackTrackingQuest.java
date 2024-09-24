public class JT_148_BackTrackingQuest {
    // Problem 1) (LEET-CODE 2596) Check Knight tour Configuration
    static boolean helper(int[][]board,int row,int col,int num){
        int n = board.length;
        if(board[row][col]== (n*n)-1) return true ;
        // 2 up 1 left
        int i = row-2;
        int j = col-1;
        if(i>=0 && j>=0 && board[i][j]==num+1)return helper(board,i,j,num+1);
        // 2 up 1 right
        i = row-2;
        j = col+1;
        if(i>=0 && j<board.length && board[i][j]==num+1) return helper(board,i,j,num+1);
        // 2 down 1 right
        i = row+2;
        j = col+1;
        if(i<board.length && j<board.length && board[i][j]==num+1)return helper(board,i,j,num+1);
        // 2 down 1 left
        i = row+2;
        j = col-1;
        if(i<board.length && j>=0 && board[i][j]==num+1)return helper(board,i,j,num+1);
        // 2 left 1 up
        i = row-1;
        j = col-2;
        if(i>=0&& j>=0 && board[i][j]==num+1)return helper(board,i,j,num+1);
        // 2 left 1 down
        i = row+1;
        j = col-2;
        if(i<board.length && j>=0 && board[i][j]==num+1)return helper(board,i,j,num+1);
        // 2 right 1 up
        i = row-1;
        j = col+2;
        if(i>=0&& j<board.length && board[i][j]==num+1)return helper(board,i,j,num+1);
        // 2 right 1 down
        i = row+1;
        j = col+2;
        if(i<board.length && j<board.length && board[i][j]==num+1)return helper(board,i,j,num+1);
        return false;
    }
    static boolean knightTourConfiguration(int[][]board){
        if(board[0][0]!=0)return false;
        return helper(board,0,0,0);
    }
//    ********************************************************************************
    // Problem 2)  find the maximum number of nights(ghode)  we can place  in Chess or n*m matrix
    static int maxNight = -1; // this variable is for maximum number of night can be placed in a grid or board
    public static boolean isSafe(char[][] board,int row,int col){
        int n = board.length;
        // 2 up 1 left
        int i = row-2;
        int j = col-1;
        if(i>=0 && j>=0 && board[i][j]=='K')return false;
        // 2 up 1 right
        i = row-2;
        j = col+1;
        if(i>=0 && j<board.length && board[i][j]=='K')return false;
        // 2 down 1 right
        i = row+2;
        j = col+1;
        if(i<board.length && j<board.length && board[i][j]=='K')return false;
        // 2 down 1 left
        i = row+2;
        j = col-1;
        if(i<board.length && j>=0 && board[i][j]=='K')return false;
        // 2 left 1 up
        i = row-1;
        j = col-2;
        if(i>=0&& j>=0 && board[i][j]=='K')return false;
        // 2 left 1 down
        i = row+1;
        j = col-2;
        if(i<board.length && j>=0 && board[i][j]=='K')return false;
        // 2 right 1 up
        i = row-1;
        j = col+2;
        if(i>=0&& j<board.length && board[i][j]=='K')return false;
        // 2 right 1 down
        i = row+1;
        j = col+2;
        if(i<board.length && j<board.length && board[i][j]=='K')return false;
        return true;
    }
    static void maxKnightInNxNmatrix(char[][] board,int row,int col,int num){ // num is number of knights
        if(row==board.length){
            for(int i =0;i<board.length;i++){
                for(int j = 0;j<board.length;j++){
                    System.out.print(board[i][j]); // this print all the configuration where knight can be placed
                }
                System.out.println();
            }
            System.out.println();
          maxNight =   Math.max(maxNight,num);
            return;
        }
       else if(isSafe(board,row,col)){
            board[row][col] = 'K';
            if(col!=board.length-1)maxKnightInNxNmatrix(board,row,col+1,num+1);
            else maxKnightInNxNmatrix(board,row+1,0,num+1);
            board[row][col] = 'x'; // back tracking
        }
            if(col!=board.length-1){
                maxKnightInNxNmatrix(board,row,col+1,num);
            }else {
                maxKnightInNxNmatrix(board,row+1,0,num);
            }
    }

    public static void main(String[] args) {
        int arr[][] = { //true
                {0,11,16,5,20},
                {17,4,19,10,15},
                {12,1,8,21,6},
                {3,18,23,14,9},
                {24,13,2,7,22}
        };
        int arr1[][] = { // false
                {0,3,6},
                {5,8,1},
                {2,7,4}
        };
//        System.out.println(knightTourConfiguration(arr1));
      int n = 2;
        char[][] board = new char [n][n];
        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                board[i][j] = 'x';
            }
        }
        maxKnightInNxNmatrix(board,0,0,0);
        System.out.println(maxNight); // this variable is for maximum number of night can be placed in a grid or board

    }
}
