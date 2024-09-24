import java.util.Stack;
//Q1) Min Stack (LEETCODE 155)
/** If we want to get the minimum element in array then we have to traverse the array and that's T.C will be O(n)
 * But here it can be find in T.C of 0(1) using stack
 * Approach 1-> make extra stack every time and take variable to store minimum element then restore all elements to stack.
 * Approach 2-> make a permanent minStack and store the minimum element every time when we push any element to original stack
 * Approach 3-> no use of extra stack we use formula to find minimum
 *When we solve this on leetcode must assure that min variable is not (int) it must be on (long) and stack will be also (Long) type to pass all testcases
 */
public class JT_129_StackQuest {
    // Approach 2.
    public static class Stacks{
        Stack<Integer> st = new Stack<>();
        Stack<Integer> minSt = new Stack<>();
        void push(int ele){
           if(st.size()==0){
               st.push(ele);
               minSt.push(ele);
           }
           else {
               st.push(ele);
               if(ele>minSt.peek()){
                   minSt.push(minSt.peek());
               }
               else{
                   minSt.push(ele);
               }
           }
        }
        void pop(){
            st.pop();
            minSt.pop();
        }
        int peek(){
          return st.peek();
        }
        int getMin(){
           return minSt.peek();
        }
        void display(){
            System.out.println(st);
        }
    }
    // Approach 3.
    public static class Stacks2{
        int min ;
        Stack<Integer> st = new Stack<>();
        void push(int ele) {
            if (st.size() == 0) {
                st.push(ele);
                min = ele;
            } else {
                if (min <= ele) {
                    st.push(ele);
                }
               if (min > ele) {
                    st.push((2*ele) - min); //    st.push(ele - min)==> this formula not working when there is consecutive negative numbers
                                             // So instead of this we use => (2*ele)-min
                    min = ele;
                }
            }
        }
        void pop(){
            if(st.size()==0)return;
          else if(st.peek()>=min) {
                st.pop();

            }
//           else if(st.peek()<min){
            min = (2*min)-st.peek(); //   min = (2*min)-st.peek()==> this formula not working when there is consecutive negative numbers
            // So instead of this we use => (2*min)-st.peek();
                st.pop();
//            }
        }
        int peek() {
            if (st.size() == 0) {
                return -1;
            }
            if (st.peek() >= min) {
                return st.peek();
            }
            if (st.peek() < min) {
                return min;
            }
            return 0;
        }
        int getMin(){
            return min;
        }
        void display(){
            System.out.println(st);
        }
    }


    public static void main(String[] args) {
        Stacks st1 = new Stacks();
//        st1.push(7);
//        st1.push(8);
//        st1.push(5);
//        st1.push(6); st1.push(3); st1.push(4);
//        st1.display();
//        System.out.println(st1.getMin());
//        st1.pop();
//        st1.pop();
//        st1.display();
//        System.out.println(st1.getMin());

        // Stacks2 object
        Stacks2 st2 = new Stacks2();
        st2.push(9);
        st2.push(2);
        st2.push(3);
        st2.push(1);
        st2.display();
        System.out.println(st2.getMin());
        st2.pop();
        st2.display();
        System.out.println(st2.getMin());

    }
}
