public class JT_117_CircularLiist {
    static void display(Node head){
        Node temp = head.next;
        System.out.print(head.data);
        while (head!=temp){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
    static void displayWithRandomNode(Node random){
        Node temp = random.next;
        System.out.print(random.data);
        while (temp!=random){
            System.out.print(" "+ temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
    public static class Node{
        Node prev;
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
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
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = a;

        display(a);
        displayWithRandomNode(c);
    }
}
