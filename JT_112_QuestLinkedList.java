public class JT_112_QuestLinkedList {
    static void display(Node temp){
    while (temp!=null){
        System.out.print(temp.data+" ");
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
    //    Q4) Find the intersection node of two linked lists (LEETCODE 160)
    static Node intersectionOfTwo(Node temp1, Node temp2){ // this code works perfectly only in case of both linked list having equal size
        Node head1 = temp1;
        Node head2 = temp2;
        while(head1!=head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
    static Node optimizeIntersectionOfTwo(Node temp1, Node temp2){
        Node head1 = temp1;
        Node head2 = temp2;
        int sizehead1 = 0;
        int sizehead2 = 0;
        while(head1!=null){
            head1 = head1.next;
            sizehead1++;
        }
        while(head2!=null){
            head2 = head2.next;
            sizehead2++;
        }
        head1 = temp1;
        head2 = temp2;
        if(sizehead1>sizehead2){
            int idx = sizehead1-sizehead2;
            for(int i =0;i<idx;i++){
                head1 = head1.next;
            }
            }
        else {
            int idx = sizehead2-sizehead1;
            for(int i =0;i<idx;i++){
                head2 = head2.next;
            }
        }
        while (head1!=head2){
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }
    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(4);
        Node c = new Node(3);
        Node d = new Node(6);
        Node e = new Node(8);

        Node x = new Node(17);
        Node y = new Node(34);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        x.next = y;
        y.next = c; // Here c or (3) is our intersecting node

        display(a);
        display(x);

     //   Node intersect = intersectionOfTwo(a,x);// this code works perfectly only in case of both linked list having equal size
      //  System.out.println(intersect.data);

     Node intersect1 = optimizeIntersectionOfTwo(a,x); // this code working for both equal or unequal linked list
        System.out.println(intersect1.data);

    }
}
