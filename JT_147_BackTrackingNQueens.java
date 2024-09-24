import java.util.ArrayList;
import java.util.List;

public class JT_147_BackTrackingNQueens {
    // NQueens (LEET-CODE)
    static boolean isSafe(char[][]board,int row,int col){
        int n = board.length;
        // check row wise
        for(int i =0;i<n;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        // check column wise
        for(int i =0;i<n;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // now we have to check diagonally that 'Q' is already placed or not
        // north-east check
        int i = row;
        int j = col;
        while (i>=0 && j<n){
            if(board[i][j]=='Q')return false;
            i--;
            j++;
        }
        // south-east check
        i = row;
        j = col;
        while (i<n && j<n){
            if(board[i][j]=='Q')return false;
            i++;
            j++;
        }
        //south-west check
        i = row;
        j = col;
        while (i<n && j>=0){
            if(board[i][j]=='Q')return false;
            i++;
            j--;
        }
        // north-west check
        i = row;
        j = col;
        while (i>=0 && j>=0){
            if(board[i][j]=='Q')return false;
            i--;
            j--;
        }
        return true;
    }
    static void nQueen(char[][]board,int row){
        if(row==board.length){
            for(int i =0;i<board.length;i++){
                for(int j = 0;j<board.length;j++){
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for(int j = 0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                 nQueen(board,row+1);
                 board[row][j] = 'X';
            }
        }
    }
//    *************************************************different function************************
    static void helper( char[][] board ,int row, List<List<String>> ans ){
        if(row==board.length){
           // copy 2D board/array of list to string
            List<String> ll = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                String str = "";
                for(int j = 0;j<board.length;j++){
                    str+=board[i][j];
                }
                ll.add(str);
            }
            ans.add(ll);
            return;

        }
        for(int j = 0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                helper(board,row+1,ans);
                board[row][j] = '.'; //back tracking
            }
        }
    }
    public static List<List<String>> solveNQueen(int n){
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                board[i][j] = '.';
            }
        }
        helper(board,0,ans);
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board.length;j++){
                board[i][j] = 'X';
            }
        }
//        nQueen(board,0);
//        ******************************************************************
      List<List<String>> ans =   solveNQueen(n);
        System.out.println(ans);
    }
}
