import java.util.LinkedList;
import java.util.Queue;
/*Inbuilt Methods of Queue
* add() like push() of stack
* remove() or poll() like pop()
* peek() or element() like peek()
* size()
* isEmpty
* */
// NOTE:- When to move to element of stack to another stack they placed in reverse order but In queue's when we move elements to another queue
// they placed in same order as in original queue
public class JT_130_Queue {
//    Q1) Print all the number in the queue without using in-built method
    static void display(Queue<Integer>que){
        Queue<Integer> temp = new LinkedList<>();
        while (que.size()!=0){
            int top = que.remove();
            System.out.print(top+" ");
            temp.add(top);
        }
        System.out.println();
        que = temp; // we dont want to empty the original queue
        System.out.println(que);

//        System.out.println(temp);
    }
    //    Q2) Print all the element of the queue using recursion
    static void queueRecursion(Queue<Integer> que){
        if(que.size()==0)return;
        int x = que.poll();
        System.out.print(x+" ");
        queueRecursion(que);
        // Note:- Here que becomes empty because we are removing the elements
        que.add(x); // So we have to add also
        // Here when we add back the elements it will place in reverse order
    }
    //    Q2) Print all the element in reverse order of the queue using recursion
    static void queReverseRecursion(Queue<Integer>que){
        if(que.size()==0)return;
        int x = que.poll();
        queReverseRecursion(que);
        System.out.print(x+" ");
        // Note:- Here que becomes empty because we are removing the elements
        que.add(x); // So we have to add also
        // Here when we add back the elements it will place in the reverse order as well
    }
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>(); // Here we have only two options that is linkedList<> or Dequeue<>, cant write new Queue()
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        System.out.println("In-built method " + que);//1,2,3,4,5
//        que.remove();
//        System.out.println(que);//2,3,4,5
//        System.out.println(que.peek());//2
//        **************************************************************************
//        display(que); //1,2,3,4,5
//        ***************************************************************************
//        queueRecursion(que);//1,2,3,4,5
//        System.out.println();
//        System.out.println(que);// it will reverse when we have to add back elements 5,4,3,2,1
//        ***************************************************************************
        queReverseRecursion(que);//1,2,3,4,5
        System.out.println();
        System.out.println(que);// it will reverse when we have to add back elements 5,4,3,2,1
    }
}
