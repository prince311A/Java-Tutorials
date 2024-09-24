public class JT_119_CopyListWithPointer {
    /*
     * Copy Linked With Random Pointer (LEETCODE 138)
     * */
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
        Node random;
        Node(int data){
            this.data = data;
        }
    }
    static void deepCopyWithRandomPointer(Node head){
        Node temp = head.next;
        Node copy = new Node(head.data);
        Node tempCopy = copy;
        while (temp!=null){   // Step 1- Creating Simple Deep Copy
            Node tempo = new Node(temp.data);
            tempCopy.next = tempo;
            tempCopy = tempCopy.next;
            temp = temp.next;
        }
        display(copy);

        // Step 2- Connecting both original and copied list with alternate connections
        Node t1 = head;
        Node t2 = copy;
        Node t = new Node(-1);
        Node t3 = t;
        while (t1!=null){
            t3.next = t1;
            t1 = t1.next;
            t3 = t3.next;

            t3.next = t2;
            t2 =t2.next;
            t3 = t3.next;

        }
        display(t);
        // Step 3- Assigning random pointers to its position
        t3 = t;
        t1 = head;
        t2 = copy;
        // Step 4- One line to connect this
        while (t1!=null){
            if(t1.random==null){
                t2.random = null;
            }
            else {
                t2.random = t1.random.next;
            }
                t1 = t2.next;
            if(t1!=null) {
                t2 = t1.next;
            }
        }
        // Step 4- Seperating both linked list copied and original
        t1 = head;
        t2 = copy;
        while (t1!=null){
            t1.next = t2.next;
            t1 = t1.next;

            if(t1==null)break;
            t2.next = t1.next;
            if(t2.next==null)break;
            t2 = t2.next;
        }
        display(copy);
        display(head);
    }
    public static void main(String[] args) {
        Node a = new Node(7);//2
        Node b = new Node(13);//7
        Node c = new Node(10);//4
        Node d = new Node(11);//55
        Node e = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        a.random = null;
        b.random = a;
        c.random= e;
        d.random = c;
        e.random = a;

//        display(a);w
        deepCopyWithRandomPointer(a);
    }
}
