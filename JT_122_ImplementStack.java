public class JT_122_ImplementStack {
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
    public static class Stackk{
        private int arr[] = new int[5];
        private int idx = 0;

        void push(int ele){
            if(isFull()){
                System.out.println("Stack is Full");
                return;
            }
            arr[idx] = ele;
            idx++;
        }
        int peek(){
            if(idx==0){
                System.out.println("Stack is Empty");
                return -1;
            }
            return arr[idx-1];
        }
        int pop(){
            if(idx==0){
                System.out.println("Stack is Empty");
                return -1;
            }
            int top = arr[idx-1];
            arr[idx-1] = 0;
            idx--;
            return top;
        }
        void display(){
            for(int i =0;i<=idx-1;i++){
                System.out.print(" "+arr[i]);
            }
            System.out.println();
        }
        int size(){
            return idx;
        }
        boolean isEmpty(){
            if(idx==0)return true;
            else return false;
        }
        boolean isFull(){
            if(idx==arr.length)return true;
            else return false;
        }
        int capacity(){
            return arr.length;
        }
    }
    public static void main(String[] args) {
        Stackk st1 = new Stackk();
        st1.push(1);
        st1.push(2);
        st1.push(3);
        st1.push(4);
        st1.display();//1 2 3 4
        st1.pop();
        st1.display();//1 2 3
        System.out.println(st1.peek());//3
        st1.push(5);
        System.out.println(st1.isFull());//false
        System.out.println(st1.size());//4
        System.out.println(st1.isEmpty());//false
        System.out.println(st1.capacity());//5

    }
}
