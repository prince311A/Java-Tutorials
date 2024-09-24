import java.util.ArrayList;
import java.util.List;

public class JT_146_BackTrackingQuest {
//    Q1) Permutation (LEETCODE 46) means how many possible ways to write an array or string
// In this approach time and space complexity is very bad
    static void permutations(String str, String store,List<String> lst){
        if(str.equals("")){
//            System.out.println(store);
            lst.add(store);
            return;
        }
        for(int i =0;i<str.length();i++){ // this loop is for how many times we can the recursion
            char ch = str.charAt(i);
            String left = str.substring(0,i);
            String right = str.substring(i+1);
            String rem = left+right;
            permutations(rem,store+ch,lst);

        }
    }
    // By this approach time complexity remains same but space complexity can be reduced
    public static void helper(int arr[],List<Integer> ds, boolean[] isValidate, List<List<Integer>> ans ){
        if(ds.size()==arr.length){
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<ds.size();i++){
                list.add(ds.get(i));
            }
            ans.add(list);
            return;
        }
        for(int i =0;i<arr.length;i++){
            if(!isValidate[i]){
                ds.add(arr[i]);
                isValidate[i] = true;
                helper(arr,ds,isValidate,ans);
                isValidate[i] = false; //back tracking
                ds.remove(ds.size()-1);//back tracking
            }
        }
    }

public static List<List<Integer>> permute(int []arr){
    List<List<Integer>> ans = new ArrayList<>(); // mandatory
    List<Integer> ds = new ArrayList<>();
    boolean[] isValidate = new boolean[arr.length];
    helper(arr,ds,isValidate,ans);

    return ans;
}
    // Now lets solved this by space complexity of O(1)
    static void swap(int i,int j,int[]arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void helperOptimized(int[] arr,int idx, List<List<Integer>> ans){
        if(idx==arr.length-1){
            List<Integer> list = new ArrayList<>();
            for(int i =0;i<arr.length;i++){
                list.add(arr[i]);
            }
            ans.add(list);
            return;
        }
        for(int i =idx;i<arr.length;i++){
            swap(i,idx,arr);
            helperOptimized(arr,idx+1,ans);
            swap(i,idx,arr);

        }
    }
    static List<List<Integer>> permuteOptimized(int[] arr){
        List<List<Integer>> ans = new ArrayList<>(); // mandatory
        helperOptimized(arr,0,ans);
        return ans;
    }
    public static void main(String[] args) {
        String str = "abc";
        List<String> lst = new ArrayList<>();
//        permutations(str,"",lst);
//        System.out.println(lst);

        int[] arr = {1,2,3};
//        List<List<Integer>> ans = permute(arr);
//        System.out.println(ans);

        List<List<Integer>> ans1 = permuteOptimized(arr);
        System.out.println(ans1);
    }
}
