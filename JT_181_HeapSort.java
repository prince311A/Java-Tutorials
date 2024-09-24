import java.util.ArrayList;
import java.util.List;

public class JT_181_HeapSort {
    /*
    HeapSort--> making any array sort in ascending or decending order without using sort appraoch.
    For ascending order --> Convert to max heap
    For descending order --> Convert to min heap
    Steps for HeapSort-->
    i) Convert Array to heap data structure heapify it.(min/max).
    ii) Start deletion from root/0 to last/size()-1
    then you will get the array of ascending or descending order.
        */

    // Converting array to heap(maxheap)
    static void swap(List<Integer>heap,int x,int y){
        int temp = heap.get(x);
        heap.set(x,heap.get(y));
        heap.set(y,temp);
    }
    static void heapify(List<Integer>heap,int idx,int n){
//        int n = heap.size()-1;
        if(idx==n)return; // base case
        // self work
        int largest = idx;
        int leftChild = (2*idx)+1;
        int rightChild = (2*idx)+2;
        if(leftChild<=n && heap.get(leftChild)>heap.get(largest))largest = leftChild;
        if(rightChild<=n && heap.get(rightChild)>heap.get(largest))largest = rightChild;
        swap(heap,idx,largest);
        if(largest==idx)return;
        heapify(heap,largest,n);

    }
    static void convertToMaxHeap(List<Integer>heap){
        int parentOfLeafNode = ((heap.size()-1)-1)/2;
        for(int i =parentOfLeafNode;i>=0;i--){
            heapify(heap,i,heap.size()-1);
        }
    }
    public static void heapSortAscending(List<Integer>heap){
        convertToMaxHeap(heap); // converting to max heap
        // now one by one we delete the root and reduce the size of list by -1
        System.out.println(heap);
        deleteTheRoot(heap);
    }
    static void deleteTheRoot(List<Integer>heap){
//        swap(heap,0,heap.size()-1);
//        heapify(heap,0,heap.size()-2);
//
//        swap(heap,0,heap.size()-2);
//        heapify(heap,0,heap.size()-3);
//
//        swap(heap,0,heap.size()-3);
//        heapify(heap,0,heap.size()-4);
//
//        swap(heap,0,heap.size()-4);
//        heapify(heap,0,heap.size()-5);
//
//        swap(heap,0,heap.size()-5);
//        heapify(heap,0,heap.size()-6);
//
//        swap(heap,0,heap.size()-6);
//        heapify(heap,0,heap.size()-7);

        for(int i =heap.size()-1;i>=0;i--){
            swap(heap,0,i);
            heapify(heap,0,i-1);
        }
    }
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(50);
        heap.add(80);
        heap.add(70);
        heap.add(60);
        heap.add(10);
        heap.add(90);
        heap.add(30);
        System.out.println(heap);
        heapSortAscending(heap);
        System.out.println(heap);
    }
}
