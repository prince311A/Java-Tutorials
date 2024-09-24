import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class JT_184_HeapQuest {
    //    Q1) Given an array of integer. You supposed to perform k operation on it. At each operation, smallest two integer
//    removed from the array and its multiplication insert back to array. After k operation find the largest element
    static void afterKOperation(int arr[],int k){
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int i =0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        while(k>0){
            int x = pq.remove();
            int y = pq.remove();
            pq.add(x*y);
            k--;
        }
        while (pq.size()>1){
            pq.remove();
        }
        System.out.println(pq.peek());
    }
//    Q2) Given an array, And two positive integer k1 and k2. Find the sum of all the element between k1 and k2th
//    smallest element of the array. (IMP)
    static void sumOfEleBtwSmallest(int arr[],int k1,int k2){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int sum = 0;
        int j = k1;
        while (j>0){
            pq.remove();
            j--;
        }
        for(int i =0;i<(k2-k1)-1;i++){
            sum = sum +pq.remove();
        }
        System.out.println(sum);

    }
    public static void main(String[] args) {
        int arr[] = {2,4,3,1,5};
        int k = 3; //o/p->20
//        afterKOperation(arr,k);
        int arr1[] = {20,8,22,4,12,10,14};
        int k1= 3; int k2 = 6; // o/p->26
        sumOfEleBtwSmallest(arr1,k1,k2);



    }
}
