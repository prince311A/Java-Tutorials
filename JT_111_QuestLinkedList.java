import java.sql.SQLOutput;
import java.util.LinkedList;

public class JT_111_QuestLinkedList {
    static void display(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    //    Q1) Delete the node without giving idx only Node is given which have to be deleted (237.LEETCODE) trick question
    // this trick is not valid in case of tail deletion throws error4
    static void deleteNode(Node del) {
        del.data = del.next.data;
        del.next = del.next.next;
        // NOTE:- here node never deleted it's the data's only which are swapped
    }

    //    Q2) Find the Nth node from the end of linked list
    static Node findNodeFromLast(Node head, int nodeFromLast) {
        // drawback is we are traversing linked list two times
        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        temp = head;
        int idx = size - nodeFromLast;
        for (int i = 1; i <= idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Optimized Approach by slow fast pointer
    static Node optimizeFindNodeFromLast(Node head, int nodefromlast) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < nodefromlast; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //    Q3) Removing the Nth node from end of linked list
    // Two ways are possible first is -> find the nth node from end by findNodeFromLast(); then apply deleteNode(); But deleteNode() not applicable for tail node
    // Second -> by only one traversal
    static Node deleteNodeFromLast(Node head, int nodeFromlLast) {
        Node last = findNodeFromLast(head, nodeFromlLast);
        Node temp = head;
        if (last == head) {
            head = last.next;
            return head;
        }
        while (temp.next != last) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;

    }

    // Optimized Approach by slow fast pointer
    static Node optimizeDeleteNodeFromLast(Node head, int nodeFromLast) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < nodeFromLast; i++) {
            fast = fast.next;
        }
//        Note:- throws error when nodeFromLast == size  To solve it
        if (fast == null) {
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    //    Q4) Finding the middle element of the linked list (LEETCODE 875)
    static Node middleElementList(Node head) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        temp = head;
        if (size % 2 == 0) {
            int idx = size / 2;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
        } else {
            int idx = size / 2 + 1;
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
        }
        return temp;
    }

    // Optimized Approach by slow fast pointer
    static Node optimizeMiddleElementList(Node head) {
        /*
         * Three Case are possbile here:-
         * If list size is odd then fast.next != null
         * If size is even (for right middle) then fast != null
         * If size is even (for left middle) then fast.next.next != null */
        // Code is valid for odd and for right middle
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //    Q5) Deleting the middle node of linked list (LEETCODE 2095)
    // Shortcut :- find the middle node by optimizeMiddleElementList() then call the deleteNode()
    // Lets go for actual deletion of node
    static Node deleteMiddleNode(Node head) {
//        Node middle = optimizeMiddleElementList(head);
//        deleteNode(middle); // Shortcut trick
//        display(head);

        Node slow = head;
        Node fast = head;
        while (fast.next.next != null && fast.next.next.next != null && fast.next.next.next.next != null) { // right middle, odd, left middle all three cases are covered
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    //    Q6) Check Cycle in a linked list (LEETCODE.141)
    static boolean checkCycleList(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
//    Q7) Cycle linked list-2 Find out the node where the cycle begins,i.e. the node at which tail points. (LEETCODE.142)
static void cycleList2(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null){
            slow= slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }

        Node temp = head;
        while(temp!=slow){
            temp = temp.next;
            slow = slow.next;
        }
    System.out.println(slow.data);

}
    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(6);
        Node e = new Node(8);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        display(a); // 5->4->3->6->8
     //   deleteNode(b); // 5->3->6->8
     //  display(a);

      Node last = findNodeFromLast(a,2);
       // System.out.println(last.data);   // this case (d)i.e output=>6


       Node last1 =  optimizeFindNodeFromLast(a,2); // slow fast concept
       // System.out.println(last1.data);// this case (d)i.e output=>6

     //   a = deleteNodeFromLast(a,2);// 5->4->3->8
      //  display(a);

    //  a = optimizeDeleteNodeFromLast(a,2);// 5->4->3->8 Note:- throws error when nodeFromLast == size
      //  display(a);

     Node middle =  middleElementList(a);
//        System.out.println(middle.data);

        Node middle1 = optimizeMiddleElementList(a);
       // System.out.println(middle1.data);

  //   a = deleteMiddleNode(a); // In case of 5->4->3->6 o/p 5->4->6 OR In case of 5->4->3->6->8 o/p 5->4->6->8
   //     display(a);


        Node A = new Node(3);
        Node B = new Node(2);
        Node C = new Node(0);
        Node D = new Node(-4);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = B;
//        System.out.println( checkCycleList(A));
        cycleList2(A);
    }
}
