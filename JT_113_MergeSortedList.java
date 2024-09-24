import java.util.HashSet;

public class JT_113_MergeSortedList {
    //    Question) Merge the two Sorted Linked List into one single Linked List(extra space)(LEETCODE 21)
    static void mergeSortedLists(Node temp1, Node temp2){ // using extra space
        Node head1 = temp1;
        Node head2 = temp2;
        Node head= new Node(100);
        Node temp = head;
        while (head1!= null && head2!=null){
            if(head1.data<head2.data){
                Node aa = new Node(head1.data);
                temp.next = aa;
                temp = aa;
                head1 = head1.next;
            }
            else{
                Node aa= new Node(head2.data) ;
                temp.next = aa;
                temp = aa;
                head2 = head2.next;
            }
        }
        if(head1==null){
            temp.next = head2;
        }else {
            temp.next = head1;
        }
        display(head.next);
    }
    static void display(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    static void optimizeMergeSortedList(Node temp1, Node temp2){ // without using extra space
        Node head1 = temp1;
        Node head2 = temp2;
        Node head = new Node(100);
        Node temp = head;
        while (head1!=null && head2!=null){
            if(head1.data<head2.data){
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                temp =temp.next;
                head2 = head2.next;
            }
        }
        if(head1==null){
            temp.next = head2;
        }else {
            temp.next = head1;
        }
        display(head.next);
    }
    public static class Node{
        int data;
        Node next ;
        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(5);
        Node d = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;

        display(a);

        Node A = new Node(2);
        Node B = new Node(4);
        Node C = new Node(6);
        Node D = new Node(8);
        A.next = B;
        B.next = C;
        C.next = D;
        display(A);
      //  mergeSortedLists(a,A);
        optimizeMergeSortedList(a,A);
    }
}
