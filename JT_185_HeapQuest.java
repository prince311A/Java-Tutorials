import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JT_185_HeapQuest {
//Q1) Using Binary Search, Insert an given element to its correct position without disturbance of Sorted Order.
    public static void insertUsingBinarySearchArray(int[] arr3,int target){
        // In this method we have to use extra space because array size is fixed.
        Arrays.sort(arr3);
//        System.out.println(Arrays.toString(arr3));
        int start = 0;
        int end = arr3.length-1;
        int index = 0;
        while (start<end){
            int mid = (start+end)/2;
            if(arr3[mid]>target && arr3[mid-1]<target){
                index = mid;
                break;
            }
            else if(arr3[mid]>target){
                end = mid-1;
            }
            else if(arr3[mid]<target){
                start = mid+1;
            }
        }
        System.out.println(index);
        int[] newArray = new int[arr3.length+1];
        for(int i = 0;i<index;i++) {
            newArray[i] = arr3[i];
        }
        newArray[index] = target;
        for(int i = index;i<newArray.length-1;i++) {
            newArray[i+1] = arr3[i];
        }
        System.out.println(Arrays.toString(newArray));
    }
    public static void insertUsingBinarySearchList(int[] arr3,int target){
        // Lets do this using Arraylist (Optimized)
        List<Integer>list = new ArrayList<>();
        for(int i =0;i<arr3.length;i++)list.add(arr3[i]);
        Collections.sort(list);
//        System.out.println(list);
        int start = 0;
        int end = list.size()-1;
        int index = 0;
        while (start<end){
            int mid = (start+end)/2;
            if(list.get(mid)>target && list.get(mid-1)<target){
                index = mid;
                break;
            }
            else if(list.get(mid)>target){
                end = mid-1;
            }
            else if(list.get(mid)<target){
                start = mid+1;
            }
        }
//        System.out.println(index);
        list.add(index,target);
        System.out.println(list);
    }
    public static void main(String[] args) {
        int arr3[] = {12,5,9,7,15,34,25,2};
        int nums[] = {1,3,5,6};
        System.out.println(Arrays.toString(nums));
        insertUsingBinarySearchArray(nums,(2));
//        insertUsingBinarySearchList(arr3,20);

    }
}
