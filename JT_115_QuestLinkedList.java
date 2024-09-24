import java.sql.SQLOutput;
import java.util.Arrays;

public class JT_115_QuestLinkedList {
    static void display(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
//    Q1) Deep Copy Linked List Into another List
    static void deepCopyLinkedList(Node head){
        Node newHead = new Node(head.data);
        Node tempNewHead = newHead;
        Node tempHead = head;
        while (tempHead.next!=null){
            Node newNode = new Node(tempHead.next.data);
            tempNewHead.next= newNode;
            tempHead = tempHead.next;
            tempNewHead = tempNewHead.next;
        }
        display(newHead);

    }
    public static Node getNode(Node head, int idx){
        Node temp = head;
        for(int i =0;i<idx;i++){
            temp = temp.next;
        }
        return temp;
    }
//    Q2) Palindrome check by twoPointer approach
    static void twoPointerPalindrome(Node head){ // approach like array but here we have to find the node(getNode()) then match values
        int i =0;
        int j = 5;
        while (i<j){
            Node tempo = getNode(head,i);
            Node memo = getNode(head,j);
            if(tempo.data!= memo.data){
                System.out.println("Not Palindrome");
                return;
            }
            i++;j--;
        }
        System.out.println("Palindrome");
    }
    // optimized way
    static boolean optimizePalindromeList(Node head){
        Node slow = head;
        Node fast = head;
        while (fast.next!=null && fast.next.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node half = slow.next;
        Node curr = half;
        Node prev = null;
        Node alga = null;
        while (curr!=null){
            alga = curr.next;
            curr.next = prev;
            prev = curr;
            curr = alga;
        }
//        display(prev); // list after reversing half of main
        Node temp = head;
        slow.next = prev;
        Node temp2 = slow.next;
              while (temp!=slow){
           if(temp.data!=temp2.data){
               System.out.println("Not Palindrome");return false;
           }
           temp2 = temp2.next;
           temp = temp.next;
       }
              return true;
    }
//    Q3) (LEETCODE 2130) Find the maximum twin sum of a linked list of even length
    /* Explanation -: 1->10->13->4->5->6 ==> (1+6),(10+5),(13+4) o/p max=> (10+5)=15
     */
    static void maxTwinSum(Node head){
        /*LEETCODE Optimized
        *  public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println(slow.val);
        ListNode curr = slow.next;
        ListNode prev = null;
        ListNode agla = null;
        while (curr != null) {
            agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
        ListNode temp1 = prev;
        ListNode temp2 = head;
        int max = Integer.MIN_VALUE;
        while (temp1 != null) {
            max = Math.max(max, (temp1.val + temp2.val));
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        // System.out.println(max);
        return max;
    }*/

        // using two pinter approach
        Node temp = head;
        int size = 0;
        while (temp!=null){
            size++;
        temp = temp.next;
        }
        int max  = 0;
        int i =0;
        int j = size-1;
        while (i<j){
            Node tempo = getNode(head,i);
            Node memo = getNode(head,j);
            if(max<tempo.data+memo.data){
                max = tempo.data+memo.data;
            }
            i++;
            j--;
        }
        System.out.println("The maximum twin sum is "+max);

    }
//    Q4) (LEETCODE 328) Even Odd Linked List with space complexity O(1)
    /* Explanation -: Arrange the linked into even odd format with respect to index
     */
    static void leetOddEven(Node head){
        Node even = new Node(0);
        Node odd = new Node(0);
        Node etemp = even;
        Node otemp = odd;
        Node temp = head;
        while (temp!=null){
            otemp.next = temp;
            temp = temp.next;
            otemp = otemp.next;


            etemp.next = temp;
            if(temp==null)break;
            temp = temp.next;
            etemp = etemp.next;
        }
        odd = odd.next;
        even = even.next;
        otemp.next = even;
        display(odd);
    }

    public static void main(String[] args) {
        Node a = new Node(2);//2
        Node b = new Node(7);//7
        Node c = new Node(4);//4
        Node d = new Node(4);//55
        Node e = new Node(7);//36
        Node f = new Node(2);//12

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
     //   display(a);
//        deepCopyLinkedList(a);

//        twoPointerPalindrome(a);

       // System.out.println(optimizePalindromeList(a));

        Node aa = new Node(1);
        Node bb = new Node(10);
        Node cc = new Node(13);
        Node dd = new Node(4);
        Node ee = new Node(5);
        Node ff = new Node(6);
        Node gg = new Node(7);
        Node hh = new Node(2);

        aa.next = bb;
        bb.next = cc;
        cc.next = dd;
        dd.next= ee;
        ee.next = ff;
        ff.next = gg;
        gg.next = hh;
//        display(aa);
//        (1+2),(10+7),(13+6),(4+5) o/p max=> (13+6)=19
//        maxTwinSum(aa);

        Node A = new Node(1);
        Node B  = new Node(2);
        Node C = new Node(3);
        Node D = new Node(4);
        Node E = new Node(5);
//        Node F = new Node(6);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
//        E.next = F;
        display(A);
//        leetOddEven(A);

    }
}
