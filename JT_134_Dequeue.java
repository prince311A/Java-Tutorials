import java.util.ArrayDeque;
import java.util.Deque;

public class JT_134_Dequeue {
    //NOTE:-It is also to implement the Dequeue using Array
    // For add() ->First we have to add the element from rear (rear++) if there is overflow then we have to check the front,if front!=0 then we have to add from front(f--)
    // For remove() -> If we want to remove element from front we just do (front++), but if we want to remove from rear we have to do (rear--)
    /*Deque Methods():-
     * addFirst()
     * addLast()
     * removeFirst()
     * removeLast()
     * size()
     * isEmpty()
     * removeFirstOccurrence()
     * removeLastOccurrence()
     * peek() -> returns element at front
     */
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);
        System.out.println(dq);//3,2,1
        dq.addLast(4);
        System.out.println(dq);//3,2,1,4
        dq.removeFirst();
        System.out.println(dq);//2,1,4
        System.out.println(dq.size());//3
        System.out.println(dq.peek());//2
    }
}