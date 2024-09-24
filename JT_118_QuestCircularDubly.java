public class JT_118_QuestCircularDubly {
    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(" " + temp.data);
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
//    Q1) Find Two Sum in doubly linked list which is sorted in non decreasing order which is equal to target
    static void twoSumTarget(Node head,int target){
        Node temp = head;
        int size = 0;
        while (temp!=null){
            temp = temp.next;
            size++;
        }
        Node first = head;
        Node last = head;
       for (int i =0;i<size-1;i++){
           last = last.next;
       }
       while (first.data< last.data){
           if(first.data+ last.data ==target){
               System.out.println(first.data+" and "+last.data);
               return;
           }
          else   if(first.data+last.data>target){
               last = last.prev;
           }
           else if (first.data+last.data<target){
               first = first.next;
           }
       }
        System.out.println("Not Target Found");
    }
//    Q2) Find the critical points in doubly linked list (minima and maxima)
    static void criticalPoints(Node head){
        Node temp = head.next;
        Node critical = new Node(-1);
        Node crty = critical;
        int minima = 0;
        int maxima = 0;
        while (temp.next!=null){
            if(temp.next.data>temp.data && temp.prev.data > temp.data){
                Node tempo = new Node(temp.data);
                crty.next = tempo;
                crty = crty.next;
                temp = temp.next;

            }
          else   if(temp.next.data<temp.data && temp.prev.data <temp.data){
                Node tempo = new Node(temp.data);
                crty.next = tempo;
                crty = crty.next;
                temp = temp.next;
            }
            temp=temp.next;
        }
        display(critical.next);
    }
//    Q3) (LEETCODE 430) Flatten a multilevel doubly linked list
    public static void main(String[] args) {
        Node a = new Node(3);
        Node b = new Node(15);
        Node c = new Node(8);
        Node d = new Node(13);
        Node e = new Node(100);

        a.next = b;
        b.next = c;
        b.prev = a;
        c.next = d;
        c.prev = b;
        d.next = e;
        d.prev = c;
        e.prev = d;
//        display(a);// printing by head
//        twoSumTarget(a,16);

        Node aa = new Node(1);
        Node bb = new Node(2);
        Node cc = new Node(5);
        Node dd = new Node(3);
        Node ee = new Node(2);
        Node ff = new Node(7);
        Node gg = new Node(8);
        Node hh = new Node(9);
        Node ii = new Node(1);
        Node jj = new Node(10);
        /*
        * 5 -> maxima
        * 2 -> minima
        * 9 -> maxima
        * */
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
        ff.next = gg;
        gg.prev = ff;
        gg.next = hh;
        hh.prev = gg;
        hh.next = ii;
        ii.prev = hh;
        ii.next = jj;
        jj.prev = ii;
        jj.next = null;
        display(aa);
        criticalPoints(aa);
    }
}
