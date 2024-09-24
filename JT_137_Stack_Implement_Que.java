import java.util.Stack;

public class JT_137_Stack_Implement_Que {
    //    Q1) (LEETCODE 232) Implementing Queue using Stack
    /*QUEUE methods:-
     * add()
     * remove()
     * peek()
     * size()
     * display()
     * isFull()
     * isEmpty()
     * isCapacity
     * */
    // Complexities--> space- O(1) no extra space
    // push/add() --> O(1) this is push efficient approach
    // pop() --> O(n)
    // peek() --> O(n)
    // We can also make pop()/peek() --> O(1) pop()/peek() efficient approach, add()-> (n)
    public static class Queue1{
     private    Stack<Integer> st = new Stack<>();// this stack is for push efficient
        private Stack<Integer> st1 = new Stack<>();//this stack is for peek/pop efficient
        public void pushEfficient(int ele){//TC.O(1)
            st.add(ele);
        }
        public int pop(){//TC.O(n)
            Stack<Integer> temp = new Stack<>();
          while (st.size()>1){
                temp.push(st.pop());
            }
            int x = st.pop();
            while (temp.size()!=0){
                st.push(temp.pop());
            }
            return x;
        }
        public int peek(){//TC.O(n)
            Stack<Integer> temp = new Stack<>();
            while (st.size()>1){
                temp.push(st.pop());
            }
            int x = st.peek();
            while (temp.size()!=0){
                st.push(temp.pop());
            }
            return x;
        }
        public int size(){
            return st.size();
        }
        public void display(){
            System.out.println(st);
        }
        public boolean isEmpty(){
            if(st.empty())return true;
            else return false;
        }
        // POP Efficient Approach
        // We can also make pop()/peek() --> O(1) pop()/peek() efficient approach, add()-> (n)
        public void add(int ele){//TC.O(n)
            Stack<Integer> temp = new Stack<>();
            if(st1.size()==0){
                st1.push(ele);
            }

            else {
                while (st1.size()!=0){
                    temp.push(st1.pop());
                }
                st1.push(ele);
                while (temp.size()!=0){
                    st1.push(temp.pop());
                }
            }
        }
        public int popEfficient(){//TC.O(1)
            return st1.pop();
        }
        public int peekEfficient(){//TC.O(1)
            return st1.peek();
        }

    }
    public static void main(String[] args) {
        Queue1 que = new Queue1();
        que.pushEfficient(1);
        que.pushEfficient(2);
        que.pushEfficient(3);
        que.pushEfficient(4);
        que.pushEfficient(5);
        System.out.println(que.size());//5
        que.display();//1.2.3.4.5
        System.out.println(que.pop());//1
        que.display();//2.3.4.5
        System.out.println(que.size());//4


    }
}
