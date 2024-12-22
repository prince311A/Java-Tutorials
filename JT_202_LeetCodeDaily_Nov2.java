import java.util.*;

public class JT_202_LeetCodeDaily_Nov2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // 2641. Cousins in Binary Tree II
    // My Approach TLE
    int height(TreeNode root) { // T.C O(n)
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int maxLeftRightHeight = Math.max(leftHeight, rightHeight);
        return 1 + maxLeftRightHeight;
    }

    void helper(TreeNode root, Integer[] sumlevel, int n, int idx) {
        if (root == null)
            return;
        if (n == 1) {
            int x = 0;
            int y = 0;
            if (root.left != null)
                x = root.left.val;
            if (root.right != null)
                y = root.right.val;
            int sum = sumlevel[idx] - (x + y);
            if (root.left != null) {
                root.left.val = sum;
            }
            if (root.right != null) {
                root.right.val = sum;
            }
        }
        helper(root.left, sumlevel, n - 1, idx);
        helper(root.right, sumlevel, n - 1, idx);
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> levelSum = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.peek();
                assert temp != null;
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                sum += temp.val;
                queue.remove();
            }
            levelSum.add(sum);
        }
        Integer[] sumlevel = levelSum.toArray(new Integer[0]);
        int level = 1 + height(root);
        root.val = 0;
        for (int i = 1; i < level; i++) {
            helper(root, sumlevel, i, i);
        }
        return root;
    }

    // 2563. Count the Number of Fair Pairs
    static int upperBound(int start, int end, int[] nums, int target) {
        int idx = end + 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
                idx = mid;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }

    static int lowerBound(int start, int end, int[] nums, int target) {
        int idx = end + 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
                idx = mid;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < n; i++) {
            int lowerBound = lowerBound(i + 1, n - 1, nums, lower - nums[i]);
            int upperBound = upperBound(i + 1, n - 1, nums, upper - nums[i]);
            int x = lowerBound - 1 - i;// no need of -1-i
            int y = upperBound - 1 - i;
            count = count + (y - x);
        }
        return count;
    }

    //    1574. Shortest Subarray to be Removed to Make Array Sorted (IMP)
    public int findLengthOfShortestSubarray(int[] arr) {
        int size = arr.length;
        int j = arr.length - 1;
        for (int i = size - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1])
                break;
            j--;
        }
        // System.out.println(j);
        if (j == 0)
            return 0;
        int min = j;
        int i = 0;
        while (i < j && i == 0 || arr[i - 1] <= arr[i]) {
            while (j < size && arr[i] > arr[j]) {
                j++;
            }
            // System.out.println(arr[i]+"->"+arr[j]);
            min = Math.min(min, j - i - 1);
            // System.out.println("Min "+min);
            i++;
        }
        return min;
    }

    //862. Shortest Subarray with Sum at Least K
    // BruteForce TLE
    public int shortestSubarray(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k || sum > k) {
                    min = Math.min(min, j - i + 1);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    // 2461. Maximum Sum of Distinct Subarrays With Length K
    // TLE
    public long maximumSubarraySum(int[] nums, int k) {
        long maximum = 0;
        for (int i = 0; i <= nums.length-k; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            long sum = 0;
            int j;
            for (j = i; j < i + k; j++) {
                if (!hashSet.contains(nums[j])) {
                    sum = sum + nums[j];
                    hashSet.add(nums[j]);
                }else{
                    break;
                }
            }
            if(j==i+k) {
                maximum = Math.max(maximum, sum);
            }
        }
        System.out.println(maximum);
        return maximum;
    }
}
