import java.util.HashSet;

public class JT_205_SlidingWindow {
    // 209. Minimum Size Subarray Sum
    static public int minSubArrayLen(int target, int[] nums) {
        int i =0;
        int j =0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (j<len) {
            sum += nums[j];
            while (sum >= target) {
                System.out.println("sum "+sum);
                min = Math.min(min, j - i + 1);
                sum = sum - nums[i];
                i++;
            }

                j++;
        }
        return min==Integer.MAX_VALUE?0:min;
    }
    //
//    2461. Maximum Sum of Distinct Subarrays With Length K
    public long maximumSubarraySum(int[] nums, int k) {
        long maximum = 0;
        int i = 0;
        int j = 0;
        long sum = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        while (j<nums.length){
            while (hashSet.contains(nums[j])){
                sum =sum-nums[i];
                hashSet.remove(nums[i]);
                i++;
            }
            if(!hashSet.contains(nums[j])){
                sum =sum+nums[j];
                hashSet.add(nums[j]);
            }
            if(j-i+1==k){
                maximum = Math.max(maximum,sum);
                sum =sum-nums[i];
                hashSet.remove(nums[i]);
                i++;
            }
            j++;
        }
        System.out.println(maximum);
        return maximum;
    }
    public static void main(String[] args) {
        int[]arr ={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,arr));
    }
}
