import java.util.*;

public class JT_175_Practice {
    // Q1 Find the 3rd largest element in array LEETCODE(414)
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==2)return nums[nums.length-1];
        int secondlargest = 0;
        for(int i =nums.length-2;i>=0;i--){
            if(nums[i]!=nums[nums.length-1]){
                secondlargest = nums[i];
                break;
            }
        }
        for(int i =nums.length-3;i>=0;i--){
            if(nums[i]!=secondlargest && secondlargest!=nums[i]){
                return nums[i];
            }
        }

        return nums[nums.length-1];
    }
    //Q2) Find the kth largest element LEETCODE(215), means just return the kth element in descending order of array
    static void KthLargestElement(int nums[],int k){
     Arrays.sort(nums);
     Integer arr1[] = new Integer[nums.length];
     int v =0;
     for(int i:nums){
         arr1[v++] = Integer.valueOf(i);
     }
     Arrays.sort(arr1,Collections.reverseOrder());
        System.out.println(Arrays.toString(arr1));
        System.out.println(arr1[k-1]);
    }
    // Without Sorting Optimized Approach
    public static void kthLargestOptimized(int nums[],int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i =0;i<nums.length;i++){
            priorityQueue.add(nums[i]);
        }
        for(int i = k-1;i>0;i--){
            priorityQueue.remove();
        }
        System.out.println(priorityQueue.peek());
    }
//    Q3) Find the Kth Largest Integer in the Array LEETCODE(1985), same as previous question just input array is string
    public static void kthLargestInteger(String[] nums,int k){
      long ans[] = new long[nums.length];
      // converting string-> long array
      for(int i =0;i<nums.length;i++){
          ans[i] = Long.parseLong(nums[i]);
      }
        System.out.println(Arrays.toString(ans));
        Arrays.sort(ans);
        // converting long array to its wrapper class
        Long arr1[] = new Long[nums.length];
        int v =0;
        for(long i:ans){
            arr1[v++] = Long.valueOf(i);
        }
        Arrays.sort(arr1,Collections.reverseOrder()); // reverse the sorted array
        String i = Long.toString(arr1[k-1]);
        System.out.println(i);
    }
    public static void main(String[] args) {
        int arr1[] = {2,2,3,1};
        int arr2[] = {1,2,2};
//        System.out.println(thirdMax(arr1));
        int arr3[] = {3,2,3,1,2,4,5,5,6};
        int arr4[] = {3,2,1,5,6,4};
        int arr5[] = {2,1};
//        KthLargestElement(arr3,4);
//        kthLargestOptimized(arr3,4);
        String arr6[] ={"3","6","7","10"};
        kthLargestInteger(arr6,4);

    }
}
