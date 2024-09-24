import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JT_188_ImpConceptQuest {
    // LEETCODE 560 subArray equal to k
        static int sum(int nums[]){
            int k =3;
            int maxCount = 0;
            for(int i =0;i<nums.length;i++){
                int sum = 0;
                for(int j = i;j<nums.length;j++){
                    sum = sum+nums[j];
                    if(sum==k){
                        maxCount++;
                    }
                }
            }
            return maxCount;
    }
    public static int subArray(int nums[]) {
        int k = 0;
        Map<Integer, Integer> map = new HashMap<>(); // <preSum,count>
        map.put(0, 1);
        int count = 0;
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum = preSum + nums[i];
            int x = preSum - k;
            if (map.containsKey(x)) {
                if (!map.containsKey(preSum)) {
                    if (map.containsKey(x)) {
                        int w = map.get(x);
                        count = count + w;
                        map.put(preSum, 1);
                    } else {
                        map.put(preSum, 1);
                        count++;
                    }
                } else {
                    int w = map.get(x);
                    count = count + w;
                    map.put(preSum, map.get(preSum) + 1);
                }
            } else {
                map.put(preSum, 1);
            }
        }

    /* more shorter
      for(int i =0;i<nums.length;i++){
         preSum = preSum+nums[i];
         int x = preSum-k;
         if(map.containsKey(x)) {
             int w = map.get(x);
             count = count + w;
             if (map.containsKey(preSum)) map.put(preSum, map.get(preSum) + 1);
             else map.put(preSum, 1);
         }
         else map.put(preSum,1);
        }
     */
        return count;
    }
    public static void main(String[] args) {
//        int nums[] ={1,2,3,-3,1,1,1,4,2,-3};
        int nums[] ={-1,-1,1};
        System.out.println(subArray(nums));
    }
}
