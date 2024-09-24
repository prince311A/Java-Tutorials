import java.util.Arrays;
import java.util.Stack;

public class JT_125_StackQuest {
//   Q1) Given the sequence of number. Remove all the consecutive subsequences of length two or greater than two that contain same element
    public static int[] subsequence(int arr[]){
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<arr.length;i++){
            if(st.size()==0||st.peek()!=arr[i])st.push(arr[i]);
         else if(st.peek()==arr[i]){
              if(i==arr.length-1 || arr[i]!=arr[i+1])st.pop();
          }
        }
        int res[] = new int[st.size()];
        for(int i = res.length-1;i>=0;i--){
            res[i] = st.pop();
        }
        return res;
    }
//    Q2) Next Greater Element using iterative approach
    static int[] iterativeNextGreater(int []arr){
        int res[] = new int[arr.length];
        int idx =0;
        for(int i =0;i<arr.length;i++){
            int j;
            for(j=i+1;j<arr.length;j++){
                if(arr[i]<arr[j]){
//                    System.out.println(arr[j]);
                    res[idx++] = arr[j];
                    break;
                }
            }
            if(j==arr.length)
//                System.out.println(-1);
                res[idx++] = -1;
        }
        return res;
    }
    // Use STACK
    /*Approach {1, 3, 2, 1, 8, 6, 3, 4,10} ==>[3, 8, 8, 8, 10, 10, 4, 10, -1]
    * We know that there is no next greater of last element So...
    * We have to travel the array backward (right to left)
    * */
    static int[] nextGreater(int arr[]){
        int []res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        res[res.length-1] = -1;
        for(int i =arr.length-2;i>=0;i--){
//            if(st.peek()>arr[i]){ // after commenting its working the same
//                res[i] = st.peek();
//                st.push(arr[i]);
//            } else if (st.peek()<arr[i]) {
                while (st.size()!=0 && st.peek()<arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res[i]=-1;
//                    st.push(arr[i]);

                }
                else{
                    res[i] = st.peek();
//                    st.push(arr[i]);
                }
            st.push(arr[i]); // doing same work
//            }
        }
        return res;
    }
    // Another approach using stack but traversing forward (left to right)
    static int[]  nextGreaterForward(int []arr){
        int res[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
//        st.push(0);
        for(int i =0;i<arr.length;i++) {
            if(st.size()==0)st.push(i);
            if(arr[i]>arr[st.peek()]) {
                while (st.size()!=0&&arr[i] > arr[st.peek()]) {
                    res[st.peek()] = arr[i];
                    st.pop();
//                st.push(i);
                }
                st.push(i);
            }

//            else if (arr[st.peek()]>arr[i]) {
            while (arr[i]<arr[st.peek()]) {
                st.push(i);
            }
        }
//        }
        return res;
    }
    //    Q3)  Next Smaller Element using iterative approach
    static void nextSmallerElement(int []arr){
        int res[] = new int[arr.length];
        int idx = 0;
        for(int i=0;i<arr.length;i++){
            int j;
            for( j = i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    res[idx++] = arr[j];
//                    System.out.println(arr[j]);
                    break;
                }
            }
            if(j== arr.length) {
                res[idx++] = -1;
//                System.out.println(-1);
            }
        }
        System.out.println(Arrays.toString(res));
    }
    // next smaller element using stack
    static int[] nextsmallerStack(int []arr){
        int res[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        res[arr.length-1] = -1;
        int idx = arr.length-2;
        for(int i = arr.length-2;i>=0;i--){
            while (st.size()!=0&&st.peek()>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                res[idx--] = -1;
            }
            else if(arr[i]>st.peek()){
                res[idx--] = st.peek();
            }
            st.push(arr[i]);
        }

        return res;

    }
    public static void main(String[] args) {
//        int arr[] = {1,9, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7, 2};
//     int res[]  =  subsequence(arr);
//        System.out.println(Arrays.toString(res));

        int arr1[] = {1, 3, 2, 1, 8, 6, 3, 4,10};
    int res1[] =  iterativeNextGreater(arr1);
        System.out.println(Arrays.toString(res1));

        int[] res2 = nextGreater(arr1);
        System.out.println(Arrays.toString(res2));

        int []res3 = nextGreaterForward(arr1);
        System.out.println(Arrays.toString(res3)); // insted of -1 there is 0

        nextSmallerElement(arr1);
        int res4[] = nextsmallerStack(arr1);
        System.out.println(Arrays.toString(res4));
    }
}
