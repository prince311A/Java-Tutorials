public class JT_109_InsertLinkedList {
    static void display(Node temp){
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();

    }
    static void insertionAtEnd(Node temp,Node fresh){
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = fresh;
    }
    public static class Node{
        int data;
        Node next ;
        Node(int data){
            this.data = data;
        }

        public static void main(String[] args) {
            Node a = new Node(5);
            Node b = new Node(4);
            Node c = new Node(8);
            Node d = new Node(6);
            Node e = new Node(1);

            // Linking
            a.next = b;
            b.next = c;
            c.next = d;
            d.next = e;

            Node fresh = new Node(99);
            insertionAtEnd(a,fresh);

            //printing linked list
            display(a);


        }
    }
}

