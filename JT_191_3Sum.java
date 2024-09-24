import java.util.*;

public class JT_191_3Sum {
    // LEETCODE 15 3Sum
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    List<Integer>list = new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k]==0){
//                        System.out.println(nums[i]+"Idx :"+i);
//                        System.out.println(nums[j]+"Idx :"+j);
//                        System.out.println(nums[k]+"Idx :"+k);
//                        System.out.println("******************");
                        list.add(nums[i]);list.add(nums[j]);list.add(nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        List<List<Integer>>mainlist = new ArrayList<>();
        for(List<Integer> e:set){
            mainlist.add(e);
        }
        return mainlist;
    }
    static List<List<Integer>> threeSumBetter(int nums[]){
        HashSet<Integer>set = new HashSet<>();
        HashSet<List<Integer>>mainSet = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                int third = -(nums[i] + nums[j]);
                if(set.contains(third)){
                    List<Integer>list  =new ArrayList<>();
                    list.add(nums[i]);list.add(nums[j]);
                    list.add(third);
                    Collections.sort(list);
                    mainSet.add(list);

                }
                set.add(nums[j]);
            }
            set = new HashSet<>();
        }
        List<List<Integer>>mainlist = new ArrayList<>();
        for(List<Integer> e:mainSet){
            mainlist.add(e);
        }
        System.out.println(mainlist);
        return mainlist;
    }
    static List<List<Integer>> threeSumOptimized(int nums[]){
//        HashSet<List<Integer>>mainSet = new HashSet<>(); no need
        List<List<Integer>>mainlist = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int i = 0;
        int k = nums.length-1;
        while (i<k){
            int j = i+1;
            while (j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer>list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
//                    Collections.sort(list); // no need
//                    mainSet.add(list); // no need
                    mainlist.add(list);
                    j++;k--;
                    // to remove set move the element till not equal to previous
                    while (j<k && nums[i]==nums[j-1])j++;
                    while (j<k && nums[k]==nums[k+1])k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }
                else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
            }
            i++;
            k=nums.length-1;
        }
        return mainlist;
    }
    //*******************************************************************************************************
    // LEETCODE 56. Merge Intervals
    static int[][] mergeIntervals(int intervals[][]){
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
//        for(int i =0;i<intervals.length;i++){
//            for(int j = 0;j<intervals[0].length;j++){
//                System.out.print(intervals[i][j]+" ");
//            }
//            System.out.println();
//        }
        List<List<Integer>>ans = new ArrayList<>();
        for(int i =0;i<intervals.length;i++){
            if( ans.isEmpty() || intervals[i][0]>ans.get((ans.size()-1)).get(1)){
                List<Integer>list =new ArrayList<>(2);
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
                ans.add(list);
            } else{
//                if (intervals[i][0]<ans.get((ans.size()-1)).get(1)) {
                int max = Math.max(ans.get((ans.size()-1)).get(1),intervals[i][1]);
                ans.get(ans.size()-1).set(1,max);
            }
        }
        System.out.println(ans);
        int[][] answer = new int[ans.size()][2];
        for(int i =0;i<ans.size();i++){
            answer[i][0] =ans.get(i).get(0);
            answer[i][1] = ans.get(i).get(1);
        }
//        for(int i =0;i<answer.length;i++){
//            for(int j = 0;j<answer[0].length;j++){
//                System.out.print(answer[i][j]+" ");
//            }
//            System.out.println();
//        }
        return answer;
    }
    public static void main(String[] args) {
        int[] nums ={-1,0,1,2,-1,-4};
//        int[] nums = {0, 0, 0, 0};
        List<List<Integer>>list = threeSumOptimized(nums);
        System.out.println(list);
//      ******************************************************
        // int intervals[][] = {{1,3},{2,6},{8,10},{15,18}};
        int [][] intervals = {{1,4},{0,4}};
        int[][] ans  = mergeIntervals(intervals);
    }
}
