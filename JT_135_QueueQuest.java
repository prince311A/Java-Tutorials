import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JT_135_QueueQuest {
//    Q1) Make Copy of the queue
    static void copyQueue(Queue<Integer>q1){
        Queue<Integer> copy = new LinkedList<>();
        while (q1.size()!=0){
            copy.add(q1.remove());// original array becomes empty
        }
        System.out.println(copy);
    }
//    Q2) Reverse the queue
    /*NOTE:- We cannot reverse the queue using extra queue's
     * So to reverse the queue there is two options either use recursion or using the stack
     * Using recursion space or memory used too much
     * So its better to use stacks to reverse the queue
     */

    static void reverseQueueRecursion(Queue<Integer>que){
       if(que.size()==0)return;
      int x = que.remove();
       reverseQueueRecursion(que);
       que.add(x);
    }
    // reverse queue using stacks (optimized approach use less T.C && S.C compare to recursive reverse)
    static void reverseQueueStack(Queue<Integer>que){
        Stack<Integer> st = new Stack<>();
        while (que.size()!=0){
            st.add(que.remove()); //Here order is same 1,2,3,4,5 but when we pop it will reverse
        }
        while (st.size()!=0){
            que.add(st.pop());
        }
        System.out.println(que);
    }
//    Q3) Reverse the first k element of the queue
    static void reverseFirstK(Queue<Integer>que,int k){// 1,2,3,4,5
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<k;i++){
            st.add(que.poll()); // adding k elements in stack to reverse (1,2,3)
        }
        while (st.size()!=0){
            que.add(st.pop()); //adding back to queue in reverse order but it will place from rear
        }
        // 4,5,3,2,1 then we have to make 3,2,1,4,5
        for(int i = k;i<que.size();i++){
            que.add(que.poll());
        }
        System.out.println(que);//3,2,1,4,5
    }
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        System.out.println(q1);


        //copyQueue(q1); after this q1 becomes empty

//        reverseQueueRecursion(q1);
//        System.out.println(q1);//5,4,3,2,1....after this q1 is reverse

//        reverseQueueStack(q1);//5,4,3,2,1....after this q1 is reverse

//        reverseFirstK(q1,3);
    }
}