public class JT_132_LL_ImplementQueue {
    /*QUEUE methods:-
     * add()
     * remove()
     * peek()
     * size()
     * display()
     * isFull()
     * isEmpty()
     * isCapacity
     * */
    // Implementing Queue using LinkedList

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public static class Queue1{
        private Node head = null;
        private Node tail = null;
        private int size = 0;
        public void add(int ele){
            if(size==0){
                Node temp = new Node(ele);
                head = temp;
                tail = temp;
            }
            else{
                Node temp = new Node(ele);
                tail.next = temp;
                tail = temp;
            }
            size++;
        }
        public int remove(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
            int x = head.data;
            head = head.next;
            size--;
            return x;
        }
        public int peek(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
            return head.data;
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
            if (size==0){
                return true;
            }
            else return false;
        }
        public void display() {
            Node temp = head;
            while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Queue1 q1 = new Queue1();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.display();//1,2,3,4
        System.out.println(q1.peek());//1
        System.out.println(q1.size);//4
        System.out.println(  q1.remove());//1
        System.out.println(q1.remove());//2
        System.out.println(q1.peek());//3
        System.out.println(q1.size);//2
        q1.display();//3,4

    }
}
