public class JT_120_FlatterDoublyList {
//    Question) Flatter a Multi Doubly LinkedList(LEETCODE.430)
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
       Node prev;
       Node child;
        Node(int data){
            this.data = data;
        }
    }
    static Node flatterDoublyList(Node head){
    Node temp = head;
    while (temp!=null){
        Node t = temp.next;
        if(temp.child!=null){
            Node node = flatterDoublyList(temp.child);
            temp.next = node;
            node.prev = temp;
            while (node.next!=null){
                node = node.next;
            }
            node.next = t;
            t.prev = node;
        }
        temp.child = null; // for leetcode VVIMP
        temp = t;
    }

    return head;
    }
    public static void main(String[] args) {
        Node aa = new Node(1);
        Node bb = new Node(2);
        Node cc = new Node(3);
        Node dd = new Node(4);
        Node ee = new Node(5);
        Node ff = new Node(6);
        Node gg = new Node(7);
        Node hh = new Node(8);
        Node ii = new Node(9);
        Node jj = new Node(10);
        Node kk = new Node(11);
        Node ll = new Node(12);

        aa.next = bb;
        bb.next = cc;
        bb.prev = aa;
        cc.next = dd;
        cc.prev = bb;
        dd.next = ee;
        dd.prev = cc;
        ee.next = ff;
        ee.prev = dd;
        ff.prev = ee;
        ff.next = null;
        display(aa);

        gg.prev = null;
        gg.next = hh;
        hh.prev = gg;
        hh.next = ii;
        ii.prev = hh;
        ii.next = jj;
        jj.prev = ii;
        jj.next = null;
        display(gg);

        kk.prev = null;
        kk.next = ll;
        ll.prev = kk;
        ll.next = null;
        display(kk);

        // Connecting with Child Node
        cc.child = gg;
        hh.child = kk;

        // Converting these doubly list to single list
        Node newhead = flatterDoublyList(aa);
        display(newhead);

    }
}
