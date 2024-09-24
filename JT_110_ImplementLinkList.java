public class JT_110_ImplementLinkList {
    /*
    * Here we are making various functions of linked list manually:-
    * display() elements of linked list TC.O(n)
    * size() of linked list TC.O(n)
    * insertAtStart() TC.O(1)
    * insertAtMiddle() TC.O(n)
    * insertAtEnd() TC.O(1)
    * getElement() fetching the element by giving index of linked list  TC.O(n)
    * deleteAtIndex()
    * deleteAtStart()
    * deleteAtLast()
    * */
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }
    public static  class linkedlist{
        Node head = null;
        Node tail = null;
        int size = 0; // we can make a function or class variable to find the size of list

        void insertAtStart(int val){
            Node temp = new Node(val);
            if(head==null){
                head = temp;
                tail = temp;
            }
            else{
                temp.next = head;
                head = temp;
            }
            size++;
        }

        void insertAtMiddle(int idx,int val) {
                    Node temp = new Node(val);
                    Node search = head;

                    // inserting element when idx equal to size or greater than size
                    if(idx==size()){
                        insertAtTheEnd(val);
                        return;
                    }

                    // inserting when idx = 0
                  else if(idx == 0){
                        insertAtStart(val);
                        return;
                    }

                  // inserting when idx<0
                    else if (idx<0 || idx>size()){
                        System.out.println("Invalid Index");
                        return;
                    }

                    for (int i = 0; i < idx - 1; i++){
                        search = search.next;
                }
            // swapping
                    temp.next = search.next;
                    search.next= temp;
                    size++;
            }
        void insertAtTheEnd(int val){
            Node temp = new Node(val);
            if(head==null){
                head = temp;
                tail = temp;
            }
            else{
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        void display(){
            Node temp = head;
            while (temp!=null){
                System.out.print(temp.data+" ");
                temp = temp.next;
            }
            System.out.println();
        }
        int size(){
//            int count = 0;
//            Node temp = head;
//            while(temp!=null){
//                count++;
//                temp = temp.next;
//            }
//            return count;
            return size;
        }

        int getElement(int idx){
        Node temp = head;
        for(int i =1;i<=idx;i++){
            temp = temp.next;
        }
            return temp.data;
        }

        void deleteAtIndex(int idx){ // 8->11->9->5->99->7   (3)
            Node temp = head;
            if(idx==0){
                deleteAtStart();
                return;
            }
            else if(idx==size){
                deleteAtLast();
                return;
            }
            for(int i =0;i<idx-1;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
        void deleteAtLast(){
            Node temp = head;
            while(temp.next.next!=null){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            size--;
        }

        void deleteAtStart(){
            Node temp = head;
            head = temp.next;
            size--;
        }
    }

    public static void main(String[] args) {
        linkedlist l1 = new linkedlist();
        l1.insertAtTheEnd(5); // inserting element at the end of list
        //  l1.display(); // printing elements of linked list

        l1.insertAtTheEnd(7);  // 5->7
        //  l1.display();

       // System.out.println("Sze of l1 is "+l1.size()); // length of the linked list

        l1.insertAtStart(11); // 11->5->7
       // l1.display();

          l1.insertAtMiddle(1,9); // 11->9->5->7
       // l1.display();

        l1.insertAtMiddle(3,99); // 11->9->5->99->7
       // l1.display();

        l1.insertAtMiddle(0,8); // 8->11->9->5->99->7
        l1.display();

        System.out.println(l1.getElement(5));

        l1.deleteAtIndex(3);  // 8->11->9->99->7
       // l1.display();

         l1.deleteAtLast(); // 8->11->9->99-
       // l1.display();

      //  l1.deleteAtStart(); // 11->9->99->7
//        l1.display();


    }
}
