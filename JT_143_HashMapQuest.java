import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JT_143_HashMapQuest {
//Q1) Valid Anagrams means every character of a string should present in another string with same frequency
    // Approach 1 using two HashMap
    static boolean validAnagrams(String a,String b){
        Map<Character,Integer> hmap = new HashMap<>();
        for(int i =0;i<a.length();i++){
           char j = a.charAt(i);
          if(hmap.containsKey(j)){
              hmap.put(j,hmap.get(j)+1);
          }else {
              hmap.put(j,1);
          }
        }
//        System.out.println(hmap);
        Map<Character,Integer> hmap1 = new HashMap<>();
        for(int i =0;i<b.length();i++){
            char j = b.charAt(i);
            if(hmap1.containsKey(j)){
                hmap1.put(j,hmap1.get(j)+1);
            }else {
                hmap1.put(j,1);
            }
        }
//                System.out.println(hmap1);
        if(hmap.equals(hmap1)){
            return true;
        }else {
            return false;
        }
            }
            // Approach II using only one hashmap (more optimized)
    static boolean validAnagramApproach2(String a,String b){
        Map<Character,Integer> hmap = new HashMap<>();
        for(int i =0;i<a.length();i++){
            char j = a.charAt(i);
            if(hmap.containsKey(j)){
                hmap.put(j,hmap.get(j)+1);
            }else {
                hmap.put(j,1);
            }
        }
//        System.out.println(hmap);
        for(int i =0;i<b.length();i++){
            char j = b.charAt(i);
            if(hmap.containsKey(j)){
                hmap.put(j,hmap.get(j)-1);
            }else {
                hmap.put(j,1);
            }
        }
//        System.out.println(hmap);
        for(var i :hmap.values()){
            if(i!=0){
            return false;
            }
        }
        return true;
    }
//    Q2) Determine given strings (both with same length)are IsoMorphic Strings or not means
//        every character map to a different and unique character
    static boolean isomorphicString(String x,String y){
        Map<Character,Character> hmap = new HashMap<>();
        for(int i =0;i<x.length();i++){
            Character xch = x.charAt(i);
            Character ych = y.charAt(i);
            if(hmap.containsKey(xch)){
                if(hmap.get(xch)!=ych){
                    return false;
                }
            }else {
                if(hmap.containsValue(ych)){
                    return false;
                    }
                else{
                    hmap.put(xch,ych);
                }
            }
        }
        return true;
    }
    //    Q3) Two Sum
    // Approach 1- by using nested loop
    // Approach 2- by sorting the array first
    // Approach 3- by using hash Map O(n)
     static void twoSumSort(int arr[],int target){
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length-1;
        while (i<j){
            if(arr[i]+arr[j]>target){
                j--;
            }
           else if(arr[i]+arr[j]<target){
               i++;
            } else if (arr[i]+arr[j]==target) {
                System.out.println(arr[i]+" "+arr[j]);
                return;
            }
        }
    }
    // Approach 3- by using hash Map O(n)
    static int[] twosumHashMap(int arr[],int target){
        Map<Integer,Integer> hmap = new HashMap<>();
        int ans[] = {-1};
        for(int i = 0;i<arr.length;i++){
            int req = target-arr[i];
            if(hmap.containsKey(req)){
//                System.out.println(i+" "+hmap.get(req));
                ans = new int[]{i,hmap.get(req)};
                return ans;
            }else {
                hmap.put(arr[i],i);
            }
        }
        return ans;
    }
//    Q3) Find all possible sub arrays of a given array
    static void allSubArray(int arr1[]){
        System.out.println("All possible Sub-Arrays are: ");
        for(int i =0;i<arr1.length;i++){
            for(int j = i;j<arr1.length;j++){
                for(int k = i;k<=j;k++){
                    System.out.print(arr1[k]+" ");
                }
                System.out.println();
            }
        }
    }
// Q4) Find the length of largest sub array whose sum is equal to 0 (LEETCODE)
    static void sumZeroBruteForce(int arr1[]){
        int sum = 0;
        int count = 0;
        int max = -1;
        for(int i =0;i<arr1.length;i++){
            for(int j = i;j<arr1.length;j++){
                sum = 0;
                count = 0;
                for(int k = i;k<=j;k++){
                    sum = sum+arr1[k];
                    count++;
                }
                if(sum==0){
//                    System.out.println("true"); // checking purpose
                    if(max<count){
                        max = count;
                    }
//                    System.out.println(count); // checking purpose
                }
            }
        }
        System.out.println("Largest SubArray: "+max);
    }
    static void sumZeroHashMap(int arr[]){
        Map<Integer,Integer> hmap = new HashMap<>();
        int prefixSum = 0;
        int length = 0;
        int maxLength = 0;
        hmap.put(0,-1);
        for(int i = 0;i<arr.length;i++){
            prefixSum = prefixSum+arr[i];
            if(hmap.containsKey(prefixSum)){
//                System.out.println("Pre "+prefixSum);// checking purpose
                length = i - hmap.get(prefixSum);
                if(maxLength<length){
                    maxLength = length;
                }
            }
            else {
                hmap.put(prefixSum,i);
            }
        }
        System.out.println("Largest SubArray: "+maxLength);
    }
    // Q5) Find the character with minimum occurrence in a String (Assignment Quest)
    static void minimumCharOccurrence(String st){
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i = 0;i<st.length();i++){
            Character ch = st.charAt(i);
            if(hmap.containsKey(ch)){
                hmap.put(ch,hmap.get(ch)+1);
            }else{
                hmap.put(ch,1);
            }
        }
        System.out.println(hmap);
        int min = Integer.MAX_VALUE;
        Character min_ele = 'a';
        for(var i: hmap.keySet()){
            if(hmap.get(i)<min){
                min_ele = i;
                min = hmap.get(i);
            }
        }
        System.out.println(min_ele+": "+min);
    }
//    Q6) Given an integer array of n elements, print k-th distinct element in an array. The given array may
//contain duplicates and the output should print k-th element among all unique elements. If k is more than
//the number of distinct elements, print -1. [Medium]
    /*n = 6
arr[] = {¦, 2, ¦, 3, 4, 2},
k = 2
    * o/p -> 4
     */
    static void kthDistinctElement(int arr3[],int kth){
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i =0;i<arr3.length;i++){

            Integer v = arr3[i];
            if(hashMap.containsKey(v)){
                hashMap.put(v,hashMap.get(v)+1);
            }else {
                hashMap.put(v,1);
            }
        }
//        System.out.println(hashMap);
        int count = 0;
        for(var i :hashMap.keySet()){
            if(hashMap.get(i)==1){
                count++;
                if(count==kth){
                    System.out.println("Kth Distinct Element is: "+i);
                    return;

                }
            }
        }
    }
    public static void main(String[] args) {
        String a = "silent";
        String b = "listen";
//        System.out.println(validAnagrams(a,b));
//        System.out.println(validAnagramApproach2(a,b));

        String x ="aab";
        String y = "xxy";
//        System.out.println(isomorphicString(x,y));

        int arr[] = {3,3,1,4,5,6};
//        twoSumSort(arr,6);
//       int ans[] =  twosumHashMap(arr,6);
//        System.out.println(Arrays.toString(ans));

//        allSubArray(arr);
        int arr1[] = {15,-2,2,-8,1,7,10,23};
//        int arr2[] = {1,2,3};
        sumZeroBruteForce(arr1);
        sumZeroHashMap(arr1);

        String st = "abcdddbaaa";
//        minimumCharOccurrence(st);

        int arr3[] = {1, 2, 1,3, 4, 2};
//        kthDistinctElement(arr3,2);


    }
}
