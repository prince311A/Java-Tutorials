import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
/* Time Complexity of Priority Queue
* add/insert -> O(log N)
* delete/remove -> O(log N)
* peek --> O(1)
* finding min/max --> O(1)
* */
public class JT_139_PriorityQueue {
    static void priorityQueueExamples(){
        PriorityQueue<Integer>pq = new PriorityQueue<>(); // by default this is a min preference priority queue
        pq.add(8);
        pq.add(9);
        pq.add(5); // gives priority to 5;
        System.out.println(pq);//5,8,9 it only gives priority to small element other will place randomly
        System.out.println(pq.peek());//5
        pq.remove();
        System.out.println(pq);//8,9
        System.out.println(pq.peek());//8
        pq.add(1);
        System.out.println(pq);//1,9,8

    }
    static void dequeExamples(){
        Deque<Integer> due = new ArrayDeque<>();
        due.addFirst(1);
        due.addFirst(2);
        due.addLast(3);
        System.out.println(due);//2,1,3

    }
    static void maxPriorityQueueExamples(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());// preference to maximum element
        pq.add(8);
        pq.add(9);
        pq.add(5); // gives priority to 9;
        System.out.println(pq);//9,8,5 it only gives priority to small element other will place randomly
        System.out.println(pq.peek());//9
        pq.remove();
        System.out.println(pq);//8,5
        System.out.println(pq.peek());//8
        pq.add(1);
        System.out.println(pq);//8,5,1
    }
    public static void main(String[] args) {
//     priorityQueueExamples();
//     maxPriorityQueueExamples();
//     dequeExamples();


    }
}
