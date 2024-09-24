import java.util.HashSet;

public class JT_114_QuestLinkList {
    static void display(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static class Node{
        int data ;
        Node next ;
        Node(int data){
            this.data = data;
        }
    }
//Q1) Separate a linked list into two lists one containing odd while other even (LEETCODE 328)
    static void evenOddLinkedLists(Node head){ // using extra space
        Node temp = head;
        Node even = new Node(88);
        Node etemp = even;
        Node odd = new Node(89);
        Node otemp = odd;
        while (temp!=null){
            if(temp.data%2==0){
                Node a = new Node(temp.data);
                etemp.next = a;
                etemp = a;
                temp = temp.next;
            }
            else{
                Node a = new Node(temp.data);
                otemp.next = a;
                otemp = a;
                temp = temp.next;
            }
        }
        otemp = odd.next;
        display(even.next);
        display(odd.next);
        etemp.next = otemp; // converting into single list
        display(even.next);
    }

//    Q2) Remove duplicates in sorted linked list (LEETCODE)
    static void removeDuplicateLinkedList(Node head){
        // My leetcode approach
        /*    if(head==null)return null;
        ListNode temp = head;
        ListNode check = head;
        while (temp.next!=null){
            if(temp.val!=temp.next.val){
                check.next = temp.next;
                check = temp.next;

            }
            temp = temp.next;
        }
        check.next = null;
        return head;
        * */

        Node temp = head;
        while (temp!=null) {
            while (temp.data == temp.next.data) {
                temp.next = temp.next.next;
                if(temp.next==null)break; // by my own mind
            }
                temp = temp.next;
        }
        display(head);
    }

//    Q3) Reverse the Linked List (LEETCODE 206)
    static Node recursiveReverseList(Node head){
       if(head.next==null)return head;
       Node newNode = recursiveReverseList(head.next);
       head.next.next = head;
       head.next = null;
       return newNode;
    }
    // easy approach
    static void iterativeReverseList(Node temp){ // three pointer approach
        Node head = temp;
        Node prev = null;
        Node agla = null;
        while (head!=null){
            agla = head.next;
            head.next = prev;
            prev = head;
            head = agla;
        }
        display(prev);
    }
    static Node getNode(Node head,int idx){
        Node temp = head;
        for(int i =0;i<idx;i++){
            temp = temp.next;
        }
        return temp;

    }
    static void twoPointerReverseList(Node head){ // two pointer approach
        // using getElement() to access the node
        int i =0;
        int j = 5;
        while (i<j){
            Node temo =getNode(head,i);
            Node memo = getNode(head,j);
            int tempp = temo.data;
            temo.data = memo.data;
            memo.data = tempp;
            i++;j--;
        }
        display(head);
    }
//    Q4) Deep copy the linked list to another list and check it is palindrome or not. (LEETCODE 234)
    static void copyLinkedList(Node head){
        Node newhead = new Node(head.data); // creating new linked list
        Node temp2 = newhead;
        Node temp = head.next;
        while(temp!=null) { // copying the linked list
            Node newNode = new Node(temp.data);
            temp2.next = newNode;
            temp = temp.next;
            temp2 = temp2.next;
        }
        System.out.print("This is Copied ");display(newhead); // copied linked list

       temp2 = newhead;
       Node prev = null;
       Node after = null;
       while(temp2!=null) { // reversing the linked list
           after = temp2.next;
           temp2.next = prev;
           prev = temp2;
           temp2 = after;
       }

        newhead = prev;
        System.out.print("Reverse ");display(newhead); // reverse linked list

        temp = head;
        temp2 = newhead;
        int x = 0;


//        ****************************************************************************
        while (temp!=null) {
            if (temp.data != temp2.data) { // matching the elements of linked list
                x = 1;
                break;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        if(x==1){
            System.out.println("Not Palindrome");
        }
        else{
            System.out.println("Palindrome");
        }
    }
//    Q5) LEETCODE 328 ODD EVEN LIST
public  static Node oddEvenList(Node head) {
        // Without extra space
        /*
        ListNode odd = new ListNode(-1);
        ListNode tempOdd = odd;
        ListNode even = new ListNode(-1);
        ListNode tempEven = even;
        ListNode temp = head;
        while (temp != null) {
            tempOdd.next = temp;
            tempOdd = tempOdd.next;
            temp = temp.next;

            tempEven.next = temp;
            tempEven = tempEven.next;
            if (temp == null)
                break;
            temp = temp.next;
        }
        tempOdd.next = even.next;
        return (odd.next);
    }
        */
    if(head==null)return null;
    Node main = new Node(-1);
    Node mainTemp = main;
    Node temp = head;
    while (temp!= null ) {
        Node tempu = new Node(temp.data);
        mainTemp.next = tempu;
        mainTemp = mainTemp.next;
        if(temp.next==null)break;
        temp = temp.next.next;
    }
    temp = head;
    temp = temp.next;
    while (temp != null) {
        Node tempu = new Node(temp.data
        );
        mainTemp.next = tempu;
        mainTemp = mainTemp.next;
        if(temp.next==null)break;
        temp = temp.next.next;
    }
    return main.next;
}
//Q6) SortList (LEETCODE 148)
public static Node sortList(Node head) {
//     Perfect code but time limit exceeded
     Node temp = head;
     while (temp != null) {
         Node temp1 = head;
         boolean flag = false;
         while (temp1.next != null) {
             if (temp1.data> temp1.next.data) {
                 int x = temp1.data;
                 temp1.data = temp1.next.data;
                 temp1.next.data = x;
                 flag = true;
             }
             temp1 = temp1.next;
         }
         if (!flag)
             break;
         temp = temp.next;
     }
     return head;
//  Method 2-->
    /*
    *   Node temp = a;
        List<Integer>arrayList = new ArrayList<>();
        while(temp!=null){
            arrayList.add(temp.val);
            temp = temp.next;
        }
//      System.out.println(arrayList);
        Collections.sort(arrayList);
//        System.out.println(arrayList);
        temp = a;
        int i =0;
        while (temp!=null){
            temp.val = arrayList.get(i++);
            temp = temp.next;
        }
        display(a);*/
}
    public static void main(String[] args) {
        Node a = new Node(1);//2
        Node b = new Node(2);//7
        Node c = new Node(3);//4
        Node d = new Node(3);//55
        Node e = new Node(2);//36
        Node f = new Node(1);//12

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
      //  display(a);
       // evenOddLinkedLists(a);

        Node aa = new Node(2);
        Node bb = new Node(2);
        Node cc = new Node(2);
        Node dd = new Node(3);
        Node ee = new Node(4);
        Node ff = new Node(4);
        Node gg = new Node(4);
        Node hh = new Node(5);
        Node ii = new Node(5);
        Node jj = new Node(5);

        aa.next = bb;
        bb.next = cc;
        cc.next = dd;
        dd.next= ee;
        ee.next = ff;
        ff.next = gg;
        gg.next = hh;
        hh.next = ii;
        ii.next = jj;
//        display(aa);
//        removeDuplicateLinkedList(aa);

      // Node revHead =  recursiveReverseList(a);
      //  display(revHead);

//        iterativeReverseList(a);
      //  twoPointerReverseList(a);

//        copyLinkedList(a);

        Node ans = oddEvenList(a);
        display(ans);

    }
}
