import org.ietf.jgss.GSSManager;

import java.util.ArrayList;
import java.util.List;

public class JT_178_DeletionInHeap{
    // Time Complexity for Deletion -> logN
    static void swap(List<Integer>heap,int x,int y){
        int temp = heap.get(x);
        heap.set(x,heap.get(y));
        heap.set(y,temp);
    }
    static void deleteInMinHeapIterative(List<Integer>heap){
        // swapping the root to last position element
        swap(heap,0,heap.size()-1);
        // deleting the last element
        heap.remove(heap.size()-1);
        System.out.println(heap);
        // Now following push-down approach the make perfect min heap
        int idx = 0; // from where we start push-down
        boolean flag = true;
        while (flag) {
            int smallest = idx; // this is for which smallest element left child or right child
            int leftChild = (2*idx)+1;
            int rightChild = (2*idx)+2;
            if (leftChild<=heap.size()-1 && heap.get(leftChild) < heap.get(smallest)) smallest = leftChild;
            if (rightChild<=heap.size()-1 && heap.get(rightChild) < heap.get(smallest)) smallest = rightChild;
            swap(heap, idx, smallest);
            idx = smallest;
            if(leftChild>heap.size()-1 || rightChild>heap.size()-1){
                flag = false;
            }
        }
    }
    // Recursion
    static void pushDownInMinHeap(List<Integer>heap,int idx){
        int n = heap.size()-1;
        // Base Case
        if(idx==n)return;
        // self Work
        int smallest = idx;
        int leftChild = (2*idx)+1;
        int rightChild = (2*idx)+2;
        if(leftChild<=n && heap.get(leftChild)<heap.get(smallest))smallest = leftChild;
        if(rightChild<=n && heap.get(rightChild)<heap.get(smallest))smallest = rightChild;
        swap(heap,idx,smallest);
        if(idx==smallest)return;
        // recursion
        pushDownInMinHeap(heap,smallest);
    }
    static void deleteInMinHeapRecursive(List<Integer>heap){
        swap(heap,0,heap.size()-1); // swapping first and last
        heap.remove(heap.size()-1); // deleting last element
        pushDownInMinHeap(heap,0); // we pass 0 because we start pushing down from root
         }
         // Deletion in Max Heap
    static void deleteInMaxHeapIterative(List<Integer>heap){
        // swapping the root to last position element
        swap(heap,0,heap.size()-1);
        // deleting the last element
        heap.remove(heap.size()-1);
        System.out.println(heap);
        // Now following push-down approach the make perfect min heap
        int idx = 0; // from where we start push-down
        boolean flag = true;
        while (flag) {
            int largest = idx; // this is for which smallest element left child or right child
            int leftChild = (2*idx)+1;
            int rightChild = (2*idx)+2;
            if (leftChild<=heap.size()-1 && heap.get(leftChild) > heap.get(largest)) largest = leftChild;
            if (rightChild<=heap.size()-1 && heap.get(rightChild) > heap.get(largest)) largest = rightChild;
            swap(heap, idx, largest);
            idx = largest;
            if(leftChild>heap.size()-1 || rightChild>heap.size()-1){
                flag = false;
            }
        }
    }
    // Recursive
         static void pushDownInMaxHeap(List<Integer>heap,int idx){
             int n = heap.size()-1;
             // Base Case
             if(idx==n)return;
             // self Work
             int largest = idx;
             int leftChild = (2*idx)+1;
             int rightChild = (2*idx)+2;
             if(leftChild<=n && heap.get(leftChild)>heap.get(largest))largest = leftChild;
             if(rightChild<=n && heap.get(rightChild)>heap.get(largest))largest = rightChild;
             swap(heap,idx,largest);
             if(idx==largest)return;
             // recursion
             pushDownInMaxHeap(heap,largest);
         }
    static void deleteInMaxHeapRecursive(List<Integer>heap){
        swap(heap,0,heap.size()-1); // swapping first and last
        heap.remove(heap.size()-1); // deleting last element
        pushDownInMaxHeap(heap,0); // we pass 0 because we start pushing down from root
    }
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        heap.add(50);
        heap.add(60);
        // Here we are deleting the root i.e 10
        // 10,20,30,40,50,60--> o/p 20,40,30,60,50
        System.out.println(heap);
        deleteInMinHeapIterative(heap);
        System.out.println(heap);

//        deleteInMinHeapRecursive(heap);
//        System.out.println(heap);

        // Max Heap
        List<Integer> heap1 = new ArrayList<>();
        heap1.add(60);
        heap1.add(50);
        heap1.add(40);
        heap1.add(30);
        heap1.add(20);
        heap1.add(10);
        // Here we are deleting the root i.e 60
        // 60,50,40,30,20,10--> 50,30,40,10,20
        System.out.println(heap1);
        deleteInMaxHeapIterative(heap1);
//        deleteInMaxHeapRecursive(heap1);
        System.out.println(heap1);



    }
        }