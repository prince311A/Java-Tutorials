public class JT_131_Array_ImplementQueue {
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
    // Implementing Queue using Array
    public static class Queueue{
        private int []arr = new int[5];
        private int front = -1;
        private int rear = -1;
        private int size = 0;

        void add(int ele){
            if(rear==arr.length-1){
                System.out.println("Queue is full");
                return;
            }
            if(front==-1&&rear==-1){
                arr[rear+1] =ele;
                rear++;
                front++;
            }
            else {
                arr[rear+1] = ele;
                rear++;
            }
            size++;
        }
        int remove(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
           front++;
            size--;
           return arr[front-1];
        }
        int peek(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }
        void display(){
            if(size==0){
                System.out.println("Queue is Empty");
                return;
            }
            for(int i = front;i<=rear;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        boolean isEmpty(){
            if(size==0)return true;
            else return false;
        }
    }
    public static void main(String[] args) {
        Queueue q1 = new Queueue();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        System.out.println(q1.peek());//1
        System.out.println(q1.remove());//1
        System.out.println(q1.peek());//2
        q1.display();//2,3,4,5
    }
}
