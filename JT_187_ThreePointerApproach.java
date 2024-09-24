import java.util.Arrays;
import java.util.HashMap;

public class JT_187_ThreePointerApproach {
    //    Q1) LEETCODE 75. Sort Colors
    static void sortColors(int nums[]){
        HashMap<Integer,Integer> hmap = new HashMap<>(); // storing frequency
        for(int i =0;i<nums.length;i++){
            if(hmap.containsKey(nums[i])){
                hmap.put(nums[i],hmap.get(nums[i])+1);
            }
            else{
                hmap.putIfAbsent(nums[i],1);
            }
        }
        int idx = 0;
        if (hmap.containsKey(0)) {
            int zero = hmap.get(0);
            while (zero > 0) {
                nums[idx++] = 0;
                zero--;
            }
        }
        if (hmap.containsKey(1)) {
            int one = hmap.get(1);
            while (one > 0) {
                nums[idx++] = 1;
                one--;
            }
        }
        if (hmap.containsKey(2)) {
            int two = hmap.get(2);
            while (two > 0) {
                nums[idx++] = 2;
                two--;
            }
        }
        for(int num :nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }
    static void optimizedSortColors(int []nums){
        // without using hash map
        int one = 0;
        int two = 0;
        int zero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] ==0)zero++;
            if(nums[i]==1)one++;
            if(nums[i]==2)two++;
        }
        int idx = 0;
        while (zero > 0) {
            nums[idx++] = 0;
            zero--;
        }
        while (one > 0) {
            nums[idx++] = 1;
            one--;
        } while (two > 0) {
            nums[idx++] = 2;
            two--;
        }
        for(int num :nums){
            System.out.print(num+" ");
        }
        System.out.println();

    }
    static void bestApproachSortColors(int nums[]){  /// Very Very Important (three pointer approach)
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while (mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                mid++;
                low++;

            }
            else if(nums[mid]==1){
                mid++;

            }
            else if(nums[mid]==2){
                swap(nums,mid,high);
                high--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    static void swap(int []nums,int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    static void leetCode53(int[] nums){
        for(int i =1;i<nums.length;i++){
            nums[i] = nums[i] + nums[i-1];
        }
        System.out.println(Arrays.toString(nums));
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i =0;i<nums.length;i++) {
            for (int j = i; j < nums.length;j++) {
                sum = sum + nums[j];
                if (max<sum) {
                    max = sum;
                }
            }
            sum = 0;
        }
        System.out.println(max);
    }
    // LEETCODE 1752
    static boolean checkSortedRotated(int []nums){
        int x = 0;
        if(nums[0]>=nums[nums.length-1]){
            for(int i =1;i<nums.length-1;i++){
                if(nums[i]<nums[i-1] && nums[i]<nums[i+1]){
                    if(x==1)return false;
                    x = 1;
                }
            }
        }
        else{
            for(int i =1;i<nums.length;i++){
                if(nums[i]<nums[i-1]){
                    if(nums[i]<nums[i-1]){
                        return false;
                    }
                }
            }
            return true;
        }
        return true;
    }
    // LEETCODE 283
    static void moveZeroToEnd(int nums[]){
        int j = 0;
        while (j<nums.length-1 && nums[j]!=0){
            j++;
        }
        for(int i = j+1;i<nums.length;i++){
            if (nums[j]==0 && nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }

        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int nums[] = {2,0,1};
        sortColors(nums);
        optimizedSortColors(nums);
        bestApproachSortColors(nums);

        int nums1[] = {-2,1,-3,4,-1,2,1,-5,4};
//        leetCode53(nums1);

        int nums2[] ={6,10,6};
//       int nums2[] = {2,1,3,4};
//        System.out.println(checkSortedRotated(nums));

        int nums3[] = {0,5,6,0,0,2,1};
//        moveZeroToEnd(nums3);
    }
}
