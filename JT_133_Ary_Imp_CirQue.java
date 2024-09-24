public class JT_133_Ary_Imp_CirQue {
    //NOTE:- We can also implement circular queue using linked-list, it is ver easy...we just have to point the tail to head everytime when we add,
    //       when we want to remove we change the tail.next = new-head
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
    // Implementing CircularQueue using Array
    public static class Queue2{
        private int arr[] = new int[5];
        private  int front = -1;
        private int rear = -1;
        private int size = 0;
        public void add(int ele) throws Exception{
            if(size==arr.length){
//                System.out.println("Queue is Full");
//                return;
                throw new Exception("Queue is Full");
            }
            if(size==0){
                arr[rear+1] = ele;
                front++;
                rear++;
            }
            else if(rear<arr.length-1) {
                arr[rear+1] = ele;
                rear++;
            }
            else if(rear==arr.length-1){
                rear = 0;
                arr[rear] = ele;
            }
            size++;
        }
        public int remove() throws Exception{
            if(size==0){
                throw new Exception("Queue is Empty");
//                System.out.println("Queue is Empty");
//                return -1;
            }
            else if(front==arr.length-1){
                int x = arr[front];
                front = 0;
                size--;
                return x;
            }
            int x = arr[front];
            front++;
            size--;
            return x;
        }
        public int peek()throws Exception{
            if(size==0){
                throw new Exception("Queue is Empty");
//                System.out.println("Queue is Empty");
//                return -1;
            }
            return arr[front];
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public void display(){
            if(rear>=front){
                for(int i = front;i<=rear;i++){
                    System.out.print(arr[i]+" ");
                }
            } else  {
                for(int i = front;i<= arr.length-1;i++){
                    System.out.print(arr[i]+" ");
                }
                for(int i =0;i<=rear;i++){
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
        }
        public int size(){
            return size;
        }
    }
    public static void main(String[] args) throws Exception{
        Queue2 que1 = new Queue2();
        que1.add(1);
        que1.add(2);
        que1.add(3);
        que1.add(4);
        que1.add(5);

        System.out.println(que1.size());//5
        que1.display();//1,2,3,4,5
        System.out.println(que1.remove());//1
        System.out.println(que1.size);//4
        que1.display();//2,3,4,5
    }
}

