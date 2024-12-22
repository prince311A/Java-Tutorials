import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JT_207_BitManipulation_Q2 {
    //    Q1) LEETCODE 78. Subsets Find all possible sets (IMP)
    static void findAllPossibleSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(result.get(i));
                temp.add(num);
                result.add(temp);
            }
        }
        System.out.println(result);
    }

    static void findAllPossibleSubsetsBitWise(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        int x = (int) Math.pow(2,nums.length);
        int size = nums.length;
        int x = 1 << size;
//        System.out.println(x);
        for (int i = 0; i < x; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if ((i & (1 << j)) > 0) {
                    temp.add(nums[j]);
                }
            }
            result.add(temp);
        }
        System.out.println(result);
    }

    //    29. Divide Two Integers
    static public int divide(int dividend, int divisor) {
       /*
       long x = (long)dividend / divisor;
        if (x > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (x < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)x;
        */
        if (divisor == dividend) return 1;
        boolean flag = true;
        if (divisor < 0 && dividend >= 0) flag = false;
        if (divisor >= 0 && dividend < 0) flag = false;

        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);

        long count = 0;
        long sum = dividend1;
        while (divisor1 <= sum) {
            int pow = 0;
            while ((divisor1 << (pow + 1)) <= sum) {
                pow++;
            }
            count = count + (1L << pow);
            sum = sum - (divisor1 << pow);
        }
        System.out.println("Count" + count);
        if (count > Integer.MAX_VALUE && flag) return Integer.MAX_VALUE;
        if (count > Integer.MAX_VALUE && !flag) return Integer.MIN_VALUE;
        if (count < Integer.MIN_VALUE && flag) return Integer.MIN_VALUE;
        if (count < Integer.MIN_VALUE && !flag) return Integer.MAX_VALUE;

        return flag ? (int) count : (int) -count;
    }

    //    Q3) Given an number, find the XOR of all number from 1 to n
//    ex -> 4==> 1^2^3^4
    static int xorAll(int x) {//imp
        /* divide in 4 blocks
        n =1, 1 = 1
        n =2, 1^2 = 3
        n =3, 1^2^3 = 0
        n =4, 1^2^3^4 = 4

        again for 5 6 7 8 ==> 1 7 0 8
        */
        if (x % 4 == 1) return 1;
        else if (x % 4 == 2) return x + 1;
        else if (x % 4 == 3) return 0;
        else return x;
    }
//     Q5)     137. Single Number II
    static public int singleNumberII(int[] nums) {
          /*
          // Using sorting
         Arrays.sort(nums);
        int n = nums.length;
        for(int i =1;i<n;i+=3){
            if(nums[i]!=nums[i-1]){
               return nums[i-1];
            }
        }
        return nums[n-1];
        */
        // Using bitwise operator
        int ones = 0;
        int twos = 0;
        for(int i:nums){
            ones = (ones^i)&(~twos);
            twos = (twos^i)&(~ones);
        }
        return ones;
    }
    //    Q4) 260. Single Number III
    static public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans[] = new int[2];
        int idx = 0;
        int size = nums.length;
        if (size == 2 && nums[0] != nums[1])
            return nums;
        if (nums[0] != nums[1])
            ans[idx++] = nums[0];
        if (nums[size - 1] != nums[size - 2])
            ans[idx++] = nums[size - 1];
        for (int i = 1; i < size - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
                ans[idx++] = nums[i];
        }
        return ans;
        /*
          // Bit Manipulation
           int ans[] = new int[2];
        int bothXor = 0;
        for(int i :nums){
            bothXor = bothXor^i;
        }
        bothXor = (bothXor&bothXor-1)^bothXor;

        int leftBucket = 0;
        int rightBucket = 0;
        for(int i :nums){
            if((bothXor&i)==0)leftBucket = leftBucket^i;
            else rightBucket = rightBucket^i;
        }
        ans[0] = leftBucket;
        ans[1] = rightBucket;
        return ans;
        * */
    }
//   LEETCODE 50. Pow(x, n)
static double pow(int x,int nn){
    double temp = nn;
    double n = Math.abs((double) nn);
    System.out.println(n);
    double ans = 1;
    while (n>0){
        if(n%2!=0){
            ans =ans*x;
            System.out.println("==>"+ans);
            n = n-1;
        }
        else{
            x = x*x;
            n =n/2;
        }
    }
    System.out.println(ans);
    if(temp<0) return 1.00/ans;
    return ans;
}
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
//       findAllPossibleSubsets(nums);
//        findAllPossibleSubsetsBitWise(nums);
//        System.out.println(divide(-2147483648,-1));
        System.out.println(xorAll(5));

    }
}
