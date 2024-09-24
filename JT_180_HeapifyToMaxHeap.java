import java.util.ArrayList;
import java.util.List;

public class JT_180_HeapifyToMaxHeap {
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
        int largest = idx;
        if(leftChild<=n && heap.get(leftChild)>heap.get(largest))largest = leftChild;
        if(rightChild<=n && heap.get(rightChild)>heap.get(largest))largest = rightChild;
        swap(heap,idx,largest);
        if(largest==idx)return; // base case
        heapify(heap,largest); // recursive work
    }
        public static void heapifyToMaxHeap(List<Integer>heap){
            int parentOfFirstNodeLeaf = ((heap.size()-1)-1)/2;
            for(int i = parentOfFirstNodeLeaf;i>=0;i--){
                heapify(heap,i);
            }
        }
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        heap.add(50);
        heap.add(60);

        System.out.println(heap);
        heapifyToMaxHeap(heap);
        System.out.println(heap);;
    }
}
