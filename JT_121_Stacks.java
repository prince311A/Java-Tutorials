
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.StreamSupport;

public class JT_121_Stacks {
    /*NOTE:-
            * Drawback -> We cannot access the non-top element of stack remove removing the top element so, at any cost we cant prevent the stack elements
*Advantage -> Kind of Unlimited Size */
/* In-built Methods
* isEmpty()
* peak()- view top element
* push()- add element at top
* pop()- remove top element
* size()- length of stack
* */
//    Q1) Find the element in the stack in given index (1 base indexing){
    static void getElement(Stack<Integer> st,int idx){ // 1base indexing
        while (st.size()>idx){
            st.pop();
        }
        System.out.println(st.peek());
    }
    //    Q2) Copy Stack
    static void copyStackReverse(Stack<Integer> st){
        Stack<Integer> copySt = new Stack<>();
        while (st.size()>0){
//            int temp = st.pop();
//            copySt.push(temp);
            // one line
            copySt.push(st.pop()); // by this original stack become empty
        }
        System.out.println(copySt); // copying but in reverse order
    }
    static void actualCopyStack(Stack<Integer> st){
        Stack<Integer> tempCopy = new Stack<>();
        while (st.size()>0){
            tempCopy.push(st.pop());
        }
        System.out.println(tempCopy);
        Stack<Integer> copy = new Stack<>();
        while (tempCopy.size()>0){
            copy.push(tempCopy.pop());
        }
        System.out.println("This Is Copy "+copy);
    }
//    Q2) Insert Element in stack in given index
    static void insertAtGivenIndex(Stack<Integer> st,int idx,int ele){
        Stack<Integer> tempSt = new Stack<>();
        while (st.size()>idx){
            tempSt.push(st.pop());
        }
        st.push(ele);
        while (tempSt.size()>0){
            st.push(tempSt.pop());
        }
        System.out.println(st);
    }
//    Q3) Print all the elements of stack without empty the stack (print-function)
    static void displayStack(Stack<Integer>st){
        Stack<Integer> tempst = new Stack<>();
        while (st.size()>0){
            tempst.push(st.pop());
        }
        while (tempst.size()>0){
            System.out.print(" "+tempst.peek());
            st.push(tempst.pop());
        }
    }
//    Q4) Print elements by recursion
    static void displayStackRec(Stack<Integer>st){
        if(st.empty())return;
        int x = st.pop();
        displayStackRec(st);
        System.out.print(" "+x);
        st.push(x);// this is necessary because after poping the element stack becomes empty so we have to add back to the stack
    }
//    Q5) ) Delete Element in stack At given index
    static void removeAtIndex(Stack<Integer>st,int idx){
        Stack<Integer> tempSt = new Stack<>();
      while (st.size()>idx+1){
               tempSt.push(st.pop());
       }
      st.pop();
        while (tempSt.size()>0){
            st.push(tempSt.pop());
        }
        System.out.println(st);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(7);
        st.push(8);
        st.push(9);
        st.push(10);
//        System.out.println(st.isEmpty()); // boolean
//        System.out.println(st.size());//5
//        System.out.println(st.peek());//10
//        System.out.println(st.pop());//10-> give which element at the top

        // printing element of stack
        System.out.println(st);

//        getElement(st,2);// by poping top elements were lost
//        System.out.println(st);


//        copyStackReverse(st); // by copying stack elements automatically reversed
//        actualCopyStack(st);// same order
//        insertAtGivenIndex(st,1,99);
//        displayStack(st);// without emptying the array
//        displayStackRec(st);
        removeAtIndex(st,0);


    }

}