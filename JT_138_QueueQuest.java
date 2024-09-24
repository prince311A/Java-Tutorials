import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JT_138_QueueQuest {
//    Q1) First Negative in each window of k size (GFG)
    // ex-> k = 3 arr{12,-1,-7,8,-15,30,16,28} o/p {-1,-1,-7,-15,-15,0}
    // But in this approach time complexity will be(n*k)
    // Better way to solve by Queue TC O(n)
    public static void negativeWindowIterative(int arr[],int k){
        int res[] = new int[arr.length-k+1];
        for(int i = 0;i<arr.length;i++){
            if(i+k>arr.length){
                break;
            }
            for(int j =i;j<i+k;j++){
                if(arr[j]<0){
//                    System.out.println(arr[j]+" "+i);
                    res[i] = arr[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }
    // Optimized Approach

    public static void negativeWindowQueue(int arr[],int k){
        int res[] = new int[arr.length-k+1];
        Queue<Integer> que = new LinkedList<>();
        for(int i =0;i<arr.length;i++){
            if(arr[i]<0){
                que.add(i);
            }
        }
        for(int i =0;i<arr.length-k+1;i++) {

            if (que.size() > 0 && que.peek() < i) {
                que.remove();
            }
            if (que.size() > 0 && que.peek() <= i + k - 1) {
                res[i] = arr[que.peek()];
            } else {
                res[i] = 0;
            }
        }
        System.out.println(Arrays.toString(res));
    }
//    Q2) Reorder Queue Interleave first half with second half
    // Ex->  {1,2,3,4,5,6,7,8}; o/p-> {1,5,2,6,3,7,4,8}
    public static void reorderInterleaveBruteForce(int arr[]){
        int res[] = new int[arr.length];
        for(int i =0;i<arr.length/2;i++){
            res[i*2] = arr[i];
        }
        System.out.println(Arrays.toString(res));
        int x = 1; // this is for to reach the even index
        for(int i =arr.length/2;i<arr.length;i++){
           res[x] = arr[i];
          x= x+2;
        }
        System.out.println(Arrays.toString(res));
    }
    // Lets solve this using Stacks
    // here we have an input queue not array
    /*Approach--
    * 1) remove the n/2 element from que and insert into stack
    * 2) push back the elements from queue to stack
    * 3) again remove n/2 elements from que and insert to stack
    * 4) then do one by one operation i.e. first pop the element from stack and then remove the element of que and add back
    * 5) reverse the queue means put all the elements into stack and all back all elements to que
    * */
    static void reorderInterLeaveStack(Queue<Integer>que){
        Stack<Integer> st = new Stack<>();
        int half = que.size()/2;
        for(int i =0;i<half;i++){  // 1) remove the n/2 element from que and insert into stack
            st.add(que.remove());//que->5,6,7,8
        }
        while (st.size()!=0){// 2) push back the elements from queue to stack
            que.add(st.pop()); //que->5,6,7,8,4,3,2,1
        }
        for(int i =0;i<half;i++){  //  3) again remove n/2 elements from que and insert to stack
            st.add(que.remove());//que->4,3,2,1
        }
        while (st.size()!=0){
            que.add(st.pop());//que->8,4,7,3,6,2,5,1
            que.add(que.remove());//4) then do one by one operation i.e. first pop the element from stack and then remove the element of que and add back

        }

        while (que.size()!=0){//5) reverse the queue means put all the elements into stack and all back all elements to que
            st.push(que.remove());
        }
        while (st.size() != 0) {
            que.add(st.pop());
        }
        System.out.println(que); // {1,5,2,6,3,7,4,8}
    }
    public static void main(String[] args) {
        int arr[] = {12,-1,-7,8,-15,30,16,28}; // {-1,-1,-7,-15,-15,0}
        int arr1[] = {-8,2,3,-6,10};//{-8,0,-6,-6}
//        negativeWindowIterative(arr1,2);
//        negativeWindowQueue(arr,3);

        int arr2[] = {1,2,3,4,5,6,7,8};
//        reorderInterleaveBruteForce(arr2);

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        que.add(6);
        que.add(7);
        que.add(8);
        reorderInterLeaveStack(que);//{1,5,2,6,3,7,4,8}


    }
}
