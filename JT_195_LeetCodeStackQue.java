import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class JT_195_LeetCodeStackQue {
//    Q1) LEETCDOE 496. Next Greater Element I
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int j;
            for (j = i + 1; j < nums2.length; j++) {
                if (nums2[i] < nums2[j]) {
                    hashMap.put(nums2[i], nums2[j]);
                    break;
                }
            }
            if (j == nums2.length)
                hashMap.put(nums2[i], -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hashMap.get(nums1[i]);
        }
        return nums1;
    }

//    Q2)LEETCODE->503. Next Greater Element II...(revise)
    static   public void nextGreaterElements(int[] nums) {
        int res[] = new  int[nums.length];
        Stack<Integer> stack  = new Stack<>();
        stack.push(nums[nums.length-1]);

        for(int i = (2*(nums.length))-1;i>=0;i--){
            while (!stack.isEmpty() && stack.peek()<=nums[i%nums.length])stack.pop();
            if(i<nums.length){
                if(!stack.isEmpty() && stack.peek()>nums[i]) res[i%nums.length] = stack.peek();
                else res[i%nums.length] = -1;
            }
            stack.push(nums[i%nums.length]);
        }
        System.out.println(Arrays.toString(res));
    }
    public static void main(String[] args) {

    }
}
