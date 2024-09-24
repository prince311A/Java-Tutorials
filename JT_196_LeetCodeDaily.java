import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JT_196_LeetCodeDaily {
    //    386. Lexicographical Numbers
    static public void recursive(int i , int n, List<Integer> list){
        if(i>n)return;
        list.add(i);
//    idx++;

        for(int append = 0;append<=9;append++) {
            int newNum = i*10+append;
//        if(list.size()==k)return;
            if(newNum>n)return;
            recursive(newNum, n,list);
        }
    }
    static public List<Integer> lexicalOrder(int n) {
        int idx = 0;
        // Optimize Aprroach
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            recursive(i, n,list);
        }
//       System.out.println(list);
        return list;
    }
    //    K-th Smallest in Lexicographical Order--->(LEETCODE.440)
    private int count = 0;
    private int result = 0;

    public boolean solve(long curr, int n, int k) {
        if (curr > n) return false;

        count++;

        if (count == k) {
            result = (int) curr;
            return true;
        }

        for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            long nextnum = curr * 10 + nextDigit;
            if (nextnum > n) break;

            if (solve(nextnum, n, k)) return true;
        }

        return false;
    }

    public int findKthNumber(int n, int k) {
        for (long num = 1; num <= 9; num++) {
            if (solve(num, n, k)) break;
        }

        return result;
    }
    //    **********************************OPTIMIZED LEETCODE.440**************************************
    static int count(int curr,int next,int n){
        int countNum = 0;

        while (curr<=n){
            countNum = countNum+(next-curr);
            curr = curr*10;
            next = next*10;
            next = Math.min(next,n+1);
        }

        return  countNum;
    }
    static public int findKthNumber1(int n, int k) {
        int curr =1;
        k = k-1;
        while (k>0) {
            int countNum = count(curr, curr + 1, n);
            if (countNum <= k) {
                curr++;
                k = k - countNum;
            } else {
                curr= curr*10;
                k--;
            }
        }
        return curr;
    }
    // 3043. Find the Length of the Longest Common Prefix
    // My Approach
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int k : arr1) {
            String str = Integer.toString(k);
            for(int j = str.length();j>0;j--){
                hashSet.add(Integer.parseInt(str.substring(0,j)));
            }
        }
        System.out.println(hashSet);
        int max = 0;
        for(int i =0;i<arr2.length;i++) {
            if (hashSet.contains(arr2[i])) {
                int x = (int) Math.floor(Math.log10(arr2[i]) + 1);
                max =Math.max(x,max);
                continue;
            }
            String str = Integer.toString(arr2[i]);
            for (int j = str.length()-1; j > 0; j--) {
                int x = Integer.parseInt(str.substring(0, j));
                if( hashSet.contains(x)){

                    int y = (int) Math.floor(Math.log10(x) + 1);
                    max =Math.max(y,max);
                }

            }
        }
        //    System.out.println(max);
        return max;
    }
    /* Optimized
     HashSet<Integer>hashSet = new HashSet<>();
       for (int k : arr1) {
           while (!hashSet.contains(k) && k>0){
               hashSet.add(k);
               k   = k/10;
           }
       }
//       System.out.println(hashSet);
       int max = 0;
       for (int k : arr2) {
           while (!hashSet.contains(k) && k>0) {
               k   = k/10;
           }
              if (k != 0) {
               int x = (int) Math.floor(Math.log10(k) + 1);
               max = Math.max(x, max);
           }
       }
//       System.out.println(max);
    * */
    public static void main(String[] args) {
        int x = 13;
        List<Integer> list = lexicalOrder(x);
        System.out.println(list);
    }

}
