import com.sun.security.jgss.GSSUtil;

import java.util.LinkedList;
import java.util.Queue;

public class JT_136_ImplementStackbyQueue {
//    Q1) (LEETCODE 225) Implementing stack using Queue
/*Implement the methods of stack
 * push()
 * pop()
 * peek()
 * size()
 * display()
 * isEmpty()
 * isFull()
 * capacity
 */
    // Complexities--> space- O(1) no extra space
    // push/add() --> O(1) this is push efficient approach
    // pop() --> O(n)
    // peek() --> O(n)
    // We can also make pop()/peek() --> O(1) pop()/peek() efficient approach, add()-> (n)
    public static class Stackk{
       private Queue<Integer> que = new LinkedList<>(); // this queue is for push efficient
       private Queue<Integer> que1 = new LinkedList<>(); // this queue is for peek/pop efficient
        public void addEfficient(int ele){ //TC. O(1)
            que.add(ele);
        }
        public int peek(){//TC.O(n)
            for(int i =0;i<que.size()-1;i++){
                que.add(que.remove());
            }
            int x = que.peek();
            que.add(que.remove());
            return x;
        }
        public int pop(){ //TC.O(n)
            for(int i =0;i<que.size()-1;i++){
                que.add(que.remove());
            }
            int x = que.remove();
            return x;
        }
        public boolean isEmpty(){
            if(que.size()==0)return true;
            else return false;
        }
        public void display(){
            System.out.println(que);
        }
        public int size(){
            return que.size();
        }
        // POP Efficient Approach
        // We can also make pop()/peek() --> O(1) pop()/peek() efficient approach, add()-> (n)
        public void add(int ele){//TC.O(n)
            if(que1.size()==0){
                que1.add(ele);
            }else {
                que1.add(ele);
                for(int i =0;i<que1.size()-1;i++){
                    que1.add(que1.remove());
                }
            }
        }
        public int peekEfficient(){//TC.O(1)
            if(que1.size()==0){
                System.out.println("Stack is Empty");
                return -1;
            }
            return que1.peek();
        }
        public int popEfficient(){//TC.O(1)
            if(que1.size()==0){
                System.out.println("Stack is Empty");
                return -1;
            }
            return  que1.remove();
        }
}
public static void main(String[] args) {
    Stackk st = new Stackk();
    st.addEfficient(1);
    st.addEfficient(2);
    st.addEfficient(3);
    st.addEfficient(4);
    st.display();//1,2,3,4
    System.out.println(st.pop());//4
    st.display();//1,2,3
    System.out.println(st.size());//3
}
// NOTE:- We can implement stack by both add efficient queue or peek/pop efficient queue
}
