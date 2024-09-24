import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JT_190_MajorityElement {
    static void majorityElementMyApproach(int []nums){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i]))hashMap.put(nums[i],hashMap.get(nums[i])+1);
            else hashMap.put(nums[i],1);
        }
//        System.out.println(hashMap);
        List<Integer> list = new ArrayList<>();
        for(var ele:hashMap.entrySet()){
            if(ele.getValue()>(nums.length)/3){
                list.add(ele.getKey());
            }
        }
        System.out.println(list);
    }
    static List<Integer> majorityElementBetterApproach(int []nums){
        List<Integer>list = new ArrayList<>();
        int x = (nums.length/3);
//        System.out.println(x);
        HashMap<Integer,Integer>hashMap = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+1);

            }else{
                hashMap.put(nums[i],1);
            }
            if(hashMap.get(nums[i])==x+1){
                list.add(nums[i]);
            }
            if(list.size()==2)break;
        }
        return list;
    }
    public static void main(String[] args) {
        // leetcode. 229
        int[] nums = {2,2};
        majorityElementMyApproach(nums);
        List<Integer> list = majorityElementBetterApproach(nums);
        System.out.println(list);



    }
}
