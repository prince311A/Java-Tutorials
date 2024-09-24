public class JT_145_BackTrackingQuest {
    // Back Tracking is used with recursion
  /* Problem'1:Rat in a Maze ()
  * Rat in a Maze – A maze is an N*N binary matrix of 0locks where the upper left 0lock is known as the Source
block, and the lower rightmost block is known as the Destination 0lock. If we consider the maze, then maze[0]
[0] is the source, and maze[N-1][N-1] is the destination. Our main task is to reach the destination from the
source. We have considered a rat as a character that can move either forward or downwards.
In the maze matrix, a few dead 0locks will 0e denoted by 0 and active blocks will 0e denoted by 1. A rat can
move only in the active blocks.
  */
// Count how many possible ways are there for mouse to reach the destination
    // mouse can either move its right or down
    public static int maze(int sr,int sc,int er,int ec){ // two direction
        // base case
        if(sr<0 || sc<0)return 0;
        if(sr>er || sc>ec) return 0;
        if(sr == er && sc==ec){
            return 1;
        }
        // move right
       int rightWays =  maze(sr,sc+1,er,ec);
        // move down
       int downWays =  maze(sr+1,sc,er,ec);
        return rightWays+downWays;
    }
    // printing the directions
    static void print(int sr,int sc,int er,int ec,String s){ // two direction
        if(sr<0 || sc<0)return ;
        if(sr>er || sc>ec) return ;
        if(sr == er && sc==ec){
            System.out.println(s);
            return;
        }
        // move right
         print(sr,sc+1,er,ec,s+ "R");
        // move down
         print(sr+1,sc,er,ec,s+ "D");
    }
    // This is valid and good solution when mouse can move only right or down
    // But what if we want mouse can move all four directions up,down,right,left
    // then we have to use the concept of backtracking
    static int countFourDirectionMaze(int sr,int sc,int er,int ec, boolean[][] isVisited){  // four direction

        // base case
        if(sr<0 || sc<0)return 0;
        if(sr>er || sc>ec) return 0;
        if(isVisited[sr][sc]==true)return 0;
        if(sr == er && sc==ec){
            return 1;
        }
        isVisited[sr][sc] = true;
        // move right
        int rightWays =countFourDirectionMaze(sr,sc+1,er,ec,isVisited);
        // move down
        int downWays =countFourDirectionMaze(sr+1,sc,er,ec,isVisited);
        // move left
        int leftWays =countFourDirectionMaze(sr,sc-1,er,ec,isVisited);
        // move up
        int upWays =countFourDirectionMaze(sr-1,sc,er,ec,isVisited);
        // backtracking
        isVisited[sr][sc] = false;
         return rightWays+downWays+upWays+leftWays;
    }
//printing directions
    static void fourDirectionMaze(int sr,int sc,int er,int ec,String s, boolean[][] isVisited){  // four direction
        // base case
        if(sr<0 || sc<0)return ;
        if(sr>er || sc>ec) return ;
        if(isVisited[sr][sc]==true)return ;
        if(sr == er && sc==ec){
            System.out.println(s);
            return ;
        }
        isVisited[sr][sc] = true;
        // move right
                fourDirectionMaze(sr,sc+1,er,ec,s+"R",isVisited);
        // move down
                fourDirectionMaze(sr+1,sc,er,ec,s+"D",isVisited);
        // move left
                fourDirectionMaze(sr,sc-1,er,ec,s+"L",isVisited);
        // move up
                fourDirectionMaze(sr-1,sc,er,ec,s+"U",isVisited);
        // backtracking
        isVisited[sr][sc] = false;
//         return rightWays+downWays+upWays+leftWays;
    }
    // Problem 2-: It is same like maze path , we have given an 2D array having only 0 and 1  which shows where we can move
    // 0 means we cant move through there , and 1 is a sign of we can move through there
    // One move this is given we can either move to right or downwards
    static void printWithDeadMazeInTwoDirection(int sr,int sc,int er,int ec,String s,int[][]maze){ // two direction
        if(sr<0 || sc<0)return ;
        if(sr>er || sc>ec) return ;
        if(maze[sr][sc]==0){
            return;
        }
        if(sr == er && sc==ec){
            System.out.println(s);
            return;
        }
        // move right
        printWithDeadMazeInTwoDirection(sr,sc+1,er,ec,s+ "R",maze);
        // move down
        printWithDeadMazeInTwoDirection(sr+1,sc,er,ec,s+ "D",maze);
    }
    // Solving with dead maze when mouse can move in all four direction
    static void printWithDeadMazeInFourDirection(int sr,int sc,int er,int ec,String s, boolean[][] isVisited,int[][] maze){  // four direction
        // base case
        if(sr<0 || sc<0)return ;
        if(sr>er || sc>ec) return ;
        if(maze[sr][sc]==0){
            return;
        }
        if(isVisited[sr][sc])return ;
        if(sr == er && sc==ec){
            System.out.println(s);
            return ;
        }
        isVisited[sr][sc] = true;
        // move right
        printWithDeadMazeInFourDirection(sr,sc+1,er,ec,s+"R",isVisited,maze);
        // move down
        printWithDeadMazeInFourDirection(sr+1,sc,er,ec,s+"D",isVisited,maze);
        // move left
        printWithDeadMazeInFourDirection(sr,sc-1,er,ec,s+"L",isVisited,maze);
        // move up
        printWithDeadMazeInFourDirection(sr-1,sc,er,ec,s+"U",isVisited,maze);
        // backtracking
        isVisited[sr][sc] = false;
    }
    public static void main(String[] args) {
        // for 2,2-> 2 : 3,3->6 :  4,4->20
        int rows = 3;
        int cols = 4;
//        int count = maze(0,0,rows-1,cols-1); // mouse can either move its right or down
//        System.out.println(count);

//        print(0,0,rows-1,cols-1,"");// mouse can either move its right or down

         // This is valid and good solution when mouse can move only right or down
        // But what if we want mouse can move all four directions up,down,right,left
        // then we have to use the concept of backtracking

        boolean[][] isVisited = new boolean[rows][cols];
//        fourDirectionMaze(0,0,rows-1,cols-1,"",isVisited); // mouse can move all right,left,up down

        boolean[][] isVisited1 = new boolean[rows][cols];
//       int count =countFourDirectionMaze(0,0,rows-1,cols-1,isVisited1);// mouse can move all right,left,up down
//        System.out.println(count);

        int[][]maze ={
                {1,0,1,1},
                {1,1,1,1},
                {1,1,0,1},
        };
//        printWithDeadMazeInTwoDirection(0,0,rows-1, cols-1,"",maze); // mouse can either move its right or down
        boolean[][] isVisited2 = new boolean[rows][cols];
        printWithDeadMazeInFourDirection(0,0,rows-1,cols-1,"",isVisited2,maze);
    }
}
