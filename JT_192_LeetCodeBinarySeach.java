public class JT_192_LeetCodeBinarySeach {
//    Q1) LEETCODE .35 Insert in proper position (IMP. Concept of LOWER BOUND)
    // Lower Bound --> nums[mid]>= target
    // Upper Bound --> nums[mid] > target
      public static int searchInsert(int[] nums, int val) {
        // Poor Approach
        // for(int i =0;i<nums.length;i++) {
        //     if (nums[i] == val) {
        //         return i;
        //     }
        // }
        /*
        int ans[] = new int[nums.length + 1];
        for(int i =0;i<nums.length;i++){
            ans[i] = nums[i];
        }
        ans[ans.length-1]=val;
        for (int i = 0; i < ans.length; i++) {
            for(int j =i+1;j<ans.length;j++){
                if (ans[i] > ans[j]) {
                int temp = ans[i];
                ans[i] = ans[j];
                ans[j]=temp;
                }
        }
        }
        for(int i = 0;i<ans.length;i++){
            if (ans[i] == val) {
                return i;
            }
        }
        */
        // Best Approach
        int ans = nums.length;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid]>=val) { //IMP
                ans = mid;
                end = mid-1;
            } else if (nums[mid]<val) {
                start = mid+1;
            }
        }
        return ans;
    }
//    Q2) LEETCODE. 540 Search unique element in sorted array
    public static int singleNonDuplicate(int[] nums) {
        //  Edge Case because i applied BS to 1->n-2
        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];

        int start = 1;
        int end = nums.length - 2;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                // System.out.println(nums[mid]);
                return nums[mid];
            } else if (mid % 2 == 0) {  // mid is even
                if (nums[mid] == nums[mid - 1]) {  // pair(odd,even)
                    end = mid - 1;
                } else {                       // pair(even,odd)
                    start = mid + 1;
                }
            } else if (mid % 2 != 0) { // mid is odd
                if (nums[mid] == nums[mid + 1]) {  // pair(odd,even)
                    end = mid - 1;
                } else {                       // pair(even,odd)
                    start = mid + 1;
                }
            }
        }
        return 0;
    }
//    Q3) Find Peak Element in 2D Matrix LEETCODE.1901
    // Approach 1 -> Brute forces search all and compare in four direction
    // Approach 2 -> find largest element and return index
    // Approach 3 -> optimized by binary search
// Optimized
public static int[] findPeakGrid(int[][] mat) {
    int ans[] = { -1 };
    int start = 0;
    int end = mat[0].length - 1;
    while (start <= end) {
        int mid = (start + end) / 2;
        int max = Integer.MIN_VALUE;
        int row = -1;
        for (int i = 0; i < mat.length; i++) {
            if (max < mat[i][mid]) {
                max = mat[i][mid];
                row = i;
            }
        }
        int left = -1;
        if (mid - 1 >= 0)
            left = mat[row][mid - 1];
        int right = -1;
        if (mid + 1 < mat[0].length)
            right = mat[row][mid + 1];

        if (mat[row][mid] > left && max > right) {
            ans = new int[] { row, mid };
            // System.out.println(row+" "+mid);
            return ans;
        } else if (mat[row][mid] < left) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return ans;
}
    public static void main(String[] args) {
        int nums[] = {1,3,5,6};
//        System.out.println(searchInsert(nums,2));

        int nums1[] = {3,3,7,7,10,11,11};
//        System.out.println(singleNonDuplicate(nums1));

        int[][] mat = {{47,30,35,8,25},{6,36,19,41,40},{24,37,13,46,5},{3,43,15,50,19},{6,15,7,25,18}};
        int[]ans = findPeakGrid(mat);
    }
}
