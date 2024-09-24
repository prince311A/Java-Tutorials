import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JT_186_HeapQuest {
    static void addElement(PriorityQueue<Integer> leftPq,PriorityQueue<Integer> rightPq,int element){
       if(leftPq.isEmpty()){
           leftPq.add(element);
           return; // insert when left is empty
       }
       else if(rightPq.isEmpty()){  // insert when right is empty
            if(element > leftPq.peek()){ // right mai jana hai
                rightPq.add(element);
            }else{
                rightPq.add(leftPq.remove()); // left mai jana hai
                leftPq.add(element);
            }
        }
       else {  // insert when both are not empty
           if (element > rightPq.peek()){ // right me insert karna hai
               if(leftPq.size() == rightPq.size()){
                   leftPq.add(rightPq.remove());
                   rightPq.add(element);
               }
               else{
                   rightPq.add(element);
               }
           }
           else{ // left mai insert karna hai
               if(leftPq.size() == rightPq.size()){
                   leftPq.add(element);
               }
               else{
                   rightPq.add(leftPq.remove());
                   leftPq.add(element);
               }
           }
       }
    }
    static double calculateMedian(PriorityQueue<Integer>leftPq,PriorityQueue<Integer>rightPq){
        if(leftPq.isEmpty())return -1;
        else if (leftPq.size() - rightPq.size() == 1) return leftPq.peek();
        else return (double) (leftPq.peek() + rightPq.peek())/2;
    }
    public static void main(String[] args) {
        PriorityQueue<Integer>leftPq = new PriorityQueue<>(Comparator.reverseOrder());// max heap
        PriorityQueue<Integer>rightPq= new PriorityQueue<>(); // min heap;
        addElement(leftPq,rightPq,15);
        System.out.println(calculateMedian(leftPq,rightPq)); // 15
        addElement(leftPq,rightPq,10);
        System.out.println(calculateMedian(leftPq,rightPq)); // 12.5
        addElement(leftPq,rightPq,5);
        System.out.println(calculateMedian(leftPq,rightPq)); // 10
        addElement(leftPq,rightPq,20);
        System.out.println(calculateMedian(leftPq,rightPq)); // 12.5
        addElement(leftPq,rightPq,25);
        System.out.println(calculateMedian(leftPq,rightPq)); // 15

    }
}
