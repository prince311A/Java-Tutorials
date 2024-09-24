import java.security.SecureRandom;
import java.util.stream.StreamSupport;

public class JT_116_DoublyList {
    static void backdisplay(Node last){
        Node temp = last;
        while (temp!=null){
            System.out.print(" "+temp.data);
            temp = temp.prev;
        }
        System.out.println();
    }
    static void display(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
    public static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        }
    }
    static void displayWithRandomNode(Node node){
        Node temp = node;
        while (node.prev!=null){
            node = node.prev;
        }
        while (node != null) {
            System.out.print(" "+node.data);
            node = node.next;
        }
        display(node);
    }
    static Node insertAtStart(Node head,int val){
        Node temp =  new Node(val);
        if(head==null)return null;
        temp.next = head;
        head.prev = temp;
        head = temp;
        return head;
    }
    static Node insertAtLast(Node head,int val){
        Node temp = new Node(val);
        Node seach = head;
        while (seach.next!=null){
            seach = seach.next;
        }
        seach.next = temp;
        temp.prev = seach;
        return head;
    }
    static Node insertAtMiddle(int idx,int val,Node head){
        Node search = head;
        Node temp =new Node(val);
        if(search==null)return null;

        for(int i = 0;i<idx-1;i++){
            search = search.next;
        }
        temp.next = search.next;
        temp.prev =search;
        search.next = temp;
        temp.next.prev = temp;
        return head;
    }
    public static void main(String[] args) {
        Node a = new Node(5);
        Node b = new Node(4);
        Node c = new Node(7);
        Node d = new Node(11);
        Node e = new Node(1);
        Node f = new Node(6);

        a.next = b;
        b.next = c;
        b.prev = a;
        c.next = d;
        c.prev = b;
        d.next = e;
        d.prev = c;
        e.next = f;
        e.prev = d;
        f.prev = e;
        display(a);// printing by head
       // backdisplay(f);// printing by tail
//        displayWithRandomNode(c);// printing by random node

//       Node node = insertAtStart(a,0);
//        display(node);

//        Node node = insertAtLast(a,45);
//        display(node);

        Node node = insertAtMiddle(1, 59,a);
        display(node);
    }
}
