import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*Heap--> It is not necessary that min heap or max heap are in sorted order or reverse sorted order.
* For min heap --> for each node parent node must be smaller than all child.
* For max heap --> for each node parent node must be greater than all child.
*  To find left child --> (2*i)+1
* To find right child --> (2*i)+2
* To find parent node --> (i-1/2)
* Time Complexity for Insertion -> logN
*  */
public class JT_177_Heap {
    //Q) General Question, Insert in element to its write position in sorted order
    public static void insertInSortedOrder(List<Integer>heap,int x){
        int idx = 0;
        for(int i =0;i<heap.size()-1;i++){
            if(x>heap.get(i) && x<heap.get(i+1)){
                idx= i;
            }
        }
//        System.out.println("Index "+idx);
        if(x<heap.get(0)){
            heap.add(0,x);
        }
        else if(x>heap.get(heap.size()-1)){
            heap.add(heap.size(),x);
        }
        else{
            heap.add(idx+1,x);
        }

        System.out.println(heap);
    }
//    Q1) Insert given element in Minheap without violating its condition
    // My Approach Without Recursion
    static void swap(List<Integer>heap,int x,int y){
        int temp = heap.get(x);
        heap.set(x,heap.get(y));
        heap.set(y,temp);
    }
    public static void insertInMinHeapIterative(List<Integer>heap,int target){
        heap.add(target); //adding element
        // following push-up approach
        int parent = ((heap.size()-1)-1)/2;
        int oldParent = heap.size()-1;
        while (parent>0){
            if(heap.get(parent)>target){
                swap(heap,parent,oldParent);
            }
            oldParent = parent;
            parent = (parent-1)/2;
        }
        if(heap.get(0)>heap.get(1))swap(heap,0,1);
        if(heap.get(0)>heap.get(2))swap(heap,0,2);
    }
    // Recursion
    public static void pushInMinHeap(List<Integer>heap,int idx){
        int parentIdx = (idx-1)/2;
        if(idx==0 || heap.get(parentIdx)<heap.get(idx))return;
        swap(heap,parentIdx,idx);
        pushInMinHeap(heap,parentIdx);
    }
    public static void insertInMinHeapRecursion(List<Integer>heap,int target){
        heap.add(target);
        int idx = heap.size()-1;
        pushInMinHeap(heap,idx);
    }
    //    Q2) Insert given element in Maxheap without violating its condition
    public static void insertInMaxHeapIterative(List<Integer>heap,int target){
        heap.add(target);
        int parent = ((heap.size()-1)-1)/2;
        int oldParent = heap.size()-1;
        while (parent>0){
            if(heap.get(parent)<target){
                swap(heap,parent,oldParent);
            }
            oldParent = parent;
            parent = (parent-1)/2;
        }
        if(heap.get(0)<heap.get(1))swap(heap,0,1);
        if(heap.get(0)<heap.get(2))swap(heap,0,2);
    }
    // Recursion
    public static void pushInMaxHeap(List<Integer>heap,int idx){
        int parentIdx = (idx-1)/2;
        if(idx==0 || heap.get(parentIdx)>heap.get(idx))return;
        swap(heap,parentIdx,idx);
        pushInMaxHeap(heap,parentIdx);
    }
    public static void insertInMaxHeapRecursion(List<Integer>heap,int target){
        heap.add(target);
        int idx = heap.size()-1;
        pushInMaxHeap(heap,idx);
    }
    public static void main(String[] args) {
        List<Integer> heap = new ArrayList<>();
        heap.add(10);
        heap.add(20);
        heap.add(30);
        heap.add(40);
        heap.add(50);
        heap.add(60);

//        insertInSortedOrder(heap,55); // not related to heap topic
//        System.out.println(heap);

        // Min Heap Insertion
//        insertInMinHeapIterative(heap,5);
//        System.out.println(heap);
//        insertInMinHeapRecursion(heap,5);
//        System.out.println(heap);

        // Max Heap Insertion
        List<Integer> heap1 = new ArrayList<>();
        heap1.add(60);
        heap1.add(50);
        heap1.add(40);
        heap1.add(30);
        heap1.add(20);
        heap1.add(10);

        System.out.println(heap1);
        insertInMaxHeapIterative(heap1,45);
        System.out.println(heap1);
//        insertInMaxHeapRecursion(heap1,45);
//        System.out.println(heap1);
    }
}
