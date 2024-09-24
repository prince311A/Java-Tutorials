public class JT_123_ImplementStackLL {
    /*Implement the methods of stack
     * push()
     * pop()
     * peek()
     * size()
     * display()
     * isEmpty()
     * isFull()
     * capacity
     */
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static class Stakk1 {
        private Node head = null;
        int size = 0;

        void push(int ele) {
            Node temp = new Node(ele);
            temp.next = head;
            head = temp;
            size++;
        }

        int peek() {
            if (size == 0) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return head.data;
        }

        int pop() {
            if (size == 0) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = head.data;
            head = head.next;
            size--;
            return top;
        }

        void displayRev(Node tempo) {
            if(tempo==null)return;
            displayRev(tempo.next);
            System.out.print(tempo.data+" ");
        }
        void display(){
            displayRev(head);
            System.out.println();
        }
    }
        public static void main(String[] args) {
        Stakk1 st = new Stakk1();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
            System.out.println(st.size);//4
            System.out.println(st.peek());//4
            st.pop();
            System.out.println(st.peek());//3
            st.display();//1 2 3
            System.out.println(st.size);//3
            st.push(5);
            st.push(7);
            st.display();// 1 2 3 5 7
        }
}
