import java.util.*;

public class JT_198_LeetCodeDaily_Oct2 {
    // 1590. Make Sum Divisible by P
    // Brute Force TLU
  static   public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for(int num :nums)sum = sum+num;
        System.out.println(sum);

        long rem= sum%p;
        if(sum<p)return -1;
        if(rem==0)return 0;
        System.out.println(rem);

        int minLength = Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            int sum1= 0;
            for(int j = i;j<nums.length;j++){
                sum1+=nums[j];
                if( sum!=sum1 &&(sum -sum1)%p==0){
                    System.out.println("HII");
                    minLength = Math.min(minLength,j-i+1);
                    if(minLength==1)return minLength;
                    break;
                }
            }
        }
        if(minLength==Integer.MAX_VALUE)minLength = -1;
        return minLength;
    }

    // code to minimum length of substring having sum equal to k
    public static int minSubArrayLen(int[] arr, int k) {
        // HashMap to store the cumulative sum and corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        // Initialize map with sum 0 at index -1
        map.put(0, -1);

        // Traverse through the array
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Check if sum - k exists in the map, meaning a subarray sum equals k
            if (map.containsKey(sum - k)) {
                minLength = Math.min(minLength, i - map.get(sum - k));
            }

            // Only add the sum to the map if it doesn't already exist, to ensure we get the minimum length
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        // If minLength hasn't been updated, no subarray was found
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }

    // optimized leetcode 1590
    public int minSubarray3(int[] nums, int p) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums)
            sum = (sum + num);
        System.out.println(sum);

        long target = sum % p;
        if (sum < p)
            return -1;
        if (target == 0)
            return 0;
        // System.out.println("rem :" + rem);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);

        int minLength = n; // take n not Integer.MAX_VALUE

        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 = (sum1 + nums[i]) % p;
            int remain = (sum1 - (int) target + p) % p;
            if (hashMap.containsKey(remain)) {
                minLength = Math.min(minLength, i - hashMap.get(remain));
            }
            hashMap.put(sum1, i);
        }
        return minLength == n ? -1 : minLength;
    }

    // 1813. Sentence Similarity III
    public boolean areSentencesSimilar(String s1, String s2) {
        if (s2.length() > s1.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        String[] s1l1 = s1.split(" ");
        String[] s2l2 = s2.split(" ");

        int start = 0;
        int end = s1l1.length - 1;
        int k = 0;
        int l = s2l2.length - 1;

        while (k < s2l2.length && start < s1l1.length) {
            if (!s1l1[start].equals(s2l2[k])) {
                break;
            }
            k++;
            start++;
        }
        if (k > l)
            return true;
        while (l >= k && s1l1[end].equals(s2l2[l])) {
            end--;
            l--;
        }
        return k > l;
    }
//    962. Maximum Width Ramp
public int maxWidthRamp(int[] nums) {
    // Brute Force TLE
    // int max = Integer.MIN_VALUE;
    // for (int i = 0; i < nums.length - 1; i++) {
    // int j = nums.length - 1;
    // while (i < j) {
    // if (nums[j] >= nums[i]) {
    // if (j - i > max) {
    // max = j - i;
    // break;
    // }
    // }
    // j--;
    // }
    // }
    // return max== Integer.MIN_VALUE?0:max;
    Stack<Integer> stack = new Stack<>();
    int len = nums.length;
    for (int i = 0; i < len; i++) {
        if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
            stack.push(i);
        }
    }

    int max = Integer.MIN_VALUE;
    for (int i = len - 1; i >= 0; i--) {
        while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
            max = Math.max(max, i - stack.peek());
            stack.pop();
        }
        if (stack.isEmpty())
            break;
    }
    return max;
}
// 2406. Divide Intervals Into Minimum Number of Groups
// Brute Force TLE
public int minGroups(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<Integer> list = new ArrayList<>();
    list.add(intervals[0][1]);
    for (int i = 1; i < intervals.length; i++) {
        boolean point = false;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) < intervals[i][0]) {
                list.set(j,intervals[i][1]);
                point = true;
                break;
            }
        }
        if(!point){
            list.add(intervals[i][1]);
        }
    }
    return list.size();
}
// optimized approach
static public void minGroups1(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    PriorityQueue<Integer>priorityQueue = new PriorityQueue<>();
    priorityQueue.add(intervals[0][1]);
    for(int i=1;i<intervals.length;i++){
        if(!priorityQueue.isEmpty() &&priorityQueue.peek()>=intervals[i][0]){
            priorityQueue.add(intervals[i][1]);
        } else if (!priorityQueue.isEmpty() && priorityQueue.peek()<intervals[i][0]) {
            priorityQueue.poll();
            priorityQueue.add(intervals[i][1]);
        }
    }
    System.out.println(priorityQueue.size());
}

    public static void main(String[] args) {
    }
}
