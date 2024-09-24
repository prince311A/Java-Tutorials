import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class JT_126_StackQuest {
    //    Q1) Previous Greater Element using iterative approach
    static void iterativePreviousGreater(int []arr){
        int res[] = new int[arr.length];
        int idx = arr.length-1;
        for(int i =arr.length-1;i>=0;i--){
            int j ;
            for( j = i-1;j>=0;j--){
                if(arr[i]<arr[j]){
                    res[idx--] = arr[j];
//                    System.out.println(arr[j]);
                    break;
                }
            }
            if(j<0)res[idx--] = -1;
//                System.out.println(-1);

        }
        System.out.println(Arrays.toString(res));
    }
    // Use Stack
    /*Approach {100,80,60,70,60,75,85} ==>[-1, 100, 80, 80, 70, 80, 100]
     * We know that there is no previous greater of first element So...
     * We have to travel the array in Forward (left to right)
     * */
    static void previousGreater(int []arr){
        Stack<Integer> st = new Stack<>();
        int []res = new int[arr.length];
        res[0] = -1;
        st.push(arr[0]);
        for(int i =1;i<arr.length;i++) {
            if (arr[i] < st.peek()) {
                res[i] = st.peek();
                st.push(arr[i]);
            } else {
                while (st.size() != 0 && st.peek()<arr[i]){
                    st.pop();
                }
                if(st.size()==0){
                    st.push(arr[i]);
                    res[i] = -1;
                }
                else{
                    res[i] = st.peek();
                    st.push(arr[i]);
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }
       // Another approach using stack but traversing backward (right to left)
    static int[] previousGreaterBackward(int[]arr){
        int[] res = new int[arr.length];
        Stack<Integer>st = new Stack<>();
        for(int i =arr.length-1;i>=0;i--){
            if(st.size()==0)st.push(i);
            if(arr[i]<arr[st.peek()]){
                while (st.size()!=0 && arr[i]<arr[st.peek()]){
                    st.push(i);
                }
            } else if (arr[i]>arr[st.peek()]) {
                while (st.size()!=0 && arr[i]>arr[st.peek()]) {
                    res[st.peek()] = arr[i];
                    st.pop();
                }
                st.push(i);

            }
        }
        return res;
    }
//    Q2)  Previous Smaller Element using iterative approach
static void previousSmallerElement(int []arr){
    int res[] = new int[arr.length];
    int idx = arr.length-1;
    for(int i=arr.length-1;i>=0;i--){
        int j;
        for( j = i-1;j>=0;j--){
            if(arr[i]>arr[j]){
                res[idx--] = arr[j];
//                    System.out.println(arr[j]);
                break;
            }
        }
        if(j<0) {
            res[idx--] = -1;
//                System.out.println(-1);
        }
    }
    System.out.println(Arrays.toString(res));
}
// previous smaller element using stack
    static int[] previoussmallerStack(int []arr){
        int res[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        res[0] = -1;
        int idx = 1;
        for(int i = 1;i<arr.length;i++){
            while (st.size()!=0&&st.peek()>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                res[idx++] = -1;
            }
            else if(arr[i]>st.peek()){
                res[idx++] = st.peek();
            }
            st.push(arr[i]);
        }

        return res;

    }
    public static void main(String[] args) {
        int []arr = {100,80,60,70,60,75,85};
//        iterativePreviousGreater(arr);
//        previousGreater(arr);

        int []res = previousGreaterBackward(arr);
//        System.out.println(Arrays.toString(res));// insted of -1 there is 0

        previousSmallerElement(arr);
        int res1[] = previoussmallerStack(arr);
        System.out.println(Arrays.toString(res1));

    }
}
