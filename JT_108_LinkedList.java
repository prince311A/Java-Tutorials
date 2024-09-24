public class JT_108_LinkedList {
    static void displayRecursive(Node temp){
        if(temp==null)return;

        System.out.print(temp.data+" ");
        displayRecursive(temp.next);
    }
    public static class Node{
        int data; // store the data part of node
        Node next ; // store the address of next node

        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node a = new Node(7);
        Node b = new Node(4);
        Node c = new Node(6);
        Node d = new Node(9);
        Node e = new Node(2);
        //  Now we have to link the every node to each other
        //  a->b->c->d->e lets link one by one
        // System.out.println("a = "+a.data); // a;7

        a.next =b; // a->b
        // printing the data part of every node by help of first node
        // System.out.println("b = "+a.next.data); // b;4

        b.next = c; // a->b->c
        // System.out.println("c = "+a.next.next.data); // c;6

        c.next = d; // a->b->c->d
        // System.out.println("d = "+a.next.next.next.data); //d;9

        d.next =e; // a->b->c->d->e
        //  System.out.println("e = "+a.next.next.next.next.data); // e;2

        /* NOTE:- The last node is always null by default because the we do not putting any thing on it and it is null
                 Because default value of class member Node  is null */

        // Printing all the elements of linked list by the help of loop

        Node temp = a;
        int length =0;
        while(temp!=null){
            System.out.print(temp.data+" ");
            length++;
            temp = temp.next;
        }
        System.out.println();
        System.out.println("Length of linked list is "+length);

        //System.out.println("Displaying linked list by recursion ");
        // displayRecursive(a);

    }
}
