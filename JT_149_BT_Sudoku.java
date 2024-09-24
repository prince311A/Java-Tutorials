public class JT_149_BT_Sudoku {
    // Problem 1) (LEETCODE 36) Valid Sudoku
    static boolean isValid(char[][]sudoku,int row,int col,char num){
      // check whole row
        for(int i = 0;i<sudoku.length;i++){
            if(sudoku[row][i]==num)return false;
        }
        // check whole column
        for(int i = 0;i<sudoku.length;i++){
            if(sudoku[i][col]==num)return false;
        }
        // check 3x3 matrix
        int sRow = row/3*3; // typical maths to find the find index of every 3x3 matrix
        int sCol = col/3*3; // typical maths to find the find index of every 3x3 matrix
        for(int i = sRow;i<sRow+3;i++){
            for(int j= sCol;j<sCol+3;j++){
                if(sudoku[i][j]==num){
                    return false;
                }
            }
        }

        return true;
    }
static boolean validSudoku(char[][]sudoku){
    int n = sudoku.length;
    for(int i =0;i<n;i++){
        for(int j =0;j<n;j++){
            if(sudoku[i][j]=='.')continue;
            char num = sudoku[i][j];
            sudoku[i][j] = 'V'; // this is to check the elements except this , means not included in checking
         if(!isValid(sudoku, i, j,num)){
             return false;
         }
            sudoku[i][j] = num;
        }
    }
    return true;
}
//************************************************************************
    // Problem 2) LeetCode 37. Sudoku Solver
static void sodukuSolver(char[][] sudoku,int row,int col, char[][] ans){
        if(row==9){
            for(int i =0;i<9;i++){
                for(int j = 0;j<9;j++){
                    ans[i][j] = sudoku[i][j];
                }
            }
            return;
        }
   else if(sudoku[row][col]!='.'){
            if(col!=8)sodukuSolver(sudoku,row,col+1,ans);
            else sodukuSolver(sudoku,row+1,0,ans);
        }
        else{ //sudoku[row][col] =='.'
            for(char ch = '1';ch<='9';ch++){
               if( isValid(sudoku,row,col,ch)){
                    sudoku[row][col] = ch;
                   if(col!=8)sodukuSolver(sudoku,row,col+1,ans);
                   else sodukuSolver(sudoku,row+1,0,ans);
                   sudoku[row][col] ='.'; // backtracking
                }
            }
        }
}
    public static void main(String[] args) {
       char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};
//        System.out.println(validSudoku(sudoku));
//        *********************************************************************
        // SUDOKU solver
        char [][]sudoku1 ={{'5','3','.','.','7','.','.','.','.'},
    {'6','.','.','1','9','5','.','.','.'},
    {'.','9','8','.','.','.','.','6','.'},
    {'8','.','.','.','6','.','.','.','3'},
    {'4','.','.','8','.','3','.','.','1'},
    {'7','.','.','.','2','.','.','.','6'},
    {'.','6','.','.','.','.','2','8','.'},
    {'.','.','.','4','1','9','.','.','5'},
    {'.','.','.','.','8','.','.','7','9'}};
        char[][] ans = new char[9][9];
       sodukuSolver(sudoku1,0,0,ans);
        for(int i =0;i<9;i++){
            for(int j = 0;j<9;j++){
                System.out.print(ans[i][j]+",");
            }
            System.out.println();
        }
    }
}

