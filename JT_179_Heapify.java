import java.util.*;

public class JT_179_Heapify {
    /*
    Heapify means it is a method of converting any array to heap(minheap/maxheap).
    There is two ways for heapify
    i) By insertion technique--> (Insertion)insert element at last, than follow pushUp Approach(compare with parent and swap).
   ii) Heapify technique-->(Deletion)treat array and CBT and follow pushDown Approach(compare with child and swap)first non leaf node.
    */
    // Here we use Heapify because it has less T.C O(N)
    // Heapify given array to Min Heap
    static void swap(List<Integer>heap,int x,int y){
        int temp = heap.get(x);
        heap.set(x,heap.get(y));
        heap.set(y,temp);
    }
    public static void heapify(List<Integer>heap,int idx){
        int n = heap.size()-1;
        // we use push down approach, compare with child and swap
        if(idx==n)return; // base case
        // self work
        int leftChild = (2*idx)+1;
        int rightChild = (2*idx)+2;
        int smallest = idx;
        if(leftChild<=n && heap.get(leftChild)<heap.get(smallest))smallest = leftChild;
        if(rightChild<=n && heap.get(rightChild)<heap.get(smallest))smallest = rightChild;
        swap(heap,idx,smallest);
        if(smallest==idx)return; // base case
        heapify(heap,smallest); // recursive work
    }
    public static void heapifyToMinHeap(List<Integer>heap){
        int parentOfFirstNodeLeaf = ((heap.size()-1)-1)/2;
        for(int i = parentOfFirstNodeLeaf;i>=0;i--){
            heapify(heap,i);
        }
    }
    public static void main(String[] args) {
//        List<Integer>heap = List.of(90,80,70,20,10,50,60); // cant the list is immutable
        List<Integer>heap = new ArrayList<>();
        heap.add(90);
        heap.add(80);
        heap.add(70);
        heap.add(20);
        heap.add(10);
        heap.add(50);
        heap.add(60);
        System.out.println(heap);
        heapifyToMinHeap(heap);
        System.out.println(heap);
        }
}
