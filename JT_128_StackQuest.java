import java.util.Arrays;
import java.util.Stack;

public class JT_128_StackQuest {
    // next smaller element using stack
    static int[] nextsmallerStack(int []arr){
        int nextsmall[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length-1]);
        nextsmall[arr.length-1] = arr.length;
        int idx = arr.length-2;
        for(int i = arr.length-2;i>=0;i--){
            while (st.size()!=0&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                nextsmall[idx--] = arr.length;
            }
            else if(arr[i]>arr[st.peek()]){
                nextsmall[idx--] = st.peek();
            }
            st.push(i);
        }

        return nextsmall;

    }
    // previous smaller element using stack
    static int[] previoussmallerStack(int []arr){
        int prevsmall[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        prevsmall[0] = -1;
        int idx = 1;
        for(int i = 1;i<arr.length;i++){
            while (st.size()!=0&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                prevsmall[idx++] = -1;
            }
            else if(arr[i]>arr[st.peek()]){
                prevsmall[idx++] = st.peek();
            }
            st.push(i);
        }

        return prevsmall;
    }
    // LEETCODE(hard)
    static void largestAreaHistogram(int arr[]){
        int nextsmall[] = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        nextsmall[arr.length-1] = arr.length;
//        int idx = arr.length-2;
        for(int i = arr.length-2;i>=0;i--){
            while (st.size()!=0&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                nextsmall[i] = arr.length;
            }
            else if(arr[i]>arr[st.peek()]){
                nextsmall[i] = st.peek();
            }
            st.push(i);
        }
        System.out.println(Arrays.toString(nextsmall));
        int prevsmall[] = new int[arr.length];
        Stack<Integer> st1 = new Stack<>();
        st1.push(0);
        prevsmall[0] = -1;
//        int idx1 = 1;
        for(int i = 1;i<arr.length;i++){
            while (st1.size()!=0&&arr[st1.peek()]>=arr[i]){
                st1.pop();
            }
            if(st1.size()==0){
                prevsmall[i] = -1;
            }
            else if(arr[i]>arr[st1.peek()]){
                prevsmall[i] = st1.peek();
            }
            st1.push(i);
        }
        System.out.println(Arrays.toString(prevsmall));
        // BEST  OPTIMIZE FORMULA ==> if next-small is -1 make it arr.length, if previous small is -1 make it -1
        // then formula is ==> (next-small-previous-small)-1
        int max = -1;
        int area= 0;
        for(int i =0;i<arr.length;i++){
             area = arr[i]*(nextsmall[i]-prevsmall[i]-1);
            if(max<area){
                max = area;
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        int []arr = {5,2,4,6,3,5};// o/p 12
        int []arr1 = {2,1,5,6,2,3}; // leetcode o/p 10
//        int res[] = nextsmallerStack(arr);
//        System.out.println(Arrays.toString(res));
//        int res1[] = previoussmallerStack(arr);
//        System.out.println(Arrays.toString(res1));

        largestAreaHistogram(arr);
    }
}
