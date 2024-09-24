import java.lang.reflect.Array;
import java.util.Arrays;

public class JT_79_looppattern {
    static void printtable(int n){
        for(int i = 1;i<=10;i++) {
            for (int j = n; j <= 10; j++) {
                System.out.print("  "+j * i);
            }
            System.out.println();
        }
    }
    static void rightTriangle(int x){
        for(int i = 1;i<=x;i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void invertedRightTriangle(int x){
        for(int i = 1;i<=x;i++) {
            for (int j = x; j > i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
    static void oppsiteTriangle(){
        for(int i = 1;i<=5;i++) {
            for (int j = i; j<= 5; j++) {
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static int countNegatives(int[][] grid) {
        int count= 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]<0){
                    count++;
                }
            }
        }
        return count;
    }
    static void sortedSquares(int[] nums) {
        int i= 0;
        int j = nums.length-1;
        int ans[] = new int[nums.length];
        int dst = 0;
        while(i<j){
            if(Math.abs(nums[i])<Math.abs(nums[j])){
                ans[dst++] = nums[j]*nums[j];
                j--;
            }
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                ans[dst++] = nums[i]*nums[i];
                i++;
            }
        }
        for(int k = 0;k<ans.length;k++){
            System.out.print(" "+ans[k]);
        }
    }
    static int sumOfUnique(int[] nums) {
//       if(nums.length==1){
//            return nums[0];
//        }
//       else  if(nums[0]==nums[nums.length-1]){
//           return 0;
//       }
        int sum = 0;
       for(int i = 0;i<nums.length;i++){
           int count =0;
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
//                    nums[j]=0;
//                    nums[i] = 0;
                    count++;
                    break;
                }
            }
           if(count==0){
               sum = sum+nums[i];
           }
        }
        for(int k = 0;k<nums.length;k++){
            System.out.print(" "+nums[k]);
        }
        System.out.println();

//        for(int k =0;k<nums.length;k++){
//            sum = sum+nums[k];
//        }
      return sum;
    }
    public static void main(String[] args) {
          printtable(5);
        //  rightTriangle(5);
        // invertedRightTriangle(6);
//        oppsiteTriangle();
        int[][] grid = {{5,1,0}, {-5,-5,-5}};
     // int count =  countNegatives(grid);
//        System.out.println(count);
        int ar[] = {-4,-1,0,3,10};
    //   sortedSquares(ar);
        int ar1[] = {10,6,9,6,9,6,8,7};
        int ar2[] = {1,2,2,2,2,3,4,2,5};
   //    int count = sumOfUnique(ar1);
     //   System.out.println("The sum is "+count);


    }

}